package com.dandare.batch.config;


import com.dandare.batch.entity.Organization;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

// ---- TODO 2 --------
@RequiredArgsConstructor
@Configuration
@EnableBatchProcessing
public class CsvFileBatchConfig {

//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//    private final DataSource dataSource;


    @Bean
    public FlatFileItemReader<Organization> productItemReader()
    {
        return new FlatFileItemReaderBuilder<Organization>()
                .name("productItemReader")
                .resource(new ClassPathResource("organizations-2000000.csv"))
                .delimited()
                .delimiter(",")
                .names(new String[] { "id", "organizationId",
                        "name", "webSite",
                        "country" , "description", "founded", "industry", "numberOfEmployees"})
                .linesToSkip(1)
                .fieldSetMapper(
                        new BeanWrapperFieldSetMapper<Organization>() {
                            {
                                setTargetType(Organization.class);
                            }
                        })
                .build();
    }

    @Bean
    public Step saveOrganizationStep(
            JobRepository jobRepository,
            ItemReader<Organization> productItemReader,
            OrganizationWriter organizationWriter,
            PlatformTransactionManager transactionManager) {

        // this step reads the csv and writes the entries into the database
        return new StepBuilder("name-step", jobRepository)
                .<Organization, Organization>chunk(100, transactionManager)
                .reader(productItemReader)
//                .processor(processor)
                .writer(organizationWriter)
                .build();
    }


    @Bean
    public Job job(
            JobRepository jobRepository,
            Step saveOrganizationStep) {

        return new JobBuilder("organization-loader-job", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(saveOrganizationStep)
//                .next(designationStep)
                .build();
    }
}
