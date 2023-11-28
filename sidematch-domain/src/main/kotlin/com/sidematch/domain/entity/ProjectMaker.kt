package com.sidematch.domain.entity

import com.github.f4b6a3.ulid.Ulid
import com.sidematch.common.entity.Entity

data class ProjectMaker (
    val projectId: Ulid,
    val makerId: Ulid,
): Entity()
