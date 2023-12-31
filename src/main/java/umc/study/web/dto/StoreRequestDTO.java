package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;

import static umc.study.util.ApplicationConstants.MISSION_MAX_LENGTH;
import static umc.study.util.ApplicationConstants.REVIEW_TITLE_MAX_LENGTH;

public class StoreRequestDTO {

    // 리뷰 추가 DTO
    @Getter
    public static class AddReviewDTO {

        @NotNull
        private Long memberId;

        @Size(max = REVIEW_TITLE_MAX_LENGTH)
        @NotBlank
        private String title;

        @NotNull
        private Float score;
    }


    // 미션 추가 DTO
    @Getter
    public static class AddMissionDTO{
        @NotNull
        private Integer reward;

        @NotNull
        private LocalDate deadline;

        @Size(max = MISSION_MAX_LENGTH)
        @NotBlank
        @NotNull
        private String missionSpec;
    }
}
