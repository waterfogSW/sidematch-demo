package com.sidematch.domain.entity

import com.sidematch.common.entity.Entity
import org.hibernate.validator.constraints.Length
import java.time.LocalDateTime

data class MakerCareer(
    @field:Length(min = 1, max = 20, message = "회사/학교명은 1자 이상 20자 이하로 입력해주세요.") private val name: String,

    @field:Length(min = 1, max = 20, message = "직책은 1자 이상 20자 이하로 입력해주세요.") private val position: String? = null,

    private val isCurrent: Boolean,

    private val startDate: LocalDateTime,

    private val endDateTime: LocalDateTime?,

    @field:Length(max = 2000, message = "내용은 2000자 이하로 입력해주세요.") private val description: String,
) : Entity() {

    init {
        this.validateSelf(this::class.java)
        this.validateIsCurrent()
    }

    companion object {
        fun create(
            name: String,
            position: String? = null,
            isCurrent: Boolean,
            startDate: LocalDateTime,
            endDateTime: LocalDateTime?,
            description: String,
        ): MakerCareer {
            return MakerCareer(
                name = name,
                position = position,
                isCurrent = isCurrent,
                startDate = startDate,
                endDateTime = endDateTime,
                description = description,
            )
        }
    }

    private fun validateIsCurrent() {
        if (isCurrent && endDateTime != null) {
            throw IllegalArgumentException("현재 직장/학교인 경우, 퇴사/졸업일을 입력할 수 없습니다.")
        }

        if (!isCurrent && endDateTime == null) {
            throw IllegalArgumentException("퇴사/졸업일을 입력하지 않은 경우, 현재 직장/학교 여부를 체크해주세요.")
        }
    }
}
