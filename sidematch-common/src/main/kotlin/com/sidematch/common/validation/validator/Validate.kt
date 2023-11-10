package com.sidematch.common.validation.validator

import jakarta.validation.ConstraintViolation
import jakarta.validation.Validation

val validator: jakarta.validation.Validator = Validation.buildDefaultValidatorFactory().validator

fun <T> validate(`object`: T, vararg groups: Class<*>?) {
    val constraint: MutableSet<ConstraintViolation<T>> = validator.validate(`object`, *groups)
    if (constraint.isNotEmpty()) {
        throw IllegalArgumentException(constraint.joinToString(", "))
    }
}
