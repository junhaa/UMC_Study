package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import static umc.study.util.ApplicationConstants.REVIEW_TITLE_MAX_LENGTH;

public class StoreRequestDTO {

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
}
