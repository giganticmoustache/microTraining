package com.training.ykb.rest.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {
	private List<ErrorObj> subErrors;
	private String subDomain;
	private String boundedContext;
	private String microservice;
	private String description;
	private int cause;

	public ErrorObj(List<ErrorObj> subErrors, String subDomain, String boundedContext, String microservice,
			String description, int cause) {
		super();
		this.subErrors = subErrors;
		this.subDomain = subDomain;
		this.boundedContext = boundedContext;
		this.microservice = microservice;
		this.description = description;
		this.cause = cause;
	}

	public ErrorObj() {
	}

	public ErrorObj addSubError(final ErrorObj e) {
		if (this.subErrors == null) {
			this.subErrors = new ArrayList<>();
		}
		this.subErrors.add(e);
		return this;
	}

	public List<ErrorObj> getSubErrors() {
		return subErrors;
	}

	public String getSubDomain() {
		return subDomain;
	}

	public String getBoundedContext() {
		return boundedContext;
	}

	public String getMicroservice() {
		return microservice;
	}

	public String getDescription() {
		return description;
	}

	public int getCause() {
		return cause;
	}

	public ErrorObj subErrors(List<ErrorObj> subErrors) {
		this.subErrors = subErrors;
		return this;
	}

	public ErrorObj subDomain(String subDomain) {
		this.subDomain = subDomain;
		return this;
	}

	public ErrorObj boundedContext(String boundedContext) {
		this.boundedContext = boundedContext;
		return this;
	}

	public ErrorObj microservice(String microservice) {
		this.microservice = microservice;
		return this;
	}

	public ErrorObj description(String description) {
		this.description = description;
		return this;
	}

	public ErrorObj cause(int cause) {
		this.cause = cause;
		return this;
	}
}
