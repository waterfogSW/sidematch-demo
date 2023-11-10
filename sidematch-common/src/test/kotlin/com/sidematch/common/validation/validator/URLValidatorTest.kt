package com.sidematch.common.validation.validator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class URLValidatorTest : DescribeSpec({
    describe("URLValidator") {

        val sut = URLValidator()

        describe("isValid") {
            context("URL null이면") {
                it("false를 반환한다") {
                    val actual = sut.isValid(null, null)
                    actual shouldBe false
                }
            }
            context("URL이 유효하지 않으면") {
                it("false를 반환한다") {
                    val actual = sut.isValid("invalid url", null)
                    actual shouldBe false
                }
            }

            context("URL이 유효하면") {
                it("true를 반환한다") {
                    val actual = sut.isValid("https://www.google.com", null)
                    actual shouldBe true
                }
            }
        }

    }
})
