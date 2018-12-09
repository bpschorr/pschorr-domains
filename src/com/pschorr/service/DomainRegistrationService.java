package com.pschorr.service;

import java.util.List;

import com.pschorr.bean.DomainRegistrationBean;

public interface DomainRegistrationService {
	
	public List<String> getDomainPlans() throws Exception;
	
	public DomainRegistrationBean registerDomain(DomainRegistrationBean domainRegistrationBean) throws Exception;
}
