package umc.study.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.validation.annotation.ValidLength;


@Component
@RequiredArgsConstructor
public class StringLengthValidator implements ConstraintValidator<ValidLength, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValid = (value.length() <= 12 && value.length() >= 5);
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STRING_LENGTH_NOT_VALID.toString()).addConstraintViolation();
        }
        return isValid;
    }

    @Override
    public void initialize(ValidLength constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
