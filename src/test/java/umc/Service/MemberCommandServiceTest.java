package umc.Service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.web.dto.MemberRequestDTO;

@SpringBootTest
public class MemberCommandServiceTest {

    @Autowired
    private MemberCommandService memberCommandService;

    @Test
    public void addMemberMissionTest(){
        Long memberId = 1L;
        Long missionId = 1L;


        MemberRequestDTO.AddMissionChallengeDTO addMissionChallengeDTO = new MemberRequestDTO.AddMissionChallengeDTO();
        addMissionChallengeDTO.setMemberId(memberId);
        addMissionChallengeDTO.setMissionId(missionId);
        MemberMission res = memberCommandService.addMemberMission(addMissionChallengeDTO);
        Assertions.assertThat(res).isNotNull();
    }
}
