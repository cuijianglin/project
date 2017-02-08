package com.pbc.dto;


public class CreditReportDto {
	Integer id;
	/*诚信记录*/
	//第一学年
	String creditRecordFirstYear;
	String creditRecordFirstRecordPerson;
	String creditRecordFirstDate;
	
	//第二学年
	String creditRecordSecondYear;
	String creditRecordSecondRecordPerson;
	String creditRecordSecondDate;
	
	//第三学年
	String creditRecordThirdYear;
	String creditRecordThridRecordPerson;
	String creditRecordThirdDate;
	
	/*学风考风*/
	
	//第一年
	String studyTestFirstYear;
	String studyTestFirstRecordPerson;
	String studyTestFirstDate;
	
	//第二年
	String studyTestSecondYear;
	String studyTestSecondRecordPerson;
	String studyTestSecondDate;
	
	//第三年
	String studyTestThirdYear;
	String studyTestThirdRecordPerson;
	String studyTestThirdDate;
	
	/*(新学年开学一月后)拖欠费用情况*/
	//第一年
	String oweMoneyFirstStudy;
	String oweMoneyFirstAccommodation;
	String oweMoneyFirstOther;
	String oweMoneyFirstRecordPerson;
	//第二年
	String oweMoneySecondStudy;
	String oweMoneySecondAccommodation;
	String oweMoneySecondOther;
	String oweMoneySecondRecordPerson;
	//第三年
	String oweMoneyThirdStudy;
	String oweMoneyThirdAccommodation;
	String oweMoneyThirdOther;
	String oweMoneyThirdRecordPerson;
	
	/*日常行为情况*/
	//第一年
	String dailyBehaviorFirstYear;
	String dailyBehaviorFirstRecordPerson;
	String dailyBehaviorFirstDate;
	//第二年
	String dailyBehaviorSecondYear;
	String dailyBehaviorSecondRecordPerson;
	String dailyBehaviorSecondDate;
	//第三年
	String dailyBehaviorThirdYear;
	String dailyBehaviorThirdRecordPerson;
	String dailyBehaviorThirdDate;
	
	/*其他表现情况*/
	//第一年
	String otherBehaviorFirstYear;
	String otherBehaviorFirstRecordPerson;
	String otherBehaviorFirstDate;
	//第二年
	String otherBehaviorSecondYear;
	String otherBehaviorSecondRecordPerson;
	String otherBehaviorSecondDate;
	//第三年
	String otherBehaviorThirdYear;
	String otherBehaviorThirdRecordPerson;
	String otherBehaviorThirdDate;
	Integer status;
	public String getCreditRecordFirstYear() {
		return creditRecordFirstYear;
	}
	public void setCreditRecordFirstYear(String creditRecordFirstYear) {
		this.creditRecordFirstYear = creditRecordFirstYear;
	}
	public String getCreditRecordFirstRecordPerson() {
		return creditRecordFirstRecordPerson;
	}
	public void setCreditRecordFirstRecordPerson(String creditRecordFirstRecordPerson) {
		this.creditRecordFirstRecordPerson = creditRecordFirstRecordPerson;
	}
	public String getCreditRecordFirstDate() {
		return creditRecordFirstDate;
	}
	public void setCreditRecordFirstDate(String creditRecordFirstDate) {
		this.creditRecordFirstDate = creditRecordFirstDate;
	}
	public String getCreditRecordSecondYear() {
		return creditRecordSecondYear;
	}
	public void setCreditRecordSecondYear(String creditRecordSecondYear) {
		this.creditRecordSecondYear = creditRecordSecondYear;
	}
	public String getCreditRecordSecondRecordPerson() {
		return creditRecordSecondRecordPerson;
	}
	public void setCreditRecordSecondRecordPerson(String creditRecordSecondRecordPerson) {
		this.creditRecordSecondRecordPerson = creditRecordSecondRecordPerson;
	}
	public String getCreditRecordSecondDate() {
		return creditRecordSecondDate;
	}
	public void setCreditRecordSecondDate(String creditRecordSecondDate) {
		this.creditRecordSecondDate = creditRecordSecondDate;
	}
	public String getCreditRecordThirdYear() {
		return creditRecordThirdYear;
	}
	public void setCreditRecordThirdYear(String creditRecordThirdYear) {
		this.creditRecordThirdYear = creditRecordThirdYear;
	}
	public String getCreditRecordThridRecordPerson() {
		return creditRecordThridRecordPerson;
	}
	public void setCreditRecordThridRecordPerson(String creditRecordThridRecordPerson) {
		this.creditRecordThridRecordPerson = creditRecordThridRecordPerson;
	}
	public String getCreditRecordThirdDate() {
		return creditRecordThirdDate;
	}
	public void setCreditRecordThirdDate(String creditRecordThirdDate) {
		this.creditRecordThirdDate = creditRecordThirdDate;
	}
	public String getStudyTestFirstYear() {
		return studyTestFirstYear;
	}
	public void setStudyTestFirstYear(String studyTestFirstYear) {
		this.studyTestFirstYear = studyTestFirstYear;
	}
	public String getStudyTestFirstRecordPerson() {
		return studyTestFirstRecordPerson;
	}
	public void setStudyTestFirstRecordPerson(String studyTestFirstRecordPerson) {
		this.studyTestFirstRecordPerson = studyTestFirstRecordPerson;
	}
	public String getStudyTestFirstDate() {
		return studyTestFirstDate;
	}
	public void setStudyTestFirstDate(String studyTestFirstDate) {
		this.studyTestFirstDate = studyTestFirstDate;
	}
	public String getStudyTestSecondYear() {
		return studyTestSecondYear;
	}
	public void setStudyTestSecondYear(String studyTestSecondYear) {
		this.studyTestSecondYear = studyTestSecondYear;
	}
	public String getStudyTestSecondRecordPerson() {
		return studyTestSecondRecordPerson;
	}
	public void setStudyTestSecondRecordPerson(String studyTestSecondRecordPerson) {
		this.studyTestSecondRecordPerson = studyTestSecondRecordPerson;
	}
	public String getStudyTestSecondDate() {
		return studyTestSecondDate;
	}
	public void setStudyTestSecondDate(String studyTestSecondDate) {
		this.studyTestSecondDate = studyTestSecondDate;
	}
	public String getStudyTestThirdYear() {
		return studyTestThirdYear;
	}
	public void setStudyTestThirdYear(String studyTestThirdYear) {
		this.studyTestThirdYear = studyTestThirdYear;
	}
	public String getStudyTestThirdRecordPerson() {
		return studyTestThirdRecordPerson;
	}
	public void setStudyTestThirdRecordPerson(String studyTestThirdRecordPerson) {
		this.studyTestThirdRecordPerson = studyTestThirdRecordPerson;
	}
	public String getStudyTestThirdDate() {
		return studyTestThirdDate;
	}
	public void setStudyTestThirdDate(String studyTestThirdDate) {
		this.studyTestThirdDate = studyTestThirdDate;
	}
	public String getOweMoneyFirstStudy() {
		return oweMoneyFirstStudy;
	}
	public void setOweMoneyFirstStudy(String oweMoneyFirstStudy) {
		this.oweMoneyFirstStudy = oweMoneyFirstStudy;
	}
	public String getOweMoneyFirstAccommodation() {
		return oweMoneyFirstAccommodation;
	}
	public void setOweMoneyFirstAccommodation(String oweMoneyFirstAccommodation) {
		this.oweMoneyFirstAccommodation = oweMoneyFirstAccommodation;
	}
	public String getOweMoneyFirstOther() {
		return oweMoneyFirstOther;
	}
	public void setOweMoneyFirstOther(String oweMoneyFirstOther) {
		this.oweMoneyFirstOther = oweMoneyFirstOther;
	}
	public String getOweMoneyFirstRecordPerson() {
		return oweMoneyFirstRecordPerson;
	}
	public void setOweMoneyFirstRecordPerson(String oweMoneyFirstRecordPerson) {
		this.oweMoneyFirstRecordPerson = oweMoneyFirstRecordPerson;
	}
	public String getOweMoneySecondStudy() {
		return oweMoneySecondStudy;
	}
	public void setOweMoneySecondStudy(String oweMoneySecondStudy) {
		this.oweMoneySecondStudy = oweMoneySecondStudy;
	}
	public String getOweMoneySecondAccommodation() {
		return oweMoneySecondAccommodation;
	}
	public void setOweMoneySecondAccommodation(String oweMoneySecondAccommodation) {
		this.oweMoneySecondAccommodation = oweMoneySecondAccommodation;
	}
	public String getOweMoneySecondOther() {
		return oweMoneySecondOther;
	}
	public void setOweMoneySecondOther(String oweMoneySecondOther) {
		this.oweMoneySecondOther = oweMoneySecondOther;
	}
	public String getOweMoneySecondRecordPerson() {
		return oweMoneySecondRecordPerson;
	}
	public void setOweMoneySecondRecordPerson(String oweMoneySecondRecordPerson) {
		this.oweMoneySecondRecordPerson = oweMoneySecondRecordPerson;
	}
	public String getOweMoneyThirdStudy() {
		return oweMoneyThirdStudy;
	}
	public void setOweMoneyThirdStudy(String oweMoneyThirdStudy) {
		this.oweMoneyThirdStudy = oweMoneyThirdStudy;
	}
	public String getOweMoneyThirdAccommodation() {
		return oweMoneyThirdAccommodation;
	}
	public void setOweMoneyThirdAccommodation(String oweMoneyThirdAccommodation) {
		this.oweMoneyThirdAccommodation = oweMoneyThirdAccommodation;
	}
	public String getOweMoneyThirdOther() {
		return oweMoneyThirdOther;
	}
	public void setOweMoneyThirdOther(String oweMoneyThirdOther) {
		this.oweMoneyThirdOther = oweMoneyThirdOther;
	}
	public String getOweMoneyThirdRecordPerson() {
		return oweMoneyThirdRecordPerson;
	}
	public void setOweMoneyThirdRecordPerson(String oweMoneyThirdRecordPerson) {
		this.oweMoneyThirdRecordPerson = oweMoneyThirdRecordPerson;
	}
	public String getDailyBehaviorFirstYear() {
		return dailyBehaviorFirstYear;
	}
	public void setDailyBehaviorFirstYear(String dailyBehaviorFirstYear) {
		this.dailyBehaviorFirstYear = dailyBehaviorFirstYear;
	}
	public String getDailyBehaviorFirstRecordPerson() {
		return dailyBehaviorFirstRecordPerson;
	}
	public void setDailyBehaviorFirstRecordPerson(String dailyBehaviorFirstRecordPerson) {
		this.dailyBehaviorFirstRecordPerson = dailyBehaviorFirstRecordPerson;
	}
	public String getDailyBehaviorFirstDate() {
		return dailyBehaviorFirstDate;
	}
	public void setDailyBehaviorFirstDate(String dailyBehaviorFirstDate) {
		this.dailyBehaviorFirstDate = dailyBehaviorFirstDate;
	}
	public String getDailyBehaviorSecondYear() {
		return dailyBehaviorSecondYear;
	}
	public void setDailyBehaviorSecondYear(String dailyBehaviorSecondYear) {
		this.dailyBehaviorSecondYear = dailyBehaviorSecondYear;
	}
	public String getDailyBehaviorSecondRecordPerson() {
		return dailyBehaviorSecondRecordPerson;
	}
	public void setDailyBehaviorSecondRecordPerson(String dailyBehaviorSecondRecordPerson) {
		this.dailyBehaviorSecondRecordPerson = dailyBehaviorSecondRecordPerson;
	}
	public String getDailyBehaviorSecondDate() {
		return dailyBehaviorSecondDate;
	}
	public void setDailyBehaviorSecondDate(String dailyBehaviorSecondDate) {
		this.dailyBehaviorSecondDate = dailyBehaviorSecondDate;
	}
	public String getDailyBehaviorThirdYear() {
		return dailyBehaviorThirdYear;
	}
	public void setDailyBehaviorThirdYear(String dailyBehaviorThirdYear) {
		this.dailyBehaviorThirdYear = dailyBehaviorThirdYear;
	}
	public String getDailyBehaviorThirdRecordPerson() {
		return dailyBehaviorThirdRecordPerson;
	}
	public void setDailyBehaviorThirdRecordPerson(String dailyBehaviorThirdRecordPerson) {
		this.dailyBehaviorThirdRecordPerson = dailyBehaviorThirdRecordPerson;
	}
	public String getDailyBehaviorThirdDate() {
		return dailyBehaviorThirdDate;
	}
	public void setDailyBehaviorThirdDate(String dailyBehaviorThirdDate) {
		this.dailyBehaviorThirdDate = dailyBehaviorThirdDate;
	}
	public String getOtherBehaviorFirstYear() {
		return otherBehaviorFirstYear;
	}
	public void setOtherBehaviorFirstYear(String otherBehaviorFirstYear) {
		this.otherBehaviorFirstYear = otherBehaviorFirstYear;
	}
	public String getOtherBehaviorFirstRecordPerson() {
		return otherBehaviorFirstRecordPerson;
	}
	public void setOtherBehaviorFirstRecordPerson(String otherBehaviorFirstRecordPerson) {
		this.otherBehaviorFirstRecordPerson = otherBehaviorFirstRecordPerson;
	}
	public String getOtherBehaviorFirstDate() {
		return otherBehaviorFirstDate;
	}
	public void setOtherBehaviorFirstDate(String otherBehaviorFirstDate) {
		this.otherBehaviorFirstDate = otherBehaviorFirstDate;
	}
	public String getOtherBehaviorSecondYear() {
		return otherBehaviorSecondYear;
	}
	public void setOtherBehaviorSecondYear(String otherBehaviorSecondYear) {
		this.otherBehaviorSecondYear = otherBehaviorSecondYear;
	}
	public String getOtherBehaviorSecondRecordPerson() {
		return otherBehaviorSecondRecordPerson;
	}
	public void setOtherBehaviorSecondRecordPerson(String otherBehaviorSecondRecordPerson) {
		this.otherBehaviorSecondRecordPerson = otherBehaviorSecondRecordPerson;
	}
	public String getOtherBehaviorSecondDate() {
		return otherBehaviorSecondDate;
	}
	public void setOtherBehaviorSecondDate(String otherBehaviorSecondDate) {
		this.otherBehaviorSecondDate = otherBehaviorSecondDate;
	}
	public String getOtherBehaviorThirdYear() {
		return otherBehaviorThirdYear;
	}
	public void setOtherBehaviorThirdYear(String otherBehaviorThirdYear) {
		this.otherBehaviorThirdYear = otherBehaviorThirdYear;
	}
	public String getOtherBehaviorThirdRecordPerson() {
		return otherBehaviorThirdRecordPerson;
	}
	public void setOtherBehaviorThirdRecordPerson(String otherBehaviorThirdRecordPerson) {
		this.otherBehaviorThirdRecordPerson = otherBehaviorThirdRecordPerson;
	}
	public String getOtherBehaviorThirdDate() {
		return otherBehaviorThirdDate;
	}
	public void setOtherBehaviorThirdDate(String otherBehaviorThirdDate) {
		this.otherBehaviorThirdDate = otherBehaviorThirdDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
