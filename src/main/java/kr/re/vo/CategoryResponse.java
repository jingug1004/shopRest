package kr.re.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by user on 2017-04-07 오후 2:23
 * Prac / PACKAGE_NAME
 * No pain, No gain!
 * What :
 * Why :
 * How : 상품 - 로그인시 해당 API 사용 GET /api/v1/product/category
 */

@Data
public class CategoryResponse {

    private List<Brand> brandList;
    private List<CategoryLvResult> categoryList;
    //    private String message;
    private String resultCode;
    private String timestamp;

    private String status;     // HttpStatus
    private String message;     // Http Default Message
    private String errorMessage;     // Error Message to USER
    private String errorCode;     // Error Code

    public CategoryResponse() {

    }

    public CategoryResponse(String status, String message, String errorCode, String errorMessage) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
