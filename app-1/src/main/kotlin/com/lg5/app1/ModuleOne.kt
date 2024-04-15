package com.lg5.app1

import com.google.common.collect.ImmutableMap
import com.lg5.app1.common.CommonEntity

class ModuleOne(id: String) : CommonEntity(id) {

    val masp = ImmutableMap.builder<Any, Any>()
        .put(1, "hello")
        .build()
}