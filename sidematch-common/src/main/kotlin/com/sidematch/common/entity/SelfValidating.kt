package com.sidematch.common.entity

import jakarta.validation.ConstraintViolation
import jakarta.validation.ConstraintViolationException
import jakarta.validation.Validation
import jakarta.validation.Validator

abstract class SelfValidating {

    companion object {
        private val validator: Validator = Validation.buildDefaultValidatorFactory().validator
    }

    protected fun <T : SelfValidating> validateSelf(clazz: Class<T>) {
        val violations: Set<ConstraintViolation<T>> = validator.validate(clazz.cast(this))
        if (violations.isNotEmpty()) {
            throw IllegalArgumentException(violations.joinToString { it.message })
        }
    }
}
