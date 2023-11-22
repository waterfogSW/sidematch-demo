package com.sidematch.application.port

import com.sidematch.domain.entity.Project

interface ProjectRepository {

    fun save(project: Project)
}
