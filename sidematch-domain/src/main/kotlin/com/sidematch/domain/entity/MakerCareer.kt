package com.sidematch.domain.entity

import com.sidematch.common.entity.Entity
import java.time.LocalDateTime

data class MakerCareer(
    private val name: String,
    private val position: String,
    private val isCurrent: Boolean,
    private val startDate: LocalDateTime,
    private val endDateTime: LocalDateTime?,
    private val description: String,
) : Entity()
