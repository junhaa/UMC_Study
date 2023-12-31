package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static StoreResponseDTO.AddMissionResultDTO toAddMissionResultDTO(Mission mission){
        return StoreResponseDTO.AddMissionResultDTO.builder()
                .missionId(mission.getId())
                .createAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(StoreRequestDTO.AddMissionDTO request){
        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .build();
    }
}
