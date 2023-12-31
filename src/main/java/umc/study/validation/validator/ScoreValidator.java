package umc.study.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.validation.annotation.ScoreSize;

import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class ScoreValidator implements ConstraintValidator<ScoreSize, Float> {

    // 0 ~ 5 사이의 .0 혹은 .5의 소수점 자리
    @Override
    public boolean isValid(Float value, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile("^(?:[0-4]\\.([05])|5\\.0)$");
        boolean isValid = pattern.matcher(String.valueOf(value)).matches();
        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.SCORE_NOT_VALID.toString()).addConstraintViolation();
        }
        return isValid;
    }

    @Override
    public void initialize(ScoreSize constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
