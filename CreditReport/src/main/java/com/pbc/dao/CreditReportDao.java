package com.pbc.dao;

import java.util.Map;

import com.pbc.entity.CreditReport;

public interface CreditReportDao {
	void insertCreditReport(CreditReport c);
	CreditReport selectCreditReportById(Integer id);
	void delCreditReportById(Map map);
}
