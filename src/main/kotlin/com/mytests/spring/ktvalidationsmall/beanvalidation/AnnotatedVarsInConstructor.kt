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
class AnnotatedVarsInConstructor(
    @NotNull @NotEmpty var name: String?,
    @NotNull @Past var birthday: LocalDate? = null,
    @Min(0) @Max(130) var age: Int? = null,
    @NotBlank @Email var email: String? = null,
)

{}