package com.sidematch.domain.entity

import com.github.f4b6a3.ulid.Ulid
import com.sidematch.common.entity.Entity
import com.sidematch.domain.enum.ProjectCollaborationType
import com.sidematch.domain.enum.ProjectType

data class Project(
    private val name: String,
    private val summary: String,
    private val types: Set<ProjectType>,
    private val collaborationType: ProjectCollaborationType,
    private val communicationTool: String,
    private val objectives: String,
    private val description: String,
    private val makerIds: Set<Ulid>,
) : Entity()
