package com.sidematch.domain.entity

import com.github.f4b6a3.ulid.Ulid
import com.sidematch.common.entity.Entity
import com.sidematch.domain.enum.ProjectCollaborationType
import com.sidematch.domain.enum.ProjectType
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.Length

data class Project(
    @field:Length(min = 1, max = 20, message = "프로젝트 이름은 1자 이상 20자 이하로 입력해주세요.")
    private val name: String,

    @field:Length(min = 1, max = 100, message = "프로젝트 요약은 1자 이상 500자 이하로 입력해주세요.")
    private val summary: String,

    @field:Size(min = 1, message = "프로젝트 타입은 최소 1개 이상 선택해주세요.")
    private val types: Set<ProjectType>,

    @field:Positive(message = "프로젝트 기간은 1개월 이상이어야 합니다.")
    private val workPeriodInMonths: Int,

    private val collaborationType: ProjectCollaborationType,

    @field:Length(min = 1, max = 100, message = "프로젝트 커뮤니케이션 도구는 1자 이상 100자 이하로 입력해주세요.")
    private val communicationTool: String,

    @field:Length(min = 1, max = 100, message = "프로젝트 목표는 1자 이상 100자 이하로 입력해주세요.")
    private val objectives: String,

    @field:Length(min = 1, max = 2000, message = "프로젝트 설명은 1자 이상 2000자 이하로 입력해주세요.")
    private val description: String,

    @field:Size(min = 1, message = "프로젝트 참여자는 최소 1명 이상이어야 합니다.")
    private val makerIds: Set<Ulid>,
) : Entity() {

    init {
        this.validateSelf(this::class.java)
    }

    companion object {
        fun create(
            name: String,
            summary: String,
            types: Set<ProjectType>,
            workPeriodInMonths: Int?,
            collaborationType: ProjectCollaborationType,
            communicationTool: String,
            objectives: String,
            description: String,
            makerIds: Set<Ulid>,
        ): Project {
            return Project(
                name = name,
                summary = summary,
                types = types,
                workPeriodInMonths = workPeriodInMonths ?: 2,
                collaborationType = collaborationType,
                communicationTool = communicationTool,
                objectives = objectives,
                description = description,
                makerIds = makerIds,
            )
        }
    }
}
