package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.validation.annotation.NameNotBlank;

@Component
@RequiredArgsConstructor
public class NameBlankValidator implements ConstraintValidator<NameNotBlank, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValid = !value.isBlank();
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.NAME_NOT_BLANK.toString()).addConstraintViolation();
        }
        return isValid;
    }

    @Override
    public void initialize(NameNotBlank constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
