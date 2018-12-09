package com.pschorr.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.pschorr.bean.DomainRegistrationBean;
import com.pschorr.dao.DomainRegistrationDAO;
import com.pschorr.resources.Factory;

public class DomainRegistrationServiceImpl implements DomainRegistrationService {

	public List<String> getDomainPlans() throws Exception {
		List<String> domainPlansList  = new ArrayList<String>();
		try {

			DomainRegistrationDAO domainRegistrationDAO = Factory.createDomainRegistrationDAO();
			domainPlansList = domainRegistrationDAO.getDomainPlans();

		} catch (Exception exception) {
			if (!exception.getMessage().contains("DAO")) {
				Logger logger = Logger.getLogger(this.getClass());
				logger.error(exception.getMessage(), exception);
			}
			throw exception;
		}
		return domainPlansList;
	}

	public DomainRegistrationBean registerDomain(DomainRegistrationBean domainRegistrationBean) throws Exception{
		
		DomainRegistrationBean domRegBean = null;
		try {
			
			DomainRegistrationDAO domainRegistrationDAO = Factory.createDomainRegistrationDAO();
			
			boolean res = domainRegistrationDAO.checkDuplicateDomain(domainRegistrationBean.getDomainName());
			
			if(res == true)
			{
				throw new Exception("DOMAINREGISTERSERVICE.DOMAIN_ALREADY_EXISTS");
			}
						
			domRegBean = domainRegistrationDAO.registerDomain(domainRegistrationBean);
			
		} catch (Exception exception) {
			if (!exception.getMessage().contains("DAO")) {
				Logger logger = Logger.getLogger(this.getClass());
				logger.error(exception.getMessage(), exception);
			}
			throw exception;
		}
		return domRegBean;
	}

}