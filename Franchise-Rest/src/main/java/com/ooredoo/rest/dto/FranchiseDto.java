package com.ooredoo.rest.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class FranchiseDto implements Serializable {

	private long id;
	@NotNull ( message = "Application Name cannot be missing or empty!")
	private String applicantName;
	@NotNull( message = "Id Number cannot be missing or empty!")
	private String idNumber;
	private Date birthDate;
	@NotNull( message = "Contact Address cannot be missing or empty!")
	private String contactAddress;
	@NotNull( message = "Contact Email cannot be missing or empty!")
	@Email (message = "The email must be a valid email address!")
	private String contactEmail;
	@NotNull( message = "Contact phone cannot be missing or empty!")
	private String contactphone;
	@NotNull( message = "PreviousBusinessExperience cannot be missing or empty!")
	private String previousBusinessExperience;
	@NotNull( message = "BrandInterest cannot be missing or empty!")
	private String brandInterest;
	@NotNull( message = "PlannedInvestmentAmount cannot be missing or empty!")
	private Double plannedInvestmentAmount;
	@NotNull( message = "GeographicalAreaToOperate cannot be missing or empty!")
	private String  geographicalAreaToOperate;
	private String  additionalNotes;

	public FranchiseDto() { }

	public FranchiseDto(String applicantName, String idNumber, Date birthDate, String contactAddress, String contactEmail, String contactphone, String previousBusinessExperience, String brandInterest,
					 Double plannedInvestmentAmount, String  geographicalAreaToOperate, String  additionalNotes) {
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

}
