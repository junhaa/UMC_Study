package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import static umc.study.util.ApplicationConstants.ADDRESS_MAX_LENGTH;
import static umc.study.util.ApplicationConstants.ADDRESS_MIN_LENGTH;

public class RegionRequestDTO {

    @Getter
    public static class JoinStoreDTO{
        @NotBlank
        private String name;

        @NotBlank
        @Size(min = ADDRESS_MIN_LENGTH, max = ADDRESS_MAX_LENGTH)
        private String address;

        private float score = 0.0f;
    }
}
