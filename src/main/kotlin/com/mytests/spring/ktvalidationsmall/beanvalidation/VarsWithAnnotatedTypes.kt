package com.mytests.spring.ktvalidationsmall.beanvalidation

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import java.time.LocalDate

// here all validations will be ignored! But IDEA reports no errors
class VarsWithAnnotatedTypes{
     var name: @NotNull @NotEmpty String? = null
     var birthday: @NotNull @Past LocalDate? = null
     var age: @Min(0) @Max(130) Int? = null
     var email: @NotBlank @Email String? = null


}