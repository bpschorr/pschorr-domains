package com.pschorr.bean;
    

public class DomainRegistrationBean {
	
	private Integer domainRegistrationId;
	private String domainName;
	private String domainExtension;
	private String customerName;
	private Integer duration;
	private String plan;
	private Boolean adsRequired;
	private String message;
	
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
}    
    