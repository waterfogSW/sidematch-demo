package com.sidematch.common.validation.validator

import com.sidematch.common.validation.annotation.URL
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class URLValidator : ConstraintValidator<URL, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrEmpty()) {
            return false
        }
        return try {
            java.net.URL(value)
            true
        } catch (e: Exception) {
            false
        }
    }
}
