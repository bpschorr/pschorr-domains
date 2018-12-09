package com.pschorr.resources;

import org.apache.log4j.Logger;
import com.pschorr.dao.DomainRegistrationDAOImpl;
import com.pschorr.service.DomainRegistrationServiceImpl;

public class Factory {

	public static DomainRegistrationServiceImpl createDomainRegistrationService () {
		Logger logger = Logger.getLogger(Factory.class);
		logger.info("FactoryService: Inside DomainRegistrationServiceImpl Method");
		return new DomainRegistrationServiceImpl();
	}

	public static DomainRegistrationDAOImpl createDomainRegistrationDAO() {
		Logger logger = Logger.getLogger(Factory.class);
		logger.info("FactoryDAO: Inside DomainRegistrationDAOImpl Method");
		return new DomainRegistrationDAOImpl();
	}
}
