package com.mytests.spring.ktvalidationsmall.beanvalidation

import jakarta.validation.ConstraintViolation
import jakarta.validation.Validation
import jakarta.validation.Validator
import jakarta.validation.ValidatorFactory
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate
import kotlin.collections.forEach


class AnnotatedParamsVarsTest {
    private var validator: Validator? = null

    @BeforeEach
    fun setUp() {
        val factory: ValidatorFactory = Validation.buildDefaultValidatorFactory()
        this.validator = factory.validator
    }

    @Test
    fun validationAnnotationsIgnoredTest() {

        val obj = AnnotatedParamsVars(null, LocalDate.of(2070, 5, 21), -55, "user" )
        val violations: MutableSet<ConstraintViolation<AnnotatedParamsVars?>?> =
            validator!!.validate<AnnotatedParamsVars?>(obj)
        violations.forEach { println(it?.message) }
        assertEquals(violations.size, 0)
    }
}