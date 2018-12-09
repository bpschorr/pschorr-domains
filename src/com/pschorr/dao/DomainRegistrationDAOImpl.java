package com.pschorr.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pschorr.bean.DomainRegistrationBean;
import com.pschorr.entity.DomainRegistrationEntity;
import com.pschorr.resources.HibernateUtility;

public class DomainRegistrationDAOImpl implements DomainRegistrationDAO {

	public List<String> getDomainPlans() throws Exception {
		List<String> domainPlansList = null;
		try {
			domainPlansList = new ArrayList<String>();
			
			domainPlansList.add("Free");
			domainPlansList.add("Basic");
			domainPlansList.add("Basic Plus");
			domainPlansList.add("Pro");
			domainPlansList.add("Pro Plus");
			domainPlansList.add("Combo");
			domainPlansList.add("Combo Plus");
			domainPlansList.add("Max");
			domainPlansList.add("Max Plus");
			
		} catch (Exception e) {
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(e.getMessage(), e);
			throw new Exception("DAO.TECHNICAL_ERROR");
		}
		return domainPlansList;
	}
	
	

	public DomainRegistrationBean registerDomain(DomainRegistrationBean domainRegistrationBean) throws Exception {

		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = null;

		try {
			session = sessionFactory.openSession();
			
			
			DomainRegistrationEntity registeringDomain = new DomainRegistrationEntity();
			registeringDomain.setDomainName(domainRegistrationBean.getDomainName());
			registeringDomain.setDomainExtension(domainRegistrationBean.getDomainExtension());
			registeringDomain.setCustomerName(domainRegistrationBean.getCustomerName());
			registeringDomain.setPlan(domainRegistrationBean.getPlan());
			registeringDomain.setAdsRequired(domainRegistrationBean.getAdsRequired());
			registeringDomain.setDuration(domainRegistrationBean.getDuration());
			

			session.beginTransaction();
			session.save(registeringDomain);
			session.getTransaction().commit();

			domainRegistrationBean.setDomainRegistrationId(registeringDomain.getDomainRegistrationId());
			return domainRegistrationBean;

		} catch (Exception e) {
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(e.getMessage(), e);
			throw new Exception("DAO.TECHNICAL_ERROR");

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public boolean checkDuplicateDomain(String domainName) throws Exception {
		SessionFactory sessionFactory = HibernateUtility.createSessionFactory();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			org.hibernate.Query query = session.createQuery("select be from DomainRegistrationEntity be where be.domainName='" + domainName + "' " );
			List<DomainRegistrationEntity> list = query.list();
			if (list.size()  == 0)
				return false;
		} catch (Exception e) {
			throw e;
		}
		return true;
	}

}
