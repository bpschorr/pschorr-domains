package com.pschorr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pschorr_domains")
public class DomainRegistrationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer domainRegistrationId;

	private String domainName;

	private String domainExtension;
	
	private String customerName;
	
	private Integer duration;
	
	private String plan;

	private Boolean AdsRequired;

	public Integer getDomainRegistrationId() {
		return domainRegistrationId;
	}

	public void setDomainRegistrationId(Integer domainRegistrationId) {
		this.domainRegistrationId = domainRegistrationId;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getDomainExtension() {
		return domainExtension;
	}

	public void setDomainExtension(String domainExtension) {
		this.domainExtension = domainExtension;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public Boolean getAdsRequired() {
		return adsRequired;
	}

	public void setAdsRequired(Boolean adsRequired) {
		this.adsRequired = adsRequired;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


}

