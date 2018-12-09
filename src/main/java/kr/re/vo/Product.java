package kr.re.vo;

import lombok.Data;

/**
 * Created by user on 2017-04-07 오후 2:54
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 상품 - 로그인시 해당 API 사용 GET /api/v1/product/detail   GET /api/v1/product/list/{page}   GET /api/v1/product/list/{parent}/{page}
 * 위시리스트 - 로그인 필요 POST /api/v1/wish/add   GET /api/v1/wish/check   DELETE /api/v1/wish/delete   GET /api/v1/wish/list
 * 쿠폰 - 로그인 필요 POST /api/v1/coupon/my   POST /api/v1/coupon/my_coupon   PUT /api/v1/coupon/use
 */

@Data
public class Product {

    private String banner;
    private Integer box;
    private Brand brand; /* 브랜드 */
    private String content;
    private String detailUrl;
    private Integer price;
    private String prodDesc;
    private String prodName;
    private ProductDelivery productDelivery; /* 상품 배송 정보 */
    private long productId;
    private String regDate;
    private Integer reviewCount;
    private Number reviewStar;
    private Integer sale;
    private Integer salePrice;
    private Integer score;
    private User seller; /* 판매자 */
    private Integer star1;
    private Integer star2;
    private Integer star3;
    private Integer star4;
    private Integer star5;
    private Integer stopSelling;
    private String thumbUrl;
    private Integer timeSale;
    private Integer viewCount;
    private Integer autoSale;
    private Integer brandId;
    private Integer deliveryId;

    private String status;     // HttpStatus
    private String message;     // Http Default Message
    private String errorMessage;     // Error Message to USER
    private String errorCode;     // Error Code

    public Product() {

    }

    public Product(String status, String message, String errorCode, String errorMessage) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}