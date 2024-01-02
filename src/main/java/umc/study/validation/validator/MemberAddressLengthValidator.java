package umc.study.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.validation.annotation.MemberAddressLengthConstraint;

import static umc.study.util.ApplicationConstants.ADDRESS_MAX_LENGTH;


@Component
@RequiredArgsConstructor
public class MemberAddressLengthValidator implements ConstraintValidator<MemberAddressLengthConstraint, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValid = (value.length() <= ADDRESS_MAX_LENGTH && value.length() >= ADDRESS_MAX_LENGTH);
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.ADDRESS_LENGTH_NOT_VALID.toString()).addConstraintViolation();
        }
        return isValid;
    }

    @Override
    public void initialize(MemberAddressLengthConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
