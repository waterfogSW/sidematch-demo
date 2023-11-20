package com.sidematch.common.entity

import com.github.f4b6a3.ulid.Ulid
import com.sidematch.common.util.UlidUtil
import java.time.LocalDateTime

abstract class Entity(
    val id: Ulid = UlidUtil.create(),
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
) : SelfValidating()
