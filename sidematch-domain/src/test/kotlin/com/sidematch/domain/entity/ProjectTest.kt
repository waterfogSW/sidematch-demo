package com.sidematch.domain.entity

import com.github.f4b6a3.ulid.Ulid
import com.sidematch.common.util.UlidUtil
import com.sidematch.domain.enum.ProjectCollaborationType
import com.sidematch.domain.enum.ProjectType
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.instanceOf

@DisplayName("Project")
class ProjectTest : DescribeSpec({

    describe("create") {
        context("[Success] 유효한 프로젝트 정보를 전달하면") {

            it("프로젝트를 생성한다.") {
                // given
                val name = "프로젝트 이름"
                val summary = "프로젝트 요약"
                val types = setOf(ProjectType.APP)
                val workPeriodInMonths = 2
                val collaborationType = ProjectCollaborationType.ONLINE
                val communicationTool = "프로젝트 커뮤니케이션 도구"
                val objectives = "프로젝트 목표"
                val description = "프로젝트 설명"
                val makerIds = setOf(UlidUtil.create())

                // when
                val project: Project = Project.create(
                    name = name,
                    summary = summary,
                    types = types,
                    workPeriodInMonths = workPeriodInMonths,
                    collaborationType = collaborationType,
                    communicationTool = communicationTool,
                    objectives = objectives,
                    description = description,
                    makerIds = makerIds,
                )

                // then
                project shouldBe instanceOf<Project>()
            }
        }

        context("[Failure] 프로젝트 이름을 입력하지 않으면") {
            it("예외를 발생시킨다.") {
                // given
                val name = ""
                val summary = "프로젝트 요약"
                val types = setOf(ProjectType.APP)
                val workPeriodInMonths = 2
                val collaborationType = ProjectCollaborationType.ONLINE
                val communicationTool = "프로젝트 커뮤니케이션 도구"
                val objectives = "프로젝트 목표"
                val description = "프로젝트 설명"
                val makerIds = setOf(UlidUtil.create())

                // when, then
                shouldThrow<IllegalArgumentException> {
                    Project.create(
                        name = name,
                        summary = summary,
                        types = types,
                        workPeriodInMonths = workPeriodInMonths,
                        collaborationType = collaborationType,
                        communicationTool = communicationTool,
                        objectives = objectives,
                        description = description,
                        makerIds = makerIds,
                    )
                }
            }
        }

        context("[Failure] 프로젝트 이름이 20글자를 초과하면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "1".repeat(21)
                val summary = "프로젝트 요약"
                val types = setOf(ProjectType.APP)
                val workPeriodInMonths = 2
                val collaborationType = ProjectCollaborationType.ONLINE
                val communicationTool = "프로젝트 커뮤니케이션 도구"
                val objectives = "프로젝트 목표"
                val description = "프로젝트 설명"
                val makerIds = setOf(UlidUtil.create())

                // when, then
                shouldThrow<IllegalArgumentException> {
                    Project.create(
                        name = name,
                        summary = summary,
                        types = types,
                        workPeriodInMonths = workPeriodInMonths,
                        collaborationType = collaborationType,
                        communicationTool = communicationTool,
                        objectives = objectives,
                        description = description,
                        makerIds = makerIds,
                    )
                }
            }
        }

        context("[Failure] 프로젝트 요약을 입력하지 않으면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "프로젝트 이름"
                val summary = ""
                val types = setOf(ProjectType.APP)
                val workPeriodInMonths = 2
                val collaborationType = ProjectCollaborationType.ONLINE
                val communicationTool = "프로젝트 커뮤니케이션 도구"
                val objectives = "프로젝트 목표"
                val description = "프로젝트 설명"
                val makerIds = setOf(UlidUtil.create())

                // when, then
                shouldThrow<IllegalArgumentException> {
                    Project.create(
                        name = name,
                        summary = summary,
                        types = types,
                        workPeriodInMonths = workPeriodInMonths,
                        collaborationType = collaborationType,
                        communicationTool = communicationTool,
                        objectives = objectives,
                        description = description,
                        makerIds = makerIds,
                    )
                }
            }
        }

        context("[Failure] 프로젝트 요약이 500글자를 초과하면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "프로젝트 이름"
                val summary = "1".repeat(501)
                val types = setOf(ProjectType.APP)
                val workPeriodInMonths = 2
                val collaborationType = ProjectCollaborationType.ONLINE
                val communicationTool = "프로젝트 커뮤니케이션 도구"
                val objectives = "프로젝트 목표"
                val description = "프로젝트 설명"
                val makerIds = setOf(UlidUtil.create())

                // when, then
                shouldThrow<IllegalArgumentException> {
                    Project.create(
                        name = name,
                        summary = summary,
                        types = types,
                        workPeriodInMonths = workPeriodInMonths,
                        collaborationType = collaborationType,
                        communicationTool = communicationTool,
                        objectives = objectives,
                        description = description,
                        makerIds = makerIds,
                    )
                }
            }
        }

        context("[Failure] 프로젝트 타입을 하나도 선택하지 않으면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "프로젝트 이름"
                val summary = "프로젝트 요약"
                val types = setOf<ProjectType>()
                val workPeriodInMonths = 2
                val collaborationType = ProjectCollaborationType.ONLINE
                val communicationTool = "프로젝트 커뮤니케이션 도구"
                val objectives = "프로젝트 목표"
                val description = "프로젝트 설명"
                val makerIds = setOf(UlidUtil.create())

                // when, then
                shouldThrow<IllegalArgumentException> {
                    Project.create(
                        name = name,
                        summary = summary,
                        types = types,
                        workPeriodInMonths = workPeriodInMonths,
                        collaborationType = collaborationType,
                        communicationTool = communicationTool,
                        objectives = objectives,
                        description = description,
                        makerIds = makerIds,
                    )
                }
            }
        }

        context("[Failure] 프로젝트 기간이 1이상이 아니면") {
            it("예외를 발생시킨다") {
                // given
                val name = "프로젝트 이름"
                val summary = "프로젝트 요약"
                val types = setOf(ProjectType.APP)
                val workPeriodInMonths = 0
                val collaborationType = ProjectCollaborationType.ONLINE
                val communicationTool = "프로젝트 커뮤니케이션 도구"
                val objectives = "프로젝트 목표"
                val description = "프로젝트 설명"
                val makerIds = setOf(UlidUtil.create())

                // when, then
                shouldThrow<IllegalArgumentException> {
                    Project.create(
                        name = name,
                        summary = summary,
                        types = types,
                        workPeriodInMonths = workPeriodInMonths,
                        collaborationType = collaborationType,
                        communicationTool = communicationTool,
                        objectives = objectives,
                        description = description,
                        makerIds = makerIds,
                    )
                }
            }
        }
        context("[Failure] 프로젝트 커뮤니케이션 도구를 입력하지 않으면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "프로젝트 이름"
                val summary = "프로젝트 요약"
                val types = setOf(ProjectType.APP)
                val workPeriodInMonths = 2
                val collaborationType = ProjectCollaborationType.ONLINE
                val communicationTool = ""
                val objectives = "프로젝트 목표"
                val description = "프로젝트 설명"
                val makerIds = setOf(UlidUtil.create())

                // when, then
                shouldThrow<IllegalArgumentException> {
                    Project.create(
                        name = name,
                        summary = summary,
                        types = types,
                        workPeriodInMonths = workPeriodInMonths,
                        collaborationType = collaborationType,
                        communicationTool = communicationTool,
                        objectives = objectives,
                        description = description,
                        makerIds = makerIds,
                    )
                }
            }
        }

        context("[Failure] 프로젝트 커뮤니케이션 도구가 100글자를 초과하면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "프로젝트 이름"
                val summary = "프로젝트 요약"
                val types = setOf(ProjectType.APP)
                val workPeriodInMonths = 2
                val collaborationType = ProjectCollaborationType.ONLINE
                val communicationTool = "1".repeat(101)
                val objectives = "프로젝트 목표"
                val description = "프로젝트 설명"
                val makerIds = setOf(UlidUtil.create())

                // when, then
                shouldThrow<IllegalArgumentException> {
                    Project.create(
                        name = name,
                        summary = summary,
                        types = types,
                        workPeriodInMonths = workPeriodInMonths,
                        collaborationType = collaborationType,
                        communicationTool = communicationTool,
                        objectives = objectives,
                        description = description,
                        makerIds = makerIds,
                    )
                }
            }
        }

        context("[Failure] 프로젝트 목표를 입력하지 않으면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "프로젝트 이름"
                val summary = "프로젝트 요약"
                val types = setOf(ProjectType.APP)
                val workPeriodInMonths = 2
                val collaborationType = ProjectCollaborationType.ONLINE
                val communicationTool = "프로젝트 커뮤니케이션 도구"
                val objectives = ""
                val description = "프로젝트 설명"
                val makerIds = setOf(UlidUtil.create())

                // when, then
                shouldThrow<IllegalArgumentException> {
                    Project.create(
                        name = name,
                        summary = summary,
                        types = types,
                        workPeriodInMonths = workPeriodInMonths,
                        collaborationType = collaborationType,
                        communicationTool = communicationTool,
                        objectives = objectives,
                        description = description,
                        makerIds = makerIds,
                    )
                }
            }
        }

        context("[Failure] 프로젝트 목표가 100글자를 초과하면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "프로젝트 이름"
                val summary = "프로젝트 요약"
                val types = setOf(ProjectType.APP)
                val workPeriodInMonths = 2
                val collaborationType = ProjectCollaborationType.ONLINE
                val communicationTool = "프로젝트 커뮤니케이션 도구"
                val objectives = "1".repeat(101)
                val description = "프로젝트 설명"
                val makerIds = setOf(UlidUtil.create())

                // when, then
                shouldThrow<IllegalArgumentException> {
                    Project.create(
                        name = name,
                        summary = summary,
                        types = types,
                        workPeriodInMonths = workPeriodInMonths,
                        collaborationType = collaborationType,
                        communicationTool = communicationTool,
                        objectives = objectives,
                        description = description,
                        makerIds = makerIds,
                    )
                }
            }
        }

        context("[Failure] 프로젝트 설명을 입력하지 않으면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "프로젝트 이름"
                val summary = "프로젝트 요약"
                val types = setOf(ProjectType.APP)
                val workPeriodInMonths = 2
                val collaborationType = ProjectCollaborationType.ONLINE
                val communicationTool = "프로젝트 커뮤니케이션 도구"
                val objectives = "프로젝트 목표"
                val description = ""
                val makerIds = setOf(UlidUtil.create())

                // when, then
                shouldThrow<IllegalArgumentException> {
                    Project.create(
                        name = name,
                        summary = summary,
                        types = types,
                        workPeriodInMonths = workPeriodInMonths,
                        collaborationType = collaborationType,
                        communicationTool = communicationTool,
                        objectives = objectives,
                        description = description,
                        makerIds = makerIds,
                    )
                }
            }
        }

        context("[Failure] 프로젝트 설명이 2000글자를 초과하면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "프로젝트 이름"
                val summary = "프로젝트 요약"
                val types = setOf(ProjectType.APP)
                val workPeriodInMonths = 2
                val collaborationType = ProjectCollaborationType.ONLINE
                val communicationTool = "프로젝트 커뮤니케이션 도구"
                val objectives = "프로젝트 목표"
                val description = "1".repeat(2001)
                val makerIds = setOf(UlidUtil.create())

                // when, then
                shouldThrow<IllegalArgumentException> {
                    Project.create(
                        name = name,
                        summary = summary,
                        types = types,
                        workPeriodInMonths = workPeriodInMonths,
                        collaborationType = collaborationType,
                        communicationTool = communicationTool,
                        objectives = objectives,
                        description = description,
                        makerIds = makerIds,
                    )
                }
            }
        }

        context("[Failure] 프로젝트 참여자를 하나도 선택하지 않으면") {
            it("예외를 발생시킨다.") {
                // given
                val name = "프로젝트 이름"
                val summary = "프로젝트 요약"
                val types = setOf(ProjectType.APP)
                val workPeriodInMonths = 2
                val collaborationType = ProjectCollaborationType.ONLINE
                val communicationTool = "프로젝트 커뮤니케이션 도구"
                val objectives = "프로젝트 목표"
                val description = "프로젝트 설명"
                val makerIds = setOf<Ulid>()

                // when, then
                shouldThrow<IllegalArgumentException> {
                    Project.create(
                        name = name,
                        summary = summary,
                        types = types,
                        workPeriodInMonths = workPeriodInMonths,
                        collaborationType = collaborationType,
                        communicationTool = communicationTool,
                        objectives = objectives,
                        description = description,
                        makerIds = makerIds,
                    )
                }
            }
        }
    }
})
