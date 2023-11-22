package com.sidematch.application.usecase

import com.github.f4b6a3.ulid.UlidCreator
import com.sidematch.application.port.stub.ProjectRepositoryStub
import com.sidematch.domain.enum.ProjectCollaborationType
import com.sidematch.domain.enum.ProjectType
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.DisplayName

@DisplayName("ProjectCreateUseCase")
class ProjectCreateTest : DescribeSpec({


    describe("invoke") {
        it("프로젝트 생성 성공") {
            // arrange
            val projectRepositorySpy = ProjectRepositoryStub()
            val sut = ProjectCreate(
                projectRepository = projectRepositorySpy
            )
            val command = ProjectCreateUseCase.Command(
                name = "프로젝트 이름",
                summary = "프로젝트 요약",
                types = setOf(ProjectType.APP),
                workPeriodInMonths = 1,
                collaborationType = ProjectCollaborationType.ONLINE,
                communicationTool = "프로젝트 커뮤니케이션 툴",
                objectives = "프로젝트 목표",
                description = "프로젝트 설명",
                makerIds = setOf(UlidCreator.getUlid()),
            )

            // act
            val actual: ProjectCreateUseCase.Result = sut.invoke(command)

            // assert
            (actual is ProjectCreateUseCase.Result.Success) shouldBe true
        }

        context("프로젝트 생성 성공시") {
            it("프로젝트를 저장한다.") {
                // arrange
                val projectRepositorySpy = ProjectRepositoryStub()
                val sut = ProjectCreate(
                    projectRepository = projectRepositorySpy
                )
                val command = ProjectCreateUseCase.Command(
                    name = "프로젝트 이름",
                    summary = "프로젝트 요약",
                    types = setOf(ProjectType.APP),
                    workPeriodInMonths = 1,
                    collaborationType = ProjectCollaborationType.ONLINE,
                    communicationTool = "프로젝트 커뮤니케이션 툴",
                    objectives = "프로젝트 목표",
                    description = "프로젝트 설명",
                    makerIds = setOf(UlidCreator.getUlid()),
                )

                // act
                val actual: ProjectCreateUseCase.Result = sut.invoke(command)

                // assert
                (actual is ProjectCreateUseCase.Result.Success) shouldBe true
                (actual as ProjectCreateUseCase.Result.Success)
                projectRepositorySpy.findById(actual.projectId) shouldNotBe null
            }
        }
    }


})
