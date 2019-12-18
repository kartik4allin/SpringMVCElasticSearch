package com.example.springmvc.model;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="healthdata",type="_doc",shards=1)
public class HealthData {
	
	private String id;
	private int age;
	private String gender;
	private String address;
	private String reportDate;
	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	private String purposeOfVisit;
	private String mainComplaint;
	private String pastOcularHistory;
	private String pastMedicalHistory;
	private String familyHistory;
	private String allergyHistory;
	private String currentMedication;
	private String externalLabInvestigation;
	
	public HealthData() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public String getPurposeOfVisit() {
		return purposeOfVisit;
	}

	public void setPurposeOfVisit(String purposeOfVisit) {
		this.purposeOfVisit = purposeOfVisit;
	}

	public String getMainComplaint() {
		return mainComplaint;
	}

	public void setMainComplaint(String mainComplaint) {
		this.mainComplaint = mainComplaint;
	}

	public String getPastOcularHistory() {
		return pastOcularHistory;
		
	}

	public void setPastOcularHistory(String pastOcularHistory) {
		this.pastOcularHistory = pastOcularHistory;
	}

	public String getPastMedicalHistory() {
		return pastMedicalHistory;
	}

	public void setPastMedicalHistory(String pastMedicalHistory) {
		this.pastMedicalHistory = pastMedicalHistory;
	}

	public String getFamilyHistory() {
		return familyHistory;
	}

	public void setFamilyHistory(String familyHistory) {
		this.familyHistory = familyHistory;
	}

	public String getAllergyHistory() {
		return allergyHistory;
	}

	public void setAllergyHistory(String allergyHistory) {
		this.allergyHistory = allergyHistory;
	}

	public String getCurrentMedication() {
		return currentMedication;
	}

	public void setCurrentMedication(String currentMedication) {
		this.currentMedication = currentMedication;
	}

	public String getExternalLabInvestigation() {
		return externalLabInvestigation;
	}

	public void setExternalLabInvestigation(String externalLabInvestigation) {
		this.externalLabInvestigation = externalLabInvestigation;
	}
	
	

}
