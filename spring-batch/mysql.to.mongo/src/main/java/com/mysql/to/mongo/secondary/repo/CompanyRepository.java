package com.mysql.to.mongo.secondary.repo;

import com.mysql.to.mongo.secondary.entity.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {
}
