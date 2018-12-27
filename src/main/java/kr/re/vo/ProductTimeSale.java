package kr.re.vo;

import lombok.Data;

/**
 * Created by user on 2017-04-07 오후 3:57
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 상품 - 로그인시 해당 API 사용 GET /api/v1/product/detail
 */

@Data
public class ProductTimeSale {

    private String endDate;
    private Integer prodCount;
    private Product product;
    private String regDate;
    private Integer rnCount;
    private Integer saleId;
    private Integer timeType;

    private String status;     // HttpStatus
    private String message;     // Http Default Message
    private String errorMessage;     // Error Message to USER
    private String errorCode;     // Error Code

    public ProductTimeSale() {

    }

    public ProductTimeSale(String status, String message, String errorCode, String errorMessage) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
