package com.sidematch.common.validation.annotation

import com.sidematch.common.validation.validator.validate
import io.kotest.core.spec.style.DescribeSpec
import org.junit.jupiter.api.assertThrows

class URLTest : DescribeSpec({
    describe("URL 어노테이션 적용") {
        data class Mock(
            @field:URL
            val url: String,
        ) {
            init {
                validate(this)
            }
        }

        context("URL이 유효하지 않으면") {
            it("예외를 던진다.") {
                assertThrows<IllegalArgumentException> { Mock("invalid url") }
            }
        }
    }
})
