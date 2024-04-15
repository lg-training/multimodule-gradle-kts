package com.lg5.app1

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ModuleOneTest {

    lateinit var sut: ModuleOne

    @BeforeEach
    fun setUp() {
        sut = ModuleOne("1")
    }

    @Test
    fun getMasp() {
        sut.masp.forEach { t, u -> println("$t $u"); }

        assertFalse(sut.masp.isEmpty())
    }
}