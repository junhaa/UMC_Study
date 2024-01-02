package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.MemberAddressLengthValidator;

import java.lang.annotation.*;

import static umc.study.util.ApplicationConstants.ADDRESS_MAX_LENGTH;
import static umc.study.util.ApplicationConstants.ADDRESS_MIN_LENGTH;

@Documented
@Constraint(validatedBy = MemberAddressLengthValidator.class)
@Target({ ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MemberAddressLengthConstraint {
    String message() default "주소의 길이가 " + ADDRESS_MIN_LENGTH + "에서 " + ADDRESS_MAX_LENGTH + " 사이여야 합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
