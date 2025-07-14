package com.mytests.spring.ktvalidationsmall.beanvalidation

import jakarta.validation.constraints.*
import java.time.LocalDate
import java.util.*

class User {
    var name: @NotNull(message = "Name cannot be null") String? = null

    var isWorking: @AssertTrue Boolean = false

    var aboutMe: @Size(
        min = 10,
        max = 200,
        message = "Number of characters should be in between 10 and 200 inclusive"
    ) String? = null

    var age: @Min(value = 18, message = "Age should not be less than 18") @Max(
        value = 150,
        message = "Age should not be more than 150"
    ) Int = 0

    var email: @Email(message = "Email should be valid") String? = null

    var preferences: MutableList<String?>? = null

    private var dateOfBirth: LocalDate? = null

    fun getDateOfBirth(): Optional<LocalDate?> {
        return Optional.ofNullable<@Past LocalDate?>(dateOfBirth)
    }

    fun setDateOfBirth(dateOfBirth: LocalDate?) {
        this.dateOfBirth = dateOfBirth
    }
}
