package com.pbc.entity;

import java.util.Date;

public class CreditReport {
	Integer id;
	/*诚信记录*/
	//第一学年
	String creditRecordFirstYear;
	String creditRecordFirstRecordPerson;
	Date creditRecordFirstDate;
	
	//第二学年
	String creditRecordSecondYear;
	String creditRecordSecondRecordPerson;
	Date creditRecordSecondDate;
	
	//第三学年
	String creditRecordThirdYear;
	String creditRecordThridRecordPerson;
	Date creditRecordThirdDate;
	
	/*学风考风*/
	
	//第一年
	String studyTestFirstYear;
	String studyTestFirstRecordPerson;
	Date studyTestFirstDate;
	
	//第二年
	String studyTestSecondYear;
	String studyTestSecondRecordPerson;
	Date studyTestSecondDate;
	
	//第三年
	String studyTestThirdYear;
	String studyTestThirdRecordPerson;
	Date studyTestThirdDate;
	
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
	Date dailyBehaviorFirstDate;
	//第二年
	String dailyBehaviorSecondYear;
	String dailyBehaviorSecondRecordPerson;
	Date dailyBehaviorSecondDate;
	//第三年
	String dailyBehaviorThirdYear;
	String dailyBehaviorThirdRecordPerson;
	Date dailyBehaviorThirdDate;
	
	/*其他表现情况*/
	//第一年
	String otherBehaviorFirstYear;
	String otherBehaviorFirstRecordPerson;
	Date otherBehaviorFirstDate;
	//第二年
	String otherBehaviorSecondYear;
	String otherBehaviorSecondRecordPerson;
	Date otherBehaviorSecondDate;
	//第三年
	String otherBehaviorThirdYear;
	String otherBehaviorThirdRecordPerson;
	Date otherBehaviorThirdDate;
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
	public Date getCreditRecordFirstDate() {
		return creditRecordFirstDate;
	}
	public void setCreditRecordFirstDate(Date creditRecordFirstDate) {
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
	public Date getCreditRecordSecondDate() {
		return creditRecordSecondDate;
	}
	public void setCreditRecordSecondDate(Date creditRecordSecondDate) {
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
	public Date getCreditRecordThirdDate() {
		return creditRecordThirdDate;
	}
	public void setCreditRecordThirdDate(Date creditRecordThirdDate) {
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
	public Date getStudyTestFirstDate() {
		return studyTestFirstDate;
	}
	public void setStudyTestFirstDate(Date studyTestFirstDate) {
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
	public Date getStudyTestSecondDate() {
		return studyTestSecondDate;
	}
	public void setStudyTestSecondDate(Date studyTestSecondDate) {
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
	public Date getStudyTestThirdDate() {
		return studyTestThirdDate;
	}
	public void setStudyTestThirdDate(Date studyTestThirdDate) {
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
	public Date getDailyBehaviorFirstDate() {
		return dailyBehaviorFirstDate;
	}
	public void setDailyBehaviorFirstDate(Date dailyBehaviorFirstDate) {
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
	public Date getDailyBehaviorSecondDate() {
		return dailyBehaviorSecondDate;
	}
	public void setDailyBehaviorSecondDate(Date dailyBehaviorSecondDate) {
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
	public Date getDailyBehaviorThirdDate() {
		return dailyBehaviorThirdDate;
	}
	public void setDailyBehaviorThirdDate(Date dailyBehaviorThirdDate) {
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
	public Date getOtherBehaviorFirstDate() {
		return otherBehaviorFirstDate;
	}
	public void setOtherBehaviorFirstDate(Date otherBehaviorFirstDate) {
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
	public Date getOtherBehaviorSecondDate() {
		return otherBehaviorSecondDate;
	}
	public void setOtherBehaviorSecondDate(Date otherBehaviorSecondDate) {
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
	public Date getOtherBehaviorThirdDate() {
		return otherBehaviorThirdDate;
	}
	public void setOtherBehaviorThirdDate(Date otherBehaviorThirdDate) {
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
