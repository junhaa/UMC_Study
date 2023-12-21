package umc.study.converter;

import umc.study.domain.FoodCategory;
import umc.study.domain.mapping.MemberPrefer;

import java.util.stream.Collectors;
import java.util.*;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}

