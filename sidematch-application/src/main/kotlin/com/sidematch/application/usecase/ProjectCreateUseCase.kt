package com.sidematch.application.usecase

import com.github.f4b6a3.ulid.Ulid
import com.sidematch.domain.enum.ProjectCollaborationType
import com.sidematch.domain.enum.ProjectType

interface ProjectCreateUseCase {

    fun invoke(command: Command): Result

    data class Command(
        val name: String,
        val summary: String,
        val types: Set<ProjectType>,
        val workPeriodInMonths: Int,
        val collaborationType: ProjectCollaborationType,
        val communicationTool: String,
        val objectives: String,
        val description: String,
        val makerIds: Set<Ulid>,
    )

    sealed interface Result {
        data class Success(val projectId: Ulid) : Result
        data class Failure(val throwable: Throwable) : Result
    }

}
