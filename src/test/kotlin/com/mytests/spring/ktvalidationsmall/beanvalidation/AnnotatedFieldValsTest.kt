package com.mytests.spring.ktvalidationsmall.beanvalidation

import jakarta.validation.ConstraintViolation
import jakarta.validation.Validation
import jakarta.validation.Validator
import jakarta.validation.ValidatorFactory
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate


class AnnotatedFieldValsTest {
    private var validator: Validator? = null

    @BeforeEach
    fun setUp() {
        val factory: ValidatorFactory = Validation.buildDefaultValidatorFactory()
        this.validator = factory.validator
    }

    @Test
    fun notNullNameTest() {

        val obj = AnnotatedFieldVals(null, LocalDate.of(1970, 5, 21), 55, "user@example.com" )
        val violations: MutableSet<ConstraintViolation<AnnotatedFieldVals?>?> =
            validator!!.validate<AnnotatedFieldVals?>(obj)
        violations.forEach { println(it?.message) }
        assertEquals(violations.size, 2)
    }
    @Test
    fun notEmptyNameTest() {

        val obj = AnnotatedFieldVals("", LocalDate.of(1970, 5, 21), 55, "user@example.com" )
        val violations: MutableSet<ConstraintViolation<AnnotatedFieldVals?>?> =
            validator!!.validate<AnnotatedFieldVals?>(obj)
        violations.forEach { println(it?.message) }
        assertEquals(violations.size, 1)
    }
    @Test
    fun notPastBirthdayTest() {
        val obj = AnnotatedFieldVals("Ivan", LocalDate.of(2026, 5, 21), 55, "user@example.com" )
        val violations: MutableSet<ConstraintViolation<AnnotatedFieldVals?>?> =
            validator!!.validate<AnnotatedFieldVals?>(obj)
        violations.forEach { println(it?.message) }
        assertEquals(violations.size, 1)
    }

    @Test
    fun incorrectAgeTest() {
        val obj = AnnotatedFieldVals("Ivan", LocalDate.of(1970, 5, 21), 155, "user@example.com" )
        val violations: MutableSet<ConstraintViolation<AnnotatedFieldVals?>?> =
            validator!!.validate<AnnotatedFieldVals?>(obj)
        violations.forEach { println(it?.message) }
        assertEquals(violations.size, 1)
    }

    @Test
    fun nonBlankEmailTest() {
        val obj = AnnotatedFieldVals("Ivan", LocalDate.of(1970, 5, 21), 55, "" )
        val violations: MutableSet<ConstraintViolation<AnnotatedFieldVals?>?> =
            validator!!.validate<AnnotatedFieldVals?>(obj)
        violations.forEach { println(it?.message) }
        assertEquals(violations.size, 1)
    }
    @Test
    fun invalidEmailTest() {
        val obj = AnnotatedFieldVals("Ivan", LocalDate.of(1970, 5, 21), 55, "ivan" )
        val violations: MutableSet<ConstraintViolation<AnnotatedFieldVals?>?> =
            validator!!.validate<AnnotatedFieldVals?>(obj)
        violations.forEach { println(it?.message) }
        assertEquals(violations.size, 1)
    }
}