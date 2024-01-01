package umc.Service;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import umc.study.service.MemberService.MemberQueryService;

@SpringBootTest
@Transactional
public class MemberQueryServiceTest {

    @Autowired
    private MemberQueryService memberQueryService;

    @Test
    public void challengeCheckTest(){
        Long memberId = 1L;
        Long missionId = 1L;

        boolean onChallengeMission = memberQueryService.isOnChallengeMission(memberId, missionId);

        Assertions.assertThat(onChallengeMission).isFalse();
    }


}
