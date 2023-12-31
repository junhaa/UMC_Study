package umc.study.service.StoreService;

import umc.study.domain.Review;
import umc.study.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    public Review addReview(StoreRequestDTO.AddReviewDTO request, Long storeId);
}
