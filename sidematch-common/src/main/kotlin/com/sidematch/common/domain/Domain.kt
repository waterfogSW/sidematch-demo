package com.sidematch.common.domain

import com.github.f4b6a3.ulid.Ulid
import com.sidematch.common.util.UlidUtil
import java.time.LocalDateTime

abstract class Domain(
    private val id: Ulid? = UlidUtil.create(),
    private val createdAt: LocalDateTime = LocalDateTime.now(),
    private val updatedAt: LocalDateTime = LocalDateTime.now(),
)