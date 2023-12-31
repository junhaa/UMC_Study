package umc.study.converter;

import umc.study.domain.Review;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReviewConvertor {

    public static Review toReview(StoreRequestDTO.AddReviewDTO request){
        return Review.builder()
                .score(request.getScore())
                .title(request.getTitle())
                .reviewImageList(new ArrayList<>())
                .build();
    }

    public static StoreResponseDTO.AddReviewResultDTO toAddReviewResultDTO(Review review){
        return StoreResponseDTO.AddReviewResultDTO.builder()
                .reviewId(review.getId())
                .createAt(LocalDateTime.now())
                .build();
    }

}
