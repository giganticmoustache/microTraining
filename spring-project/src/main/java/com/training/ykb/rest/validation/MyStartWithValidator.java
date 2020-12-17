package com.training.ykb.rest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyStartWithValidator implements ConstraintValidator<StartWith, String> {
	
	private StartWith sa;
	
	@Override
	public void initialize(final StartWith constraintAnnotation) {
		this.sa = constraintAnnotation;
	}

	@Override
	public boolean isValid(final String value, final ConstraintValidatorContext context) {
		return value.startsWith(this.sa.value());
	}
}
