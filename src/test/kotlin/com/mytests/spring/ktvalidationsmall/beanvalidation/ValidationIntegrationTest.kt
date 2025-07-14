package com.mytests.spring.beanvalidationkotlin.javaxval.beanvalidation

import com.mytests.spring.beanvalidationkotlin.beanvalidation.User
import jakarta.validation.ConstraintViolation
import jakarta.validation.ValidatorFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

class ValidationIntegrationTest {
    private var validator: jakarta.validation.Validator? = null

    @BeforeEach
    fun setUp() {
        val factory: ValidatorFactory = jakarta.validation.Validation.buildDefaultValidatorFactory()
        this.validator = factory.getValidator()
    }


    private fun createUser(): com.mytests.spring.beanvalidationkotlin.beanvalidation.User {
        val user = com.mytests.spring.beanvalidationkotlin.beanvalidation.User("John", true, null, 18)
        return user
    }

    @Test
    fun ifNameIsNull_nameValidationFails() {
        val user = com.mytests.spring.beanvalidationkotlin.beanvalidation.User(null,true,"Its all about me!!",50)
        val violations: kotlin.collections.MutableSet<ConstraintViolation<User?>?> =
            validator!!.validate<com.mytests.spring.beanvalidationkotlin.beanvalidation.User?>(user)
        assertEquals(violations.isEmpty(), false)
    }

    @Test
    fun ifSizeNotInRange_aboutMeValidationFails() {
        val user = com.mytests.spring.beanvalidationkotlin.beanvalidation.User("MyName",false, "Its all about me!!", 50)

        val violations: kotlin.collections.MutableSet<ConstraintViolation<com.mytests.spring.beanvalidationkotlin.beanvalidation.User?>?> =
            validator!!.validate<com.mytests.spring.beanvalidationkotlin.beanvalidation.User?>(user)
        assertEquals(violations.isEmpty(), false)
    }

    @Test
    fun ifWorkingIsFalse_workingValidationFails() {
        val user = com.mytests.spring.beanvalidationkotlin.beanvalidation.User("MyName",false, "Its all about me!!", 50)


        val violations: kotlin.collections.MutableSet<ConstraintViolation<com.mytests.spring.beanvalidationkotlin.beanvalidation.User?>?> =
            validator!!.validate<com.mytests.spring.beanvalidationkotlin.beanvalidation.User?>(user)
        assertEquals(violations.isEmpty(), false)
    }

    @Test
    fun ifAgeNotRange_ageValidationFails() {
        val user = com.mytests.spring.beanvalidationkotlin.beanvalidation.User("MyName",false, "Its all about me!!", 8)


        val violations: kotlin.collections.MutableSet<ConstraintViolation<com.mytests.spring.beanvalidationkotlin.beanvalidation.User?>?> =
            validator!!.validate<com.mytests.spring.beanvalidationkotlin.beanvalidation.User?>(user)
        assertEquals(violations.isEmpty(), false)
    }

    @Test
    fun ifFnameNullAgeNotRangeAndWorkingIsFalse_validationFailsWithThreeErrors() {
        val user = com.mytests.spring.beanvalidationkotlin.beanvalidation.User(null,false, "Its all about me!!", 300)

        val violations: kotlin.collections.MutableSet<ConstraintViolation<com.mytests.spring.beanvalidationkotlin.beanvalidation.User?>?> =
            validator!!.validate<com.mytests.spring.beanvalidationkotlin.beanvalidation.User?>(user)
        assertEquals(violations.isEmpty(), false)
        assertEquals(violations.size, 3)
    }

    @Test
    fun givenInvalidEmail_thenValidationFails() {
        val user = com.mytests.spring.beanvalidationkotlin.beanvalidation.User("John", true, null, 18, "john")

        val violations: kotlin.collections.MutableSet<ConstraintViolation<com.mytests.spring.beanvalidationkotlin.beanvalidation.User?>?> =
            validator!!.validate<com.mytests.spring.beanvalidationkotlin.beanvalidation.User?>(user)
        assertEquals(1, violations.size)
    }

    @Test
    fun givenBlankPreference_thenValidationFails() {
        val user = com.mytests.spring.beanvalidationkotlin.beanvalidation.User("John", true, null, 18, null, mutableListOf<String?>(" "))

        val violations: kotlin.collections.MutableSet<ConstraintViolation<com.mytests.spring.beanvalidationkotlin.beanvalidation.User?>?> =
            validator!!.validate<com.mytests.spring.beanvalidationkotlin.beanvalidation.User?>(user)
        assertEquals(1, violations.size)
    }

    @Test
    fun givenEmptyOptional_thenValidationSucceeds() {
        val user = createUser()

        val violations: kotlin.collections.MutableSet<ConstraintViolation<com.mytests.spring.beanvalidationkotlin.beanvalidation.User?>?> =
            validator!!.validate<com.mytests.spring.beanvalidationkotlin.beanvalidation.User?>(user)
        assertEquals(0, violations.size)
    }

    @Test
    fun givenPastDateOfBirth_thenValidationSuccess() {
        val user = com.mytests.spring.beanvalidationkotlin.beanvalidation.User("John", true, null, 18, null, null, LocalDate.of(1980, 5, 20))

        val violations: kotlin.collections.MutableSet<ConstraintViolation<com.mytests.spring.beanvalidationkotlin.beanvalidation.User?>?> =
            validator!!.validate<com.mytests.spring.beanvalidationkotlin.beanvalidation.User?>(user)
        assertEquals(0, violations.size)
    }
}
