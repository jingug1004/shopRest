package kr.re.vo;

import lombok.Data;

@Data
public class ProductDetail {

    private Product product;
    private String id;
    private Category category;

    private String status;     // HttpStatus
    private String message;     // Http Default Message
    private String errorMessage;     // Error Message to USER
    private String errorCode;     // Error Code

    public ProductDetail() {

    }

    public ProductDetail(String status, String message, String errorCode, String errorMessage) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
