package com.sidematch.domain.entity

import com.github.f4b6a3.ulid.Ulid
import com.sidematch.common.util.UlidUtil
import com.sidematch.common.vo.URL
import com.sidematch.domain.enum.MakerPosition
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.instanceOf

@DisplayName("Maker")
class MakerTest : DescribeSpec({

    describe("create") {
        context("[Success] 이름을 입력하면") {
            it("메이커를 생성한다.") {
                // given
                val name = "이름"

                // when
                val maker: Maker = Maker.create(name)

                // then
                maker shouldBe instanceOf<Maker>()
            }
        }

        context("[Failure] 이름을 입력하지 않으면") {
            it("예외를 발생시킨다.") {
                // given
                val name = ""

                // when, then
                shouldThrow<IllegalArgumentException> { Maker.create(name) }
            }
        }

        context("[Failure] 이름이 20자를 초과하면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "1".repeat(21)

                // when, then
                shouldThrow<IllegalArgumentException> { Maker.create(name) }
            }
        }


        context("[Success] 이름과 같이 소개를 입력하면") {
            it("메이커를 생성한다.") {
                // given
                val name = "이름"
                val introduction = "소개"

                // when
                val maker: Maker = Maker.create(name, introduction = introduction)

                // then
                maker shouldBe instanceOf<Maker>()
            }
        }

        context("[Failure] 소개가 2000자를 초과하면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "이름"
                val introduction = "1".repeat(2001)

                // when, then
                shouldThrow<IllegalArgumentException> { Maker.create(name, introduction = introduction) }
            }
        }

        context("[Success] 이름과 같이 관심사를 입력하면") {
            it("메이커를 생성한다.") {
                // given
                val name = "이름"
                val interest = "관심사"

                // when
                val maker: Maker = Maker.create(name, interest = interest)

                // then
                maker shouldBe instanceOf<Maker>()
            }
        }

        context("[Failure] 관심사가 20자를 초과하면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "이름"
                val interest = "1".repeat(21)

                // when, then
                shouldThrow<IllegalArgumentException> { Maker.create(name, interest = interest) }
            }
        }

        context("[Success] 이름과 같이 프로필 이미지 URL을 입력하면") {
            it("메이커를 생성한다.") {
                // given
                val name = "이름"
                val profileImageUrl = URL("https://example.com")

                // when
                val maker: Maker = Maker.create(name = name, profileImageUrl = profileImageUrl)

                // then
                maker shouldBe instanceOf<Maker>()
            }
        }

        context("[Failure] 프로필 이미지 URL이 유효하지 않으면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "이름"
                val profileImageUrl = URL("invalid url")

                // when, then
                shouldThrow<IllegalArgumentException> { Maker.create(name = name, profileImageUrl = profileImageUrl) }
            }
        }

        context("[Success] 이름과 같이 포지션을 입력하면") {
            it("메이커를 생성한다.") {
                // given
                val name = "이름"
                val positions: Set<MakerPosition> = setOf(MakerPosition.FRONTEND)

                // when
                val maker: Maker = Maker.create(name = name, positions = positions)

                // then
                maker shouldBe instanceOf<Maker>()
            }
        }

        context("[Failure] 포지션이 3개를 초과하면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "이름"
                val positions: Set<MakerPosition> =
                    setOf(
                        MakerPosition.FRONTEND,
                        MakerPosition.BACKEND,
                        MakerPosition.DESIGNER,
                        MakerPosition.PROJECT_MANAGER
                    )

                // when, then
                shouldThrow<IllegalArgumentException> { Maker.create(name = name, positions = positions) }
            }
        }

        context("[Success] 이름과 같이 스킬 ID를 입력하면") {
            it("메이커를 생성한다.") {
                // given
                val name = "이름"
                val skillIds: Set<Ulid> = setOf(UlidUtil.create())

                // when
                val maker: Maker = Maker.create(name = name, skillIds = skillIds)

                // then
                maker shouldBe instanceOf<Maker>()
            }
        }

        context("[Failure] 이름과 같이 github url 을 입력하면") {
            it("메이커를 생성한다.") {
                // given
                val name = "이름"
                val githubUrl = URL("https://github.com")

                // when
                val maker: Maker = Maker.create(name = name, githubUrl = githubUrl)

                // then
                maker shouldBe instanceOf<Maker>()
            }
        }

        context("[Failure] github url 이 유효하지 않으면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "이름"
                val githubUrl = URL("invalid url")

                // when, then
                shouldThrow<IllegalArgumentException> { Maker.create(name = name, githubUrl = githubUrl) }
            }
        }

        context("[Success] 이름과 같이 포트폴리오 url 을 입력하면") {
            it("메이커를 생성한다.") {
                // given
                val name = "이름"
                val portfolioUrl = URL("https://portfolio.com")

                // when
                val maker: Maker = Maker.create(name = name, portfolioUrl = portfolioUrl)

                // then
                maker shouldBe instanceOf<Maker>()
            }
        }

        context("[Failure] 포트폴리오 url 이 유효하지 않으면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "이름"
                val portfolioUrl = URL("invalid url")

                // when, then
                shouldThrow<IllegalArgumentException> { Maker.create(name = name, portfolioUrl = portfolioUrl) }
            }
        }

        context("[Success] 이름과 같이 경력 ID를 입력하면") {
            it("메이커를 생성한다.") {
                // given
                val name = "이름"
                val careerIds: Set<Ulid> = setOf(UlidUtil.create())

                // when
                val maker: Maker = Maker.create(name = name, careerIds = careerIds)

                // then
                maker shouldBe instanceOf<Maker>()
            }
        }

        context("[Failure] 경력 ID가 10개를 초과하면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "이름"
                val careerIds: Set<Ulid> = (0 until 11).map { UlidUtil.create() }.toSet()

                // when, then
                shouldThrow<IllegalArgumentException> { Maker.create(name = name, careerIds = careerIds) }
            }
        }

        context("[Success] 이름과 같이 목적을 입력하면") {
            it("메이커를 생성한다.") {
                // given
                val name = "이름"
                val purpose = "목적"

                // when
                val maker: Maker = Maker.create(name = name, purpose = purpose)

                // then
                maker shouldBe instanceOf<Maker>()
            }
        }

        context("[Failure] 목적이 100자를 초과하면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "이름"
                val purpose = "1".repeat(101)

                // when, then
                shouldThrow<IllegalArgumentException> { Maker.create(name = name, purpose = purpose) }
            }
        }
    }
})
