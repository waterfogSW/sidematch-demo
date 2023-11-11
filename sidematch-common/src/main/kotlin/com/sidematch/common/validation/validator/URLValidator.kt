package com.sidematch.common.validation.validator

import com.sidematch.common.validation.annotation.ValidURL
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class URLValidator : ConstraintValidator<ValidURL, String?> {
    private var nullable: Boolean = false

    override fun initialize(constraintAnnotation: ValidURL) {
        nullable = constraintAnnotation.nullable
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {

        if (value.isNullOrEmpty()) {
            return nullable
        }
        return try {
            java.net.URL(value)
            true
        } catch (e: Exception) {
            false
        }
    }
}
