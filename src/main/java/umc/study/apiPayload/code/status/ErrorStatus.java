package umc.study.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.code.ErrorReasonDTO;

import static umc.study.util.ApplicationConstants.ADDRESS_MAX_LENGTH;
import static umc.study.util.ApplicationConstants.ADDRESS_MIN_LENGTH;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {



    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),


    // 멤버 관려 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

    // 음식 카테고리 에러
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST, "FOODCATEGORY4001", "음식 카테고리가 없습니다."),

    // 주소 에러
    ADDRESS_LENGTH_NOT_VALID(HttpStatus.BAD_REQUEST, "ADDRESS4001", "주소의 길이가 " + ADDRESS_MIN_LENGTH + "에서 " + ADDRESS_MAX_LENGTH + "사이여야 합니다."),
    NAME_NOT_BLANK(HttpStatus.BAD_REQUEST, "NAME4001", "이름은 공백일 수 없습니다."),

    // 점수 에러
    SCORE_NOT_VALID(HttpStatus.BAD_REQUEST, "SCORE4001", "올바른 형태의 점수가 입력되지 않았습니다. 다시 확인해 주세요."),

    // 지역 관련 에러
    REGION_NOT_EXIST(HttpStatus.BAD_REQUEST, "REGION4001", "지역이 존재하지 않습니다."),


    // 가게 관련 에러
    STORE_NOT_EXIST(HttpStatus.BAD_REQUEST, "STORE4001", "가게가 존재하지 않습니다."),

    // 미션 관련 에러
    MISSION_NOT_EXIST(HttpStatus.BAD_REQUEST, "MISSION4001", "미션이 존재하지 않습니다."),
    MEMBER_MISSION_NOT_EXIST(HttpStatus.BAD_REQUEST, "MISSION4002", "멤버의 미션이 존재하지 않습니다."),
    MEMBER_MISSION_EXIST(HttpStatus.BAD_REQUEST, "MISSION4003", "이미 진행중이거나, 완료한 미션입니다."),

    // 예시,,,
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}