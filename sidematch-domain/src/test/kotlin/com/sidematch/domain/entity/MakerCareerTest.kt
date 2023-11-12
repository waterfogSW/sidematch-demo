package com.sidematch.domain.entity

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.instanceOf
import java.time.LocalDateTime

@DisplayName("MakerCareer")
class MakerCareerTest : DescribeSpec({


    describe("create") {
        context("[Success] 메이커의 경력 정보를 전달하면") {
            it("메이커의 경력을 생성한다.") {
                // given
                val name = "회사/학교명"
                val position = "직책"
                val isCurrent = false
                val startDate: LocalDateTime = LocalDateTime.now()
                val endDateTime: LocalDateTime = LocalDateTime.now()
                val description = "내용"

                // when
                val makerCareer: MakerCareer = MakerCareer.create(
                    name = name,
                    position = position,
                    isCurrent = isCurrent,
                    startDate = startDate,
                    endDateTime = endDateTime,
                    description = description,
                )

                // then
                makerCareer shouldBe instanceOf<MakerCareer>()
            }
        }

        context("[Failure] 회사/학교명을 입력하지 않으면") {
            it("예외를 발생시킨다.") {
                // given
                val name = ""
                val position = "직책"
                val isCurrent = false
                val startDate: LocalDateTime = LocalDateTime.now()
                val endDateTime: LocalDateTime = LocalDateTime.now()
                val description = "내용"

                // when, then
                shouldThrow<IllegalArgumentException> {
                    MakerCareer.create(
                        name = name,
                        position = position,
                        isCurrent = isCurrent,
                        startDate = startDate,
                        endDateTime = endDateTime,
                        description = description,
                    )
                }
            }
        }

        context("[Failure] 회사/학교명이 20자를 초과하면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "1".repeat(21)
                val position = "직책"
                val isCurrent = false
                val startDate: LocalDateTime = LocalDateTime.now()
                val endDateTime: LocalDateTime = LocalDateTime.now()
                val description = "내용"

                // when, then
                shouldThrow<IllegalArgumentException> {
                    MakerCareer.create(
                        name = name,
                        position = position,
                        isCurrent = isCurrent,
                        startDate = startDate,
                        endDateTime = endDateTime,
                        description = description,
                    )
                }
            }
        }

        context("[Failure] 직책이 20자를 초과하면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "회사/학교명"
                val position = "1".repeat(21)
                val isCurrent = false
                val startDate: LocalDateTime = LocalDateTime.now()
                val endDateTime: LocalDateTime = LocalDateTime.now()
                val description = "내용"

                // when, then
                shouldThrow<IllegalArgumentException> {
                    MakerCareer.create(
                        name = name,
                        position = position,
                        isCurrent = isCurrent,
                        startDate = startDate,
                        endDateTime = endDateTime,
                        description = description,
                    )
                }
            }
        }

        context("[Failure] 현재 직장/학교 를 다니고 있는데, 퇴사/졸업일을 입력하면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "회사/학교명"
                val position = "직책"
                val isCurrent = true
                val startDate: LocalDateTime = LocalDateTime.now()
                val endDateTime: LocalDateTime = LocalDateTime.now()
                val description = "내용"

                // when, then
                shouldThrow<IllegalArgumentException> {
                    MakerCareer.create(
                        name = name,
                        position = position,
                        isCurrent = isCurrent,
                        startDate = startDate,
                        endDateTime = endDateTime,
                        description = description,
                    )
                }
            }
        }

        context("[Failure] 현재 직장/학교 를 다니고 있지 않는데, 퇴사/졸업일을 입력하지 않으면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "회사/학교명"
                val position = "직책"
                val isCurrent = false
                val startDate: LocalDateTime = LocalDateTime.now()
                val endDateTime: LocalDateTime? = null
                val description = "내용"

                // when, then
                shouldThrow<IllegalArgumentException> {
                    MakerCareer.create(
                        name = name,
                        position = position,
                        isCurrent = isCurrent,
                        startDate = startDate,
                        endDateTime = endDateTime,
                        description = description,
                    )
                }
            }
        }

        context("[Failure] 내용이 2000자를 초과하면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "회사/학교명"
                val position = "직책"
                val isCurrent = false
                val startDate: LocalDateTime = LocalDateTime.now()
                val endDateTime: LocalDateTime = LocalDateTime.now()
                val description = "1".repeat(2001)

                // when, then
                shouldThrow<IllegalArgumentException> {
                    MakerCareer.create(
                        name = name,
                        position = position,
                        isCurrent = isCurrent,
                        startDate = startDate,
                        endDateTime = endDateTime,
                        description = description,
                    )
                }
            }
        }
    }
})
