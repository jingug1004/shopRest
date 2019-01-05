package kr.re.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageBrand {

    private List<Product> content; // (Array[Plan], optional),
    private boolean first; // (boolean, optional),
    private boolean last; // (boolean, optional),
    private int number; // (integer, optional),
    private int numberOfElements; // (integer, optional),
    private int size; // (integer, optional),
    //	private Sort sort; // (Sort, optional),
    private int totalElements; // (integer, optional), 총 카운트 35개
    private int totalPages; // (integer, optional) 총 4페이지

    private String status;     // HttpStatus
    private String message;     // Http Default Message
    private String errorMessage;     // Error Message to USER
    private String errorCode;     // Error Code

    public PageBrand() {

    }

    public PageBrand(String status, String message, String errorCode, String errorMessage) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
