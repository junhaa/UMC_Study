package umc.study.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.StoreConverter;
import umc.study.domain.Store;
import umc.study.service.RegionService.RegionCommandService;
import umc.study.web.dto.RegionRequestDTO;
import umc.study.web.dto.RegionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions")
public class RegionRestController {
    private final RegionCommandService regionCommandService;
    @PostMapping("/{regionId}/store")
    public ApiResponse<RegionResponseDTO.JoinStoreResultDTO>
        addStore(@RequestBody @Valid RegionRequestDTO.JoinStoreDTO request, @PathVariable Long regionId) {
        Store store = regionCommandService.addStore(request, regionId);
        return ApiResponse.onSuccess(StoreConverter.toJoinStoreResultDTO(store));
    }

}
