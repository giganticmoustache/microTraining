package com.customer.rest.error;

import java.util.ArrayList;
import java.util.List;

public class CustomerError {

	private List<CustomerError> subErrorList;
	private String serviceName;
	private String message;
	private Integer id;

	public CustomerError addError(CustomerError e) {
		if (this.subErrorList == null) {
			this.subErrorList = new ArrayList<CustomerError>();
		}
		this.addError(e);
		return this;
	}

	public List<CustomerError> getSubErrorList() {
		return subErrorList;
	}

	public String getServiceName() {
		return serviceName;
	}

	public String getMessage() {
		return message;
	}

	public Integer getId() {
		return id;
	}

	public CustomerError setSubErrorList(List<CustomerError> subErrorList) {
		this.subErrorList = subErrorList;
		return this;
	}

	public CustomerError setServiceName(String serviceName) {
		this.serviceName = serviceName;
		return this;
	}

	public CustomerError setMessage(String message) {
		this.message = message;
		return this;
	}

	public CustomerError setId(Integer id) {
		this.id = id;
		return this;
	}
}
