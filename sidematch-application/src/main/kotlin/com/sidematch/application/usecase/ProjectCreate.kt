package com.sidematch.application.usecase

import com.sidematch.application.port.ProjectRepository
import com.sidematch.domain.entity.Project
import org.springframework.stereotype.Service

@Service
class ProjectCreate(
    private val projectRepository: ProjectRepository
) : ProjectCreateUseCase {

    override fun invoke(command: ProjectCreateUseCase.Command): ProjectCreateUseCase.Result {
        val newProject = Project.create(
            name = command.name,
            summary = command.summary,
            types = command.types,
            workPeriodInMonths = command.workPeriodInMonths,
            collaborationType = command.collaborationType,
            communicationTool = command.communicationTool,
            objectives = command.objectives,
            description = command.description,
            makerIds = command.makerIds,
        )

        projectRepository.save(newProject)

        return ProjectCreateUseCase.Result.Success(newProject.id)
    }
}
