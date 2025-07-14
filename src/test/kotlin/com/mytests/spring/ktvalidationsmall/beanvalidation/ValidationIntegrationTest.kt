package com.mytests.spring.ktvalidationsmall.beanvalidation

import jakarta.validation.ConstraintViolation
import jakarta.validation.Validation
import jakarta.validation.Validator
import jakarta.validation.ValidatorFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

class ValidationIntegrationTest {
    private var validator: Validator? = null

    @BeforeEach
    fun setUp() {
        val factory: ValidatorFactory = Validation.buildDefaultValidatorFactory()
        this.validator = factory.validator
    }


    private fun createUser(): User {
       // val user = User("John", true, null, 18)
        val user = User()
        user.name = "MyName"
        return user
    }

    @Test
    fun ifNameIsNull_nameValidationFails() {
       // val user = User(null,true,"Its all about me!!",50)
        val user = User()
        user.isWorking = true
        user.aboutMe = "aaaaaaaaaaaaaaaaaaaaaa"
        user.age = 50
        val violations: MutableSet<ConstraintViolation<User?>?> =
            validator!!.validate<User?>(user)
        assertEquals(violations.isEmpty(), false)
    }

    @Test
    fun ifSizeNotInRange_aboutMeValidationFails() {
       // val user = User("MyName",false, "Its all about me!!", 50)
        val user = User()
        user.name = "MyName"
        user.age = 50
        user.aboutMe = "Its all"
        val violations: MutableSet<ConstraintViolation<User?>?> =
            validator!!.validate<User?>(user)
        assertEquals(violations.isEmpty(), false)
    }

    @Test
    fun ifWorkingIsFalse_workingValidationFails() {
    //    val user = User("MyName",false, "Its all about me!!", 50)
        val user = User()
        user.name = "John"
        user.isWorking = false
        user.age = 50

        val violations: MutableSet<ConstraintViolation<User?>?> =
            validator!!.validate<User?>(user)
        assertEquals(violations.isEmpty(), false)
    }

    @Test
    fun ifAgeNotRange_ageValidationFails() {
        //val user = User("MyName",false, "Its all about me!!", 8)
        val user = User()
        user.name = "MyName"
        user.age = 8
        val violations: MutableSet<ConstraintViolation<User?>?> =
            validator!!.validate<User?>(user)
        assertEquals(violations.isEmpty(), false)
    }

    @Test
    fun ifFnameNullAgeNotRangeAndWorkingIsFalse_validationFailsWithThreeErrors() {
       // val user = User(null,false, "Its all about me!!", 300)
        val user = User()
        user.age = 300
        user.isWorking = false
        val violations: MutableSet<ConstraintViolation<User?>?> =
            validator!!.validate<User?>(user)
        assertEquals(violations.isEmpty(), false)
        assertEquals(violations.size, 3)
    }

    @Test
    fun givenInvalidEmail_thenValidationFails() {
        //val user = User("John", true, null, 18, "john")
        val user = User()
        user.name = "John"
        user.email = "john"
        val violations: MutableSet<ConstraintViolation<User?>?> =
            validator!!.validate<User?>(user)
        assertEquals(1, violations.size)
    }

    @Test
    fun givenBlankPreference_thenValidationFails() {
      //  val user = User("John", true, null, 18, null, mutableListOf<String?>(" "))
       val user = User()
        user.name = "John"
        user.preferences = mutableListOf<String?>(" ")
        val violations: MutableSet<ConstraintViolation<User?>?> =
            validator!!.validate<User?>(user)
        assertEquals(1, violations.size)
    }

    @Test
    fun givenEmptyOptional_thenValidationSucceeds() {
        val user = createUser()

        val violations: MutableSet<ConstraintViolation<User?>?> =
            validator!!.validate<User?>(user)
        assertEquals(0, violations.size)
    }

    @Test
    fun givenPastDateOfBirth_thenValidationSuccess() {
        //val user = User("John", true, null, 18, null, null, LocalDate.of(1980, 5, 20))
        val user = User()
        user.name = "John"
        user.setDateOfBirth(LocalDate.of(1980, 5, 20))
        val violations: MutableSet<ConstraintViolation<User?>?> =
            validator!!.validate<User?>(user)
        assertEquals(0, violations.size)
    }
}
