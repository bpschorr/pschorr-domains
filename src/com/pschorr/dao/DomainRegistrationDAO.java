package com.pschorr.dao;

import java.util.List;

import com.pschorr.bean.DomainRegistrationBean;

public interface DomainRegistrationDAO {

	public List<String> getDomainPlans() throws Exception;
	
	public DomainRegistrationBean registerDomain(DomainRegistrationBean domainRegistrationBean) throws Exception;
	
	public boolean checkDuplicateDomain(String domainName) throws Exception;
	
}