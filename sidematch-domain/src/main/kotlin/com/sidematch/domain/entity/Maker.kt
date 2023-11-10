package com.sidematch.domain.entity

import com.github.f4b6a3.ulid.Ulid
import com.sidematch.common.entity.Entity
import com.sidematch.common.vo.URL
import com.sidematch.domain.enum.MakerPosition

data class Maker(
    private val name: String,
    private val introduction: String,
    private val interest: String,
    private val profileImageUrl: URL,
    private val positions: Set<MakerPosition>,
    private val skillIds: Set<Ulid>,
    private val githubUrl: URL,
    private val portfolioUrl: URL,
    private val careerIds: Set<Ulid>,
    private val purpose: String,
) : Entity()
