package kr.re.vo;

import lombok.Data;

import java.util.List;

@Data
public class BestResponse {

    private List<MainFirstBanner> firstBanner; // (Array[MainFirstBanner], optional): 상단 배너 ,
    //	private String message; // (string, optional): 성공시 success 실패시 실패 내용 확인 ,
    private List<Product> productList; // (Array[Product], optional): 신규 또는 베스트 상품 ,

//	private String resultCode; // (string, optional): 200 성공 99 업데이트 필요 = ['200', '99'],
//	private String timestamp; // (string, optional)

    private String status;     // HttpStatus
    private String message;     // Http Default Message
    private String errorMessage;     // Error Message to USER
    private String errorCode;     // Error Code

    public BestResponse() {

    }

    public BestResponse(String status, String message, String errorCode, String errorMessage) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
