package com.mytests.spring.ktvalidationsmall.beanvalidation

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import java.time.LocalDate

// here all validations will be applied! IDEA reports no errors (ok)
class AnnotatedVarsInBody{
    @NotNull(message = "name is required") @NotEmpty(message = "name can't be empty") var name: String? = null
    @NotNull(message = "birthday is required") @Past(message = "birthday must be in the past") var birthday: LocalDate? = null
    @Min(value = 0, message = "age must be non-negative") @Max(value = 130, message = "age must be less than or equal to 130") var age: Int? = null
    @NotBlank(message = "email is required") @Email(message = "email must be a valid email address") var email: String? = null


}