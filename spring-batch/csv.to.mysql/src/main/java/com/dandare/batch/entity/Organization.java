package com.dandare.batch.entity;


//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;

//@Data
//@AllArgsConstructor
//@RequiredArgsConstructor
@Entity
//@Getter
//@Setter
public class Organization {

    @Id
    private String id;
    private String organizationId;
    private String name;
    private String webSite;
    private String country;
    private String description;
    private String founded;
    private String industry;
    private String numberOfEmployees;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFounded() {
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organization that)) return false;
        return getId().equals(that.getId()) && getOrganizationId().equals(that.getOrganizationId()) && getName().equals(that.getName()) && getWebSite().equals(that.getWebSite()) && getCountry().equals(that.getCountry()) && getDescription().equals(that.getDescription()) && getFounded().equals(that.getFounded()) && getIndustry().equals(that.getIndustry()) && getNumberOfEmployees().equals(that.getNumberOfEmployees());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOrganizationId(), getName(), getWebSite(), getCountry(), getDescription(), getFounded(), getIndustry(), getNumberOfEmployees());
    }

    public Organization(String id, String organizationId, String name, String webSite, String country, String description, String founded, String industry, String numberOfEmployees) {
        this.id = id;
        this.organizationId = organizationId;
        this.name = name;
        this.webSite = webSite;
        this.country = country;
        this.description = description;
        this.founded = founded;
        this.industry = industry;
        this.numberOfEmployees = numberOfEmployees;
    }

    public Organization() {
    }
}
