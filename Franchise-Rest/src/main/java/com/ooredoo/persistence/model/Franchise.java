package com.ooredoo.persistence.model;

import org.hibernate.annotations.Type;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "franchise")
public class Franchise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String applicantName;
    private String idNumber;
    @Nullable
    @Type(type="date")
    private Date birthDate;
    private String contactAddress;
    private String contactEmail;
    private String contactphone;
    @Column(columnDefinition = "LONGTEXT")
    private String previousBusinessExperience;
    private String brandInterest;
    private Double plannedInvestmentAmount;
    private String  geographicalAreaToOperate;
    @Column(columnDefinition = "LONGTEXT")
    @Nullable
    private String  additionalNotes;
    private boolean enabled = true;
    private Date createdDate;
    private int createdBy = 1; //will be replaced with the user_id when login flow is implemented
    private Date modifiedDate;
    private int modifiedBy = 1; //will be replaced with the user_id when login flow is implemented


    public Franchise() { }

    public Franchise(String applicantName, String idNumber, Date birthDate, String contactAddress, String contactEmail, String contactphone, String previousBusinessExperience, String brandInterest,
                     Double plannedInvestmentAmount, String  geographicalAreaToOperate, String  additionalNotes, boolean enabled) {
        this.applicantName = applicantName;
        this.idNumber = idNumber;
        this.birthDate = birthDate;
        this.contactAddress = contactAddress;
        this.contactEmail = contactEmail;
        this.contactphone = contactphone;
        this.previousBusinessExperience = previousBusinessExperience;
        this.brandInterest = brandInterest;
        this.plannedInvestmentAmount = plannedInvestmentAmount;
        this.geographicalAreaToOperate = geographicalAreaToOperate;
        this.additionalNotes = additionalNotes;
        this.enabled = enabled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactphone() {
        return contactphone;
    }

    public void setContactphone(String contactphone) {
        this.contactphone = contactphone;
    }

    public String getPreviousBusinessExperience() {
        return previousBusinessExperience;
    }

    public void setPreviousBusinessExperience(String previousBusinessExperience) {
        this.previousBusinessExperience = previousBusinessExperience;
    }

    public String getBrandInterest() {
        return brandInterest;
    }

    public void setBrandInterest(String brandInterest) {
        this.brandInterest = brandInterest;
    }

    public Double getPlannedInvestmentAmount() {
        return plannedInvestmentAmount;
    }

    public void setPlannedInvestmentAmount(Double plannedInvestmentAmount) {
        this.plannedInvestmentAmount = plannedInvestmentAmount;
    }

    public String getGeographicalAreaToOperate() {
        return geographicalAreaToOperate;
    }

    public void setGeographicalAreaToOperate(String geographicalAreaToOperate) {
        this.geographicalAreaToOperate = geographicalAreaToOperate;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @PrePersist
    protected void prePersist() {
        createdDate = new Date();
    }

    @PreUpdate
    protected void PreUpdate() {
        modifiedDate = new Date();
    }
}
