package umc.study.converter;

import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;

public class MemberMissionConverter {

    public static MemberMission toMemberMission(MemberRequestDTO.AddMissionChallengeDTO request){
        return MemberMission.builder().build();
    }

    public static MemberResponseDTO.AddMissionChallengeResultDTO toAddMissionChallengeResultDTO(MemberMission memberMission){
       return MemberResponseDTO.AddMissionChallengeResultDTO.builder()
               .memberMissionId(memberMission.getId())
               .memberId(memberMission.getMember().getId())
               .build();
    }
}
