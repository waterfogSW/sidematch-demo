package com.sidematch.common.exception

class NotFoundException(
    override val message: String,
): RuntimeException()
