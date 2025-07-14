package com.mytests.spring.ktvalidationsmall.beanvalidation

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import java.time.LocalDate

// here all validations will be applied! But IDEA (falsely) reports all vals annotated with @field:NotNull as an error
// note that other constraints are not reported at all
class AnnotatedFieldVals(
    @field:NotNull(message = "name can't be null") @field:NotEmpty(message = "name can't be empty") val name: String?,
    @field:NotNull(message = "date can't be null") @field:Past(message = "date can't be in the future") val birthday: LocalDate?,
    @field:Min(0, message = "age can't be negative") @field:Max(130, message = "age can't be more than 130") val age: Int? = null,
    @field:NotBlank(message = "email can't be blank") @field:Email(message = "email is not valid") val email: String? = null,
)

{}