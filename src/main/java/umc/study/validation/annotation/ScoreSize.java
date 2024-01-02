package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.ScoreValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ScoreValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ScoreSize {
    String message() default "올바른 형태의 점수가 입력되지 않았습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
