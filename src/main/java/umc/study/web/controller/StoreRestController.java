package umc.study.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConvertor;
import umc.study.domain.Review;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/review")
    public ApiResponse<StoreResponseDTO.AddReviewResultDTO> addReview(@RequestBody @Valid StoreRequestDTO.AddReviewDTO request, @PathVariable Long storeId){
        Review review = storeCommandService.addReview(request, storeId);
        return ApiResponse.onSuccess(ReviewConvertor.toAddReviewResultDTO(review));
    }
}
