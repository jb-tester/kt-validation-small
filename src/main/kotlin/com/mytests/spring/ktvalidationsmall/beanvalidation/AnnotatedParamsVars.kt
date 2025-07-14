package com.mytests.spring.ktvalidationsmall.beanvalidation

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import java.time.LocalDate


// here all validations will be ignored!
// However, IDEA reports no errors
class AnnotatedParamsVars(
    @param:NotNull @param:NotEmpty var name: String?,
    @param:NotNull @param:Past var birthday: LocalDate? = null,
    @param:Min(0) @param:Max(130) var age: Int? = null,
    @param:NotBlank @param:Email var email: String? = null,
)