package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.service.StoreService.StoreValidationService;
import umc.study.validation.annotation.ExistStore;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStore, Long> {
    private final StoreValidationService storeValidationService;
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = storeValidationService.StoreExistById(value);
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_EXIST.toString()).addConstraintViolation();
        }
        return isValid;
    }

    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
