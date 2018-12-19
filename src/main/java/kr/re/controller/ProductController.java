package kr.re.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.re.service.ProductService;
import kr.re.vo.BestResponse;
import kr.re.vo.CategoryResponse;
import kr.re.vo.CategoryResponse2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;


@RestController
@Api(value = "ProductController", description = "상품")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Inject
    private ProductService productService;

    @RequestMapping(value = "/bestResponseGET", method = RequestMethod.GET)
    @ApiOperation(value = "리스트", notes = "상품 리스트를 보여준다(배너, 상품).")
    public BestResponse bestResponseGET() throws Exception {
        BestResponse bestResponse = new BestResponse();
        bestResponse = productService.bestResponseGET();
        return bestResponse;
    }

    @RequestMapping(value = "/categoryResponseGET", method = RequestMethod.GET)
    @ApiOperation(value = "카테고리", notes = "카테고리 리스트를 보여준다(배너, 상품).")
    public CategoryResponse categoryResponseGET() throws Exception {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse = productService.categoryResponseGET();
        return categoryResponse;
    }

    @RequestMapping(value = "/categoryListSec", method = RequestMethod.GET)
    @ApiOperation(value = "카테고리2", notes = "카테고리2 리스트를 보여준다(배너, 상품).")
    public CategoryResponse2 categoryResponseSec() throws Exception {
        CategoryResponse2 categoryResponse = new CategoryResponse2();
//        categoryResponse = productService.bestResponseGET();
        return categoryResponse;
    }

}