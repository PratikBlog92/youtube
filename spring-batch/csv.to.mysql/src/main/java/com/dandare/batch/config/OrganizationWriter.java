package com.dandare.batch.config;

import com.dandare.batch.entity.Organization;
import com.dandare.batch.repo.OrganizationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//@Slf4j
//@AllArgsConstructor
@Component
public class OrganizationWriter implements ItemWriter<Organization> {


    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public void write(Chunk<? extends Organization> chunk) throws Exception {
        organizationRepository.saveAll(chunk);
//        System.out.println("saved Organization : "+ chunk);
    }
}
