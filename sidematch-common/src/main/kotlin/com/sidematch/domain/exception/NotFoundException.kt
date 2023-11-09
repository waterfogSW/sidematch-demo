package com.sidematch.domain.exception

class NotFoundException(
    override val message: String,
): RuntimeException()
