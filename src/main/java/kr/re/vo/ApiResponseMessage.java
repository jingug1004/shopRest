package kr.re.vo;

import lombok.Data;

/**
 * Created by A on 2018-12-08 오후 8:40
 * re / kr.re.controller
 * No pain, No gain!
 * What :
 * Why :
 * How :
 * << 개정이력(Modification Information) >>
 * 수정일         수정자          수정내용
 * -------       --------       ---------------------------
 * 2018/04/01     김진국          최초 생성
 * 2017/05/27     이몽룡          인증이 필요없는 URL을 패스하는 로직 추가
 *
 * @author 개발팀 김진국
 * @version 1.0
 * @see
 * @since 2018/04/01
 */

@Data
public class ApiResponseMessage {

    private String status;     // HttpStatus

    private String message;     // Http Default Message

    private String errorMessage;     // Error Message to USER

    private String errorCode;     // Error Code

    public ApiResponseMessage(String status, String message, String errorCode, String errorMessage) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }


}