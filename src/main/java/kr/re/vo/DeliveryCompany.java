package kr.re.vo;

import lombok.Data;

/**
 * Created by user on 2017-04-07 오후 3:23
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 상품 - 로그인시 해당 API 사용 GET /api/v1/product/detail   GET /api/v1/product/list/{page}   GET /api/v1/product/list/{parent}/{page}
 * 위시리스트 - 로그인 필요 POST /api/v1/wish/add   GET /api/v1/wish/check   DELETE /api/v1/wish/delete   GET /api/v1/wish/list
 * 쿠폰 - 로그인 필요 POST /api/v1/coupon/my   POST /api/v1/coupon/my_coupon   PUT /api/v1/coupon/use
 */

@Data
public class DeliveryCompany {

    private String code;
    private String name;

    private String status;     // HttpStatus
    private String message;     // Http Default Message
    private String errorMessage;     // Error Message to USER
    private String errorCode;     // Error Code

    public DeliveryCompany() {

    }

    public DeliveryCompany(String status, String message, String errorCode, String errorMessage) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
