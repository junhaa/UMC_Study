package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MemberHandler;
import umc.study.apiPayload.exception.handler.StoreHandler;
import umc.study.converter.MissionConverter;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService{

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Review addReview(StoreRequestDTO.AddReviewDTO request, Long storeId) {
        Review newReview = ReviewConverter.toReview(request);

        Store store = storeRepository.findById(storeId).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_EXIST));
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        newReview.setStore(store);
        newReview.setMember(member);
        return reviewRepository.save(newReview);
    }


    @Override
    @Transactional
    public Mission addMission(StoreRequestDTO.AddMissionDTO request, Long storeId){
        Mission newMission = MissionConverter.toMission(request);

        Store store = storeRepository.findById(storeId).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_EXIST));
        newMission.setStore(store);

        return missionRepository.save(newMission);
    }
}

