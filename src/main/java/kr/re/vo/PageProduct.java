package kr.re.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageProduct {

    private List<ProductDetail> content; // (Array[Plan], optional),
    private boolean first; // (boolean, optional),
    private boolean last; // (boolean, optional),
    private int number; // (integer, optional),
    private int numberOfElements; // (integer, optional),
    private int size; // (integer, optional),
    //	private Sort sort; // (Sort, optional),
    private int totalElements; // (integer, optional),
    private int totalPages; // (integer, optional)

    private String status;     // HttpStatus
    private String message;     // Http Default Message
    private String errorMessage;     // Error Message to USER
    private String errorCode;     // Error Code

    public PageProduct() {

    }

    public PageProduct(String status, String message, String errorCode, String errorMessage) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
