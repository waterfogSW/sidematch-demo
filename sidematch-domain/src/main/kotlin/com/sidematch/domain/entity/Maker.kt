package com.sidematch.domain.entity

import com.github.f4b6a3.ulid.Ulid
import com.sidematch.common.entity.Entity
import com.sidematch.common.validation.annotation.ValidURL
import com.sidematch.common.validation.validator.validate
import com.sidematch.common.vo.URL
import com.sidematch.domain.enum.MakerPosition
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.Length

data class Maker(
    @field:Length(min = 1, max = 20, message = "이름은 1자 이상 20자 이하로 입력해주세요.")
    private val name: String,

    @field:Length(max = 2000)
    private val introduction: String? = null,

    @field:Length(max = 20)
    private val interest: String? = null,

    @field:ValidURL(nullable = true)
    private val profileImageUrl: URL? = null,

    @field:Size(max = 3)
    private val positions: Set<MakerPosition> = emptySet(),

    private val skillIds: Set<Ulid> = emptySet(),

    @field:ValidURL(nullable = true)
    private val githubUrl: URL? = null,

    @field:ValidURL(nullable = true)
    private val portfolioUrl: URL? = null,

    @field:Size(max = 10)
    private val careerIds: Set<Ulid> = emptySet(),

    @field:Length(max = 100)
    private val purpose: String? = null,
) : Entity() {

    init {
        validate(this)
    }

    companion object {

        fun create(
            name: String,
            introduction: String? = null,
            interest: String? = null,
            profileImageUrl: URL? = null,
            positions: Set<MakerPosition> = emptySet(),
            skillIds: Set<Ulid> = emptySet(),
            githubUrl: URL? = null,
            portfolioUrl: URL? = null,
            careerIds: Set<Ulid> = emptySet(),
            purpose: String? = null,
        ): Maker {
            return Maker(
                name = name,
                introduction = introduction,
                interest = interest,
                profileImageUrl = profileImageUrl,
                positions = positions,
                skillIds = skillIds,
                githubUrl = githubUrl,
                portfolioUrl = portfolioUrl,
                careerIds = careerIds,
                purpose = purpose,
            )
        }
    }

}
