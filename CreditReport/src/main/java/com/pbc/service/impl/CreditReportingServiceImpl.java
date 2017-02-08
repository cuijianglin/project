package com.pbc.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbc.dao.CreditReportDao;
import com.pbc.dto.CreditReportDto;
import com.pbc.entity.CreditReport;
import com.pbc.service.CreditReportingService;
import com.pbc.utils.DateUtils;

@Service
public class CreditReportingServiceImpl implements CreditReportingService{

	@Autowired
	CreditReportDao creditReportDao;
	
	@Override
	public void insertCreditReport(CreditReport c) {
		creditReportDao.insertCreditReport(c);
	}

	@Override
	public CreditReport CreditReportDtoToCreditReport(CreditReportDto cDto) {
		
		CreditReport cr = new CreditReport();
		cr.setStatus(cDto.getStatus());
		cr.setId(cDto.getId());
		cr.setCreditRecordFirstDate(DateUtils.StringToDate(cDto.getCreditRecordFirstDate()));
		cr.setCreditRecordFirstRecordPerson(cDto.getCreditRecordFirstRecordPerson());
		cr.setCreditRecordFirstYear(cDto.getCreditRecordFirstYear());
		
		cr.setCreditRecordSecondDate(DateUtils.StringToDate(cDto.getCreditRecordSecondDate()));
		cr.setCreditRecordSecondRecordPerson(cDto.getCreditRecordSecondRecordPerson());
		cr.setCreditRecordSecondYear(cDto.getCreditRecordSecondYear());
		
		cr.setCreditRecordThirdDate(DateUtils.StringToDate(cDto.getCreditRecordThirdDate()));
		cr.setCreditRecordThirdYear(cDto.getCreditRecordThirdYear());
		cr.setCreditRecordThridRecordPerson(cDto.getCreditRecordThridRecordPerson());
		
		cr.setDailyBehaviorFirstDate(DateUtils.StringToDate(cDto.getDailyBehaviorFirstDate()));;
		cr.setDailyBehaviorFirstRecordPerson(cDto.getDailyBehaviorFirstRecordPerson());;
		cr.setDailyBehaviorFirstYear(cDto.getDailyBehaviorFirstYear());
		
		cr.setDailyBehaviorSecondDate(DateUtils.StringToDate(cDto.getDailyBehaviorSecondDate()));
		cr.setDailyBehaviorSecondRecordPerson(cDto.getDailyBehaviorSecondRecordPerson());
		cr.setDailyBehaviorSecondYear(cDto.getDailyBehaviorSecondYear());
		
		cr.setDailyBehaviorThirdDate(DateUtils.StringToDate(cDto.getDailyBehaviorThirdDate()));
		cr.setDailyBehaviorThirdRecordPerson(cDto.getDailyBehaviorThirdRecordPerson());
		cr.setDailyBehaviorThirdYear(cDto.getDailyBehaviorThirdYear());
		
		cr.setOtherBehaviorFirstDate(DateUtils.StringToDate(cDto.getOtherBehaviorFirstDate()));
		cr.setOtherBehaviorFirstRecordPerson(cDto.getOtherBehaviorFirstRecordPerson());
		cr.setOtherBehaviorFirstYear(cDto.getOtherBehaviorFirstYear());
		
		cr.setOtherBehaviorSecondDate(DateUtils.StringToDate(cDto.getOtherBehaviorSecondDate()));
		cr.setOtherBehaviorSecondRecordPerson(cDto.getOtherBehaviorSecondRecordPerson());
		cr.setOtherBehaviorSecondYear(cDto.getOtherBehaviorSecondYear());
		
		cr.setOtherBehaviorThirdDate(DateUtils.StringToDate(cDto.getOtherBehaviorThirdDate()));
		cr.setOtherBehaviorThirdRecordPerson(cDto.getOtherBehaviorThirdRecordPerson());
		cr.setOtherBehaviorThirdYear(cDto.getOtherBehaviorThirdYear());
		
		cr.setOweMoneyFirstAccommodation(cDto.getOweMoneyFirstAccommodation());
		cr.setOweMoneyFirstOther(cDto.getOweMoneyFirstOther());
		cr.setOweMoneyFirstRecordPerson(cDto.getOweMoneyFirstRecordPerson());
		cr.setOweMoneyFirstStudy(cDto.getOweMoneyFirstStudy());
		
		cr.setOweMoneySecondAccommodation(cDto.getOweMoneySecondAccommodation());
		cr.setOweMoneySecondOther(cDto.getOweMoneySecondOther());
		cr.setOweMoneySecondRecordPerson(cDto.getOweMoneySecondRecordPerson());
		cr.setOweMoneySecondStudy(cDto.getOweMoneySecondStudy());
		
		cr.setOweMoneyThirdAccommodation(cDto.getOweMoneyThirdAccommodation());
		cr.setOweMoneyThirdOther(cDto.getOweMoneyThirdOther());
		cr.setOweMoneyThirdRecordPerson(cDto.getOweMoneyThirdRecordPerson());
		cr.setOweMoneyThirdStudy(cDto.getOweMoneyThirdStudy());
		
		cr.setStudyTestFirstDate(DateUtils.StringToDate(cDto.getStudyTestFirstDate()));
		cr.setStudyTestFirstRecordPerson(cDto.getStudyTestFirstRecordPerson());
		cr.setStudyTestFirstYear(cDto.getStudyTestFirstYear());
		
		cr.setStudyTestSecondDate(DateUtils.StringToDate(cDto.getStudyTestSecondDate()));
		cr.setStudyTestSecondRecordPerson(cDto.getStudyTestSecondRecordPerson());
		cr.setStudyTestSecondYear(cDto.getStudyTestSecondYear());
		
		cr.setStudyTestThirdDate(DateUtils.StringToDate(cDto.getStudyTestThirdDate()));
		cr.setStudyTestThirdRecordPerson(cDto.getStudyTestThirdRecordPerson());
		cr.setStudyTestThirdYear(cDto.getStudyTestThirdYear());
		
		return cr;
		
	}

	@Override
	public CreditReport selectCreditReportById(Integer id) {
		return creditReportDao.selectCreditReportById(id);
	}

	@Override
	public void delCreditReportById(Map map) {
		creditReportDao.delCreditReportById(map);
	}

	@Override
	public CreditReportDto CreditReportToCreditReportDto(CreditReport c) {
		if(c == null) return null;
		CreditReportDto cr = new CreditReportDto();
		cr.setStatus(c.getStatus());
		cr.setId(c.getId());
		cr.setCreditRecordFirstDate(DateUtils.DateToString(c.getCreditRecordFirstDate()));
		cr.setCreditRecordFirstRecordPerson(c.getCreditRecordFirstRecordPerson());
		cr.setCreditRecordFirstYear(c.getCreditRecordFirstYear());
		
		cr.setCreditRecordSecondDate(DateUtils.DateToString(c.getCreditRecordSecondDate()));
		cr.setCreditRecordSecondRecordPerson(c.getCreditRecordSecondRecordPerson());
		cr.setCreditRecordSecondYear(c.getCreditRecordSecondYear());
		
		cr.setCreditRecordThirdDate(DateUtils.DateToString(c.getCreditRecordThirdDate()));
		cr.setCreditRecordThirdYear(c.getCreditRecordThirdYear());
		cr.setCreditRecordThridRecordPerson(c.getCreditRecordThridRecordPerson());
		
		cr.setDailyBehaviorFirstDate(DateUtils.DateToString(c.getDailyBehaviorFirstDate()));;
		cr.setDailyBehaviorFirstRecordPerson(c.getDailyBehaviorFirstRecordPerson());;
		cr.setDailyBehaviorFirstYear(c.getDailyBehaviorFirstYear());
		
		cr.setDailyBehaviorSecondDate(DateUtils.DateToString(c.getDailyBehaviorSecondDate()));
		cr.setDailyBehaviorSecondRecordPerson(c.getDailyBehaviorSecondRecordPerson());
		cr.setDailyBehaviorSecondYear(c.getDailyBehaviorSecondYear());
		
		cr.setDailyBehaviorThirdDate(DateUtils.DateToString(c.getDailyBehaviorThirdDate()));
		cr.setDailyBehaviorThirdRecordPerson(c.getDailyBehaviorThirdRecordPerson());
		cr.setDailyBehaviorThirdYear(c.getDailyBehaviorThirdYear());
		
		cr.setOtherBehaviorFirstDate(DateUtils.DateToString(c.getOtherBehaviorFirstDate()));
		cr.setOtherBehaviorFirstRecordPerson(c.getOtherBehaviorFirstRecordPerson());
		cr.setOtherBehaviorFirstYear(c.getOtherBehaviorFirstYear());
		
		cr.setOtherBehaviorSecondDate(DateUtils.DateToString(c.getOtherBehaviorSecondDate()));
		cr.setOtherBehaviorSecondRecordPerson(c.getOtherBehaviorSecondRecordPerson());
		cr.setOtherBehaviorSecondYear(c.getOtherBehaviorSecondYear());
		
		cr.setOtherBehaviorThirdDate(DateUtils.DateToString(c.getOtherBehaviorThirdDate()));
		cr.setOtherBehaviorThirdRecordPerson(c.getOtherBehaviorThirdRecordPerson());
		cr.setOtherBehaviorThirdYear(c.getOtherBehaviorThirdYear());
		
		cr.setOweMoneyFirstAccommodation(c.getOweMoneyFirstAccommodation());
		cr.setOweMoneyFirstOther(c.getOweMoneyFirstOther());
		cr.setOweMoneyFirstRecordPerson(c.getOweMoneyFirstRecordPerson());
		cr.setOweMoneyFirstStudy(c.getOweMoneyFirstStudy());
		
		cr.setOweMoneySecondAccommodation(c.getOweMoneySecondAccommodation());
		cr.setOweMoneySecondOther(c.getOweMoneySecondOther());
		cr.setOweMoneySecondRecordPerson(c.getOweMoneySecondRecordPerson());
		cr.setOweMoneySecondStudy(c.getOweMoneySecondStudy());
		
		cr.setOweMoneyThirdAccommodation(c.getOweMoneyThirdAccommodation());
		cr.setOweMoneyThirdOther(c.getOweMoneyThirdOther());
		cr.setOweMoneyThirdRecordPerson(c.getOweMoneyThirdRecordPerson());
		cr.setOweMoneyThirdStudy(c.getOweMoneyThirdStudy());
		
		cr.setStudyTestFirstDate(DateUtils.DateToString(c.getStudyTestFirstDate()));
		cr.setStudyTestFirstRecordPerson(c.getStudyTestFirstRecordPerson());
		cr.setStudyTestFirstYear(c.getStudyTestFirstYear());
		
		cr.setStudyTestSecondDate(DateUtils.DateToString(c.getStudyTestSecondDate()));
		cr.setStudyTestSecondRecordPerson(c.getStudyTestSecondRecordPerson());
		cr.setStudyTestSecondYear(c.getStudyTestSecondYear());
		
		cr.setStudyTestThirdDate(DateUtils.DateToString(c.getStudyTestThirdDate()));
		cr.setStudyTestThirdRecordPerson(c.getStudyTestThirdRecordPerson());
		cr.setStudyTestThirdYear(c.getStudyTestThirdYear());
		
		return cr;
	}
	
	
}
