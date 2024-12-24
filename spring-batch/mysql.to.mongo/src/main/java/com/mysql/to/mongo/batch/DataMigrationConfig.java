package com.mysql.to.mongo.batch;

import com.mysql.to.mongo.primary.entity.Organization;
import com.mysql.to.mongo.primary.repo.OrganizationRepository;
import com.mysql.to.mongo.secondary.entity.Company;
import com.mysql.to.mongo.secondary.repo.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.HashMap;

@Configuration
@EnableBatchProcessing
public class DataMigrationConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();

    }
    @Bean
    public ItemReader<Organization> organizationReader(OrganizationRepository organizationRepository){
        RepositoryItemReader<Organization> reader = new RepositoryItemReader<>();
        reader.setRepository(organizationRepository);
        reader.setMethodName("findAll");
//        reader.setArguments(Collections.singletonList(maxId));
        reader.setPageSize(100);

        HashMap<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("id", Sort.Direction.ASC);
        reader.setSort(sorts);
        return reader;
    }


    @Bean
    ItemProcessor<Organization, Company> companyItemProcessor(){
        return item -> {
            return modelMapper().map(item, Company.class);
        };
    }

    @Bean
    ItemWriter<Company> companyWriter(CompanyRepository companyRepository){

       return new ItemWriter<Company>(){

            @Override
            public void write(Chunk<? extends Company> chunk) throws Exception {
                companyRepository.saveAll(chunk);
            }

        };
//        return items -> {
//            companyRepository.saveAll(items);
//        }
    }

    @Bean
    public Step saveOrganizationStep(
            JobRepository jobRepository,
            ItemReader<Organization> organizationReader,
            ItemProcessor<Organization, Company> companyItemProcessor,
            ItemWriter<Company> companyWriter,
            PlatformTransactionManager transactionManager) {

        // this step reads the csv and writes the entries into the database
        return new StepBuilder("save-org-step", jobRepository)
                .<Organization, Company>chunk(100, transactionManager)
                .reader(organizationReader)
                .processor(companyItemProcessor)
                .writer(companyWriter)
                .build();
    }


    @Bean
    public Job job(
            JobRepository jobRepository,
            Step saveOrganizationStep) {

        return new JobBuilder("save-org-job", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(saveOrganizationStep)
//                .next(designationStep)
                .build();
    }


}
