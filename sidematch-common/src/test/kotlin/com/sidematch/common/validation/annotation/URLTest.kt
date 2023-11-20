package com.sidematch.common.validation.annotation

import com.sidematch.common.entity.SelfValidating
import io.kotest.core.spec.style.DescribeSpec
import jakarta.validation.ConstraintViolation
import jakarta.validation.ConstraintViolationException
import org.junit.jupiter.api.assertThrows

class URLTest : DescribeSpec({
    describe("URL 어노테이션 적용") {
        data class Mock(
            @field:ValidURL
            val url: String,
        ): SelfValidating() {
            init {
                this.validateSelf(this::class.java)
            }
        }

        context("URL이 유효하지 않으면") {
            it("예외를 던진다.") {
                assertThrows<IllegalArgumentException> { Mock("invalid url") }
            }
        }
    }
})
