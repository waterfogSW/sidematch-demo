package com.sidematch.common.util

import com.github.f4b6a3.ulid.Ulid
import com.github.f4b6a3.ulid.UlidCreator

class UlidUtil {
    companion object {
        fun create(): Ulid {
            return UlidCreator.getMonotonicUlid()
        }
    }

}
