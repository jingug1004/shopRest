package kr.re.vo;

import lombok.Data;

@Data
public class ProductCategory {
    private Category category;

    private String status;     // HttpStatus
    private String message;     // Http Default Message
    private String errorMessage;     // Error Message to USER
    private String errorCode;     // Error Code

    public ProductCategory() {

    }

    public ProductCategory(String status, String message, String errorCode, String errorMessage) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
