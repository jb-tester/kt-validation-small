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
// IDEA reports only the @NotNull-annotated vals as errors
class AnnotatedValsInConstructor(
    @NotNull @NotEmpty val name: String?,
    @NotNull @Past val birthday: LocalDate? = null,
    @Min(0) @Max(130) val age: Int? = null,
    @NotBlank @Email val email: String? = null,
)

