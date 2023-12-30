package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.StringLengthValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StringLengthValidator.class)
@Target({ ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidLength {
    String message() default "크키가 5에서 12 사이여야 합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
