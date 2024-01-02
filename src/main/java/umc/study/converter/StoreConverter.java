package umc.study.converter;

import umc.study.domain.Store;
import umc.study.web.dto.RegionRequestDTO;
import umc.study.web.dto.RegionResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static Store toStore(RegionRequestDTO.JoinStoreDTO joinStoreDTO){
        return Store.builder()
                .address(joinStoreDTO.getAddress())
                .name(joinStoreDTO.getName())
                .score(joinStoreDTO.getScore())
                .build();
    }

    public static RegionResponseDTO.JoinStoreResultDTO toJoinStoreResultDTO(Store store){
        return RegionResponseDTO.JoinStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
