package com.sidematch.application.port.stub

import com.github.f4b6a3.ulid.Ulid
import com.sidematch.application.port.ProjectRepository
import com.sidematch.domain.entity.Project

class ProjectRepositoryStub: ProjectRepository {

    private val projectMap: MutableMap<Ulid, Project> = mutableMapOf()

    override fun save(project: Project) {
        projectMap[project.id] = project
    }

    override fun findById(id: Ulid): Project? {
        return projectMap[id]
    }
}
