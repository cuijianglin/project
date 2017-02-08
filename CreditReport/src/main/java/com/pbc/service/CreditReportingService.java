package com.pbc.service;

import java.util.Map;

import com.pbc.dto.CreditReportDto;
import com.pbc.entity.CreditReport;

public interface CreditReportingService {
	void insertCreditReport(CreditReport c);
	CreditReport CreditReportDtoToCreditReport(CreditReportDto cDto);
	CreditReportDto CreditReportToCreditReportDto(CreditReport c);
	CreditReport selectCreditReportById(Integer id);
	void delCreditReportById(Map map);
}
