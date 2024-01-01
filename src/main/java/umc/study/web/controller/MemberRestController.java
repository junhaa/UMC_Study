package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberConverter;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinMemberResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinMemberDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/missions")
    public ApiResponse<MemberResponseDTO.AddMissionChallengeResultDTO> onChallengeMission(@RequestBody @Valid MemberRequestDTO.AddMissionChallengeDTO request){
        MemberMission memberMission = memberCommandService.addMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toAddMissionChallengeResultDTO(memberMission));
    }
}
