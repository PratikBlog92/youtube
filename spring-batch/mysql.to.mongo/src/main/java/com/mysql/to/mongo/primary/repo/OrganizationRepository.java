package com.mysql.to.mongo.primary.repo;

import com.mysql.to.mongo.primary.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, String> {
}
