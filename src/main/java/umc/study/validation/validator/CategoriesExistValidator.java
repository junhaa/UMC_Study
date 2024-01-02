package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.service.MemberService.FoodCategoryValidationService;
import umc.study.validation.annotation.ExistFoodCategories;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistFoodCategories, List<Long>> {

    public final FoodCategoryValidationService foodCategoryValidationService;
    @Override
    public void initialize(ExistFoodCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = foodCategoryValidationService.allCategoriesExistById(values);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}