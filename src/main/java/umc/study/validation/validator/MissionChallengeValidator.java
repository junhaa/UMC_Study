package umc.study.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.service.MemberService.MemberQueryService;
import umc.study.validation.annotation.NotChallenging;
import umc.study.web.dto.MemberRequestDTO;

@Slf4j
@Component
@RequiredArgsConstructor
public class MissionChallengeValidator implements ConstraintValidator<NotChallenging, MemberRequestDTO.AddMissionChallengeDTO> {

    private final MemberQueryService memberQueryService;

    private static final Logger logger = LoggerFactory.getLogger(MissionChallengeValidator.class);
    @Override
    public boolean isValid(MemberRequestDTO.AddMissionChallengeDTO value, ConstraintValidatorContext context) {
        boolean isValid = !(memberQueryService.isOnChallengeMission(value.getMemberId(), value.getMissionId()));
        logger.info("isValid = {}", isValid);
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_MISSION_EXIST.toString()).addConstraintViolation();
        }

        return isValid;
    }

    @Override
    public void initialize(NotChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
