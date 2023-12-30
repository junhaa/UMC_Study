package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.validation.annotation.FoodExistCategories;
import java.util.*;

import static umc.study.util.ApplicationConstants.ADDRESS_MAX_LENGTH;
import static umc.study.util.ApplicationConstants.ADDRESS_MIN_LENGTH;

public class MemberRequestDTO {

    @Getter
    public static class JoinMemberDto {
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min = ADDRESS_MIN_LENGTH, max = ADDRESS_MAX_LENGTH)
        String address;
        @Size(min = ADDRESS_MIN_LENGTH, max = ADDRESS_MAX_LENGTH)
        String specAddress;
        @FoodExistCategories
        List<Long> preferCategory;
    }
}