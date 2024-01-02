package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.validation.annotation.ExistFoodCategories;
import umc.study.validation.annotation.NotChallenging;

import java.util.List;

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

        private List<Mission> missionList;
    }


    @NotChallenging
    @Getter
    public static class AddMissionChallengeDTO{
        @NotNull
        private Long missionId;

        @NotNull
        private Long memberId;

        private MissionStatus missionStatus = MissionStatus.CHALLENGING;
    }

}