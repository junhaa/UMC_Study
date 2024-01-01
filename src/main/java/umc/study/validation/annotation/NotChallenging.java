package umc.study.validation.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.MissionChallengeValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionChallengeValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotChallenging {
    String message() default "현재 진행중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
