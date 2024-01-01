package umc.study.service.MemberService;

import umc.study.domain.Member;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDTO.JoinMemberDto request);
    public MemberMission addMemberMission(MemberRequestDTO.AddMissionChallengeDTO request);
}
