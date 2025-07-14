package com.mytests.spring.ktvalidationsmall.beanvalidation

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping


@RestController
@RequestMapping("/")
class TestController {

    @PostMapping("/annotated-field-vals")
    fun annotatedFieldValsTest(@Valid @RequestBody obj: AnnotatedFieldVals, bindingResult: BindingResult ): ResponseEntity<String> {
        return ResponseEntity.ok(bindingResult.allErrors.toString())
    }

    @PostMapping("/annotated-vals-in-body")
    fun annotatedValsInBodyTest(@Valid @RequestBody obj: AnnotatedValsInBody, bindingResult: BindingResult ): ResponseEntity<String> {
        return ResponseEntity.ok(bindingResult.allErrors.toString())
    }

    @PostMapping("/annotated-vals-in-constructor")
    fun annotatedValsInConstructorTest(@Valid @RequestBody obj: AnnotatedValsInConstructor, bindingResult: BindingResult ): ResponseEntity<String> {
        return ResponseEntity.ok(bindingResult.allErrors.toString())
    }

    @PostMapping("/annotated-vars-in-body")
    fun annotatedVarsInBodyTest(@Valid @RequestBody obj: AnnotatedVarsInBody, bindingResult: BindingResult ): ResponseEntity<String> {
        return ResponseEntity.ok(bindingResult.allErrors.toString())
    }
    @PostMapping("/annotated-vars-in-constructor")
    fun annotatedVarsInConstructorTest(@Valid @RequestBody obj: AnnotatedVarsInConstructor, bindingResult: BindingResult ): ResponseEntity<String> {
        return ResponseEntity.ok(bindingResult.allErrors.toString())
    }

    @PostMapping("/vars-with-annotated-types")
    fun varsWithAnnotatedTypesTest(@Valid @RequestBody obj: VarsWithAnnotatedTypes, bindingResult: BindingResult ): ResponseEntity<String> {
        return ResponseEntity.ok(bindingResult.allErrors.toString())
    }
}
