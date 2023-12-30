package umc.study.service.MemberService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.repository.FoodCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodCategoryValidationServiceImpl implements FoodCategoryValidationService{

    public final FoodCategoryRepository foodCategoryRepository;

    @Override
    public boolean allCategoriesExistById(List<Long> values){
        return values.stream().allMatch(value -> foodCategoryRepository.existsById(value));
    }
}
