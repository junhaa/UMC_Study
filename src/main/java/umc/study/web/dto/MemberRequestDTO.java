package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.validation.annotation.ExistFoodCategories;
import java.util.*;

import static umc.study.util.ApplicationConstants.ADDRESS_MAX_LENGTH;
import static umc.study.util.ApplicationConstants.ADDRESS_MIN_LENGTH;

public class MemberRequestDTO {

    @Getter
    public static class JoinMemberDto {
        @NotBlank
        private String name;
        @NotNull
        private Integer gender;
        @NotNull
        private Integer birthYear;
        @NotNull
        private Integer birthMonth;
        @NotNull
        private Integer birthDay;
        @Size(min = ADDRESS_MIN_LENGTH, max = ADDRESS_MAX_LENGTH)
        private String address;
        @Size(min = ADDRESS_MIN_LENGTH, max = ADDRESS_MAX_LENGTH)
        private String specAddress;
        @ExistFoodCategories
        private List<Long> preferCategory;
    }
}