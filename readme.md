## Kotlin Validation inspection problems

the inspection has been implemented (https://youtrack.jetbrains.com/issue/KTIJ-33476/Fix-Hibernate-validation-issues-with-Kotlin-val-properties)
This inspection detects `val` properties annotated with `jakarta.validation.constraints.*` annotations ans suggests to replace them with `var`

Problems:
1. inspection doesn't work in the projects that have the `jspring-boot-starter-validation` dependency only; it requires the extra `spring-boot-starter-data-jpa` dependency additionally for some reason
2. inspection reports the `@NotNull` annotations only, other constraints are ignored
3. actually, Hibernate Validator doesn't require the properties to be mutable. Turning `val` to `var` doesn't guarantee that the property will be validated.
The annotation should be used for field, not for parameter. Thus, 
`val` annotated with `@field:NotNull` is not a problem. But,
`var` constructor parameter annotated with `@NotNull` is.
`val` field annotated with `@NotNull` is not a problem. But,
`var` constructor parameter annotated with `@param:NotNull` is.
Also, the inspection doesn't report the errors when the type of the `var` property is annotated with some constraint instead of the field itself.
4. One more problem is that the J2K convertor puts the annotation on the field types instead of the properties.


You can use the tests or test the controller methods with the collection of HTTP requests in the `http-request.http` file to check how the constraints really work.


== by Irina on 7/14/2025
   
 