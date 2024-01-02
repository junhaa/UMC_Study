package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isOnChallengeMission(Long memberId, Long missionId) {
        MemberMission memberMission = memberMissionRepository.findByMemberIdAndMissionId(memberId, missionId).orElse(null);
        if(memberMission != null) return true;
        return false;
    }
}
