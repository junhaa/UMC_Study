package umc.study.apiPayload.exception.handler;

import org.apache.coyote.ErrorState;
import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(ErrorStatus errorState) {
        super(errorState);
    }
}
