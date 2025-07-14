package com.mytests.spring.ktvalidationsmall.beanvalidation

import jakarta.validation.ConstraintViolation
import jakarta.validation.Validation
import jakarta.validation.Validator
import jakarta.validation.ValidatorFactory
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate


class AnnotatedVarsInBodyTest {
    private var validator: Validator? = null

    @BeforeEach
    fun setUp() {
        val factory: ValidatorFactory = Validation.buildDefaultValidatorFactory()
        this.validator = factory.validator
    }

    @Test
    fun allValidationAnnotationsTest() {

        val obj = AnnotatedVarsInBody()
        obj.name = null
        obj.birthday = LocalDate.of(2070, 5, 21)
        obj.age = -55
        obj.email = "user"
        val violations: MutableSet<ConstraintViolation<AnnotatedVarsInBody?>?> =
            validator!!.validate<AnnotatedVarsInBody?>(obj)
        violations.forEach { println(it?.message) }
        assertEquals(violations.size, 5)
    }

}