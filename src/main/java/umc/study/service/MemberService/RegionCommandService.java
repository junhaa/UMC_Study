package umc.study.service.MemberService;

import umc.study.domain.Store;
import umc.study.web.dto.RegionRequestDTO;

public interface RegionCommandService {
    public Store addStore(RegionRequestDTO.JoinStoreDTO request, Long regionId);
}
