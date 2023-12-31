package umc.study.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.validation.annotation.ExistStore;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/review")
    public ApiResponse<StoreResponseDTO.AddReviewResultDTO> addReview(@RequestBody @Valid StoreRequestDTO.AddReviewDTO request, @PathVariable @ExistStore Long storeId){
        Review review = storeCommandService.addReview(request, storeId);
        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResultDTO(review));
    }

    @PostMapping("/{storeId}/mission")
    public ApiResponse<StoreResponseDTO.AddMissionResultDTO> addMission(@RequestBody @Valid StoreRequestDTO.AddMissionDTO request, @PathVariable @ExistStore Long storeId){
        Mission mission = storeCommandService.addMission(request, storeId);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionResultDTO(mission));
    }
}
