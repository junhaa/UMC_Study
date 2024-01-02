package umc.study.service.MemberService;

import java.util.List;

public interface FoodCategoryValidationService {
    public boolean allCategoriesExistById(List<Long> values);
}
