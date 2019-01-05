package kr.re.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.re.service.ProductService;
import kr.re.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@RestController
@Api(value = "ProductController", description = "상품")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Inject
    private ProductService productService;

    @RequestMapping(value = "/product/best", method = RequestMethod.GET)
    @ApiOperation(value = "상품 리스트 조회", notes = "상품 리스트를 보여준다(배너, 상품).")
    public BestResponse bestResponseGET() throws Exception {
        BestResponse bestResponse = new BestResponse();
        bestResponse = productService.bestResponseGET();
        return bestResponse;
    }

    @RequestMapping(value = "/product/category", method = RequestMethod.GET)
    @ApiOperation(value = "상품 카테고리 조회", notes = "카테고리 리스트를 보여준다(배너, 상품).")
    public CategoryResponse categoryResponseGET() throws Exception {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse = productService.categoryResponseGET();
        return categoryResponse;
    }

    @RequestMapping(value = "/product/category2", method = RequestMethod.GET)
    @ApiOperation(value = "상품 카테고리2", notes = "카테고리2 리스트를 보여준다(배너, 상품).")
    public CategoryResponse2 categoryResponseSec() throws Exception {
        CategoryResponse2 categoryResponse = new CategoryResponse2();
        return categoryResponse;
    }

    @RequestMapping(value = "/product/detail", method = RequestMethod.GET)
    @ApiOperation(value = "상품 상세 페이지 조회", notes = "상품 상세 내역을 가져온다.")
    public ProductResponse productResponseGET(@RequestParam int productId) throws Exception {
        ProductResponse productResponse = new ProductResponse();
        productResponse = productService.productResponseGET(productId);
        return productResponse;
    }

    @RequestMapping(value = "/product/list/{page}", method = RequestMethod.GET)
    @ApiOperation(value = "브랜드 등록 상품들 조회 - 카테고리", notes = "한 브랜드의 상품들을 1페이지(10개씩) 가져온다.")
    public PageBrand brandListGET(@PathVariable int page,
                                  @RequestParam int brandId,
                                  @RequestParam(required = false) Integer sort) throws Exception {
        PageBrand pageBrand = new PageBrand();
        pageBrand = productService.brandListGET(page, brandId, sort);

        return pageBrand;
    }

    @RequestMapping(value = "/product/search", method = RequestMethod.GET)
    @ApiOperation(value = "브랜드 등록 상품들 검색", notes = "등록된 상품들을 검색해서 가져온다(2글자 이상, 빈값 X, where 상품명, 상품 설명).")
    public List<Product> productSearchGET(@RequestParam String searchName) throws Exception {
        List<Product> products = new ArrayList<>();
        products = productService.productSearchGET(searchName);
        System.out.println("lll~~~ : " + products);
        return products;
    }

}