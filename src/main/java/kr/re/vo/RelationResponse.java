package kr.re.vo;

import lombok.Data;

import java.util.List;

@Data
public class RelationResponse {

    private List<Product> brandList; // (Array[Product], optional): 브랜드 상품 ,
    private List<Product> categoryProduct; // (Array[Product], optional): 카테고리 상품 ,
    //    private String message; // (string, optional): 성공시 success 실패시 실패 내용 확인 ,
    private List<Product> productList; // (Array[Product], optional): 인기 상품 ,
    private String resultCode; // (string, optional): 200 성공 99 업데이트 필요 = ['200', '99', '10'],
    private String timestamp; // (string, optional),
    private List<Product> userProduct; // (Array[Product], optional): 구매한 상품

    private String status;     // HttpStatus
    private String message;     // Http Default Message
    private String errorMessage;     // Error Message to USER
    private String errorCode;     // Error Code

    public RelationResponse() {

    }

    public RelationResponse(String status, String message, String errorCode, String errorMessage) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
