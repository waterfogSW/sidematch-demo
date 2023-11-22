package com.sidematch.application.port

import com.github.f4b6a3.ulid.Ulid
import com.sidematch.domain.entity.Project

interface ProjectRepository {

    fun save(project: Project)

    fun findById(id: Ulid): Project?
}
