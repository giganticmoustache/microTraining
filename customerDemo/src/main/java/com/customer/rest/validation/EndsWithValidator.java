package com.customer.rest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EndsWithValidator implements ConstraintValidator<EndsWith, String> {
	
	private EndsWith endsWith;
	
	@Override
	public void initialize(final EndsWith endsWith) {
		this.endsWith = endsWith;
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value.endsWith(this.endsWith.value());
	}

}
