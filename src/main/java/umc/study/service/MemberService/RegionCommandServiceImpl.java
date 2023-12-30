package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.RegionHandler;
import umc.study.converter.StoreConvertor;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.RegionRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.RegionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionCommandServiceImpl implements RegionCommandService{
    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Store addStore(RegionRequestDTO.JoinStoreDTO request, Long regionId) {
        Store newStore = StoreConvertor.toStore(request);
        Region curRegion = regionRepository.findById(regionId).orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_EXIST));
        newStore.setRegion(curRegion);
        return storeRepository.save(newStore);
    }
}
