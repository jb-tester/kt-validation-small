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
class AnnotatedGetVals (
    @get:NotNull @get:NotEmpty val name: String?,
    @get:NotNull @get:Past val birthday: LocalDate? = null,
    @get:Min(0) @get:Max(130) val age: Int? = null,
    @get:NotBlank @get:Email val email: String? = null,
)