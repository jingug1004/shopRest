package kr.re.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.re.service.ApiService;
import kr.re.service.ProductService;
import kr.re.vo.ApiResponseMessage;
import kr.re.vo.BestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;


@RestController
@Api(value = "ProductController", description = "상품 컨트롤러")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Inject
    private ApiService apiService;

    @Inject
    private ProductService productService;

    @RequestMapping(value = "/hapiTest02", method = RequestMethod.GET)
    @ApiOperation(value = "hapiTest02", notes = "hello, World를 반환하는 API, Ajax 통신 확인용.")
    public ResponseEntity<ApiResponseMessage> hapiTest02() {
        ApiResponseMessage message = new ApiResponseMessage("Success", "Hello, World!!!", "", "");

        return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
    }

//    @RequestMapping(value = "/bestResponseGET", method = RequestMethod.GET)
//    @ApiOperation(value = "bestResponseGET", notes = "hello, World를 반환하는 API, Ajax 통신 확인용.")
//    public ResponseEntity<BestResponse> bestResponseGET() {
//        BestResponse message = new BestResponse("Success", "Hello, World!!!", "", "");
//
//        return new ResponseEntity<BestResponse>(message, HttpStatus.OK);
//    }

    @RequestMapping(value = "/bestResponseGET", method = RequestMethod.GET)
    @ApiOperation(value = "bestResponseGET", notes = "hello, World를 반환하는 API, Ajax 통신 확인용.")
    public BestResponse bestResponseGET() throws Exception {
        BestResponse bestResponse = new BestResponse();
        bestResponse = productService.bestResponseGET();
        return bestResponse;
    }


//    @Autowired
//    private WishService wishService;
//
//    @Autowired
//    private MainService mainService;
//
//    @Autowired
//    private ReviewService reviewService;
//
//    @Autowired
//    private SearchService searchService;
//
//    @RequestMapping(value = "/product", method = RequestMethod.GET)
//    public String productGET () {
//
//        return "/product/product";
//
//    }
//
//    /* 찜 버튼(하트모양) 때문에 코드 추가함 // 2017-05-31 minho */
//    @RequestMapping(value = "/bestProduct", method = RequestMethod.GET)
//    public String bestProductGET (Model model, HttpSession session) throws Exception {
//
//    	String menuCheck = "2";
//    	/* 추가부분 시작 */
//    	LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
//    	if (login != null) {
//    		model.addAttribute("Wish", wishService.wishList2(login.getToken()));
//    		model.addAttribute("menuCheck", menuCheck);
//    	}
//    	/* 추가부분 종료 */
//
//        model.addAttribute("showBestProduct", service.bestResponseGET());
//        model.addAttribute("menuCheck", menuCheck);
//
//        return "/product/bestProduct";
//
//    }
//
//
//    @RequestMapping(value = "/categoryProduct", method = RequestMethod.GET)
//    public void categoryProductGET (Model model) {
//
//        /*model.addAttribute("showCategoryProduct", service.boxGET());*/
//
////        return "/product/categoryProduct";
//    }
//
//
//    @RequestMapping(value = "/detail", method = RequestMethod.GET)
//    public String detailProductGET (@RequestParam("product_id") long product_id,
//                                  Model model, HttpSession session,
//                                  @RequestParam(required=false, defaultValue="1") String sort,
//                                  @RequestParam(required=false, defaultValue="0") String isDev) throws Exception {
//
//
//    	/* 추가부분 시작 */
//    	LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
//    	if (login != null) {
//    		model.addAttribute("Wish", wishService.wishList2(login.getToken()));
//    	}
//
//    	model.addAttribute("iamport", BalgreConstants.IAMPORT_CODE);
//    	/* 추가부분 종료 */
//        ProductResponse res = service.productDetailGET(product_id);
//        List<ProductItem> pi2 = res.getProductItem();
//        ProductItem pi = pi2.get(0);
//
//        int page = 0;
//        int photo = 0;
//        PageReview rev = reviewService.reviewList2(page, product_id, photo, Integer.parseInt(sort));
//
//        RelationResponse res2 = service.relationProduct(product_id);
//
//        long parent = 0L;
//        long menu_id = 104L;
//
//		PageProduct pp = service.categoryList2(parent, page, menu_id, Integer.parseInt(sort));
//
//		model.addAttribute("categor", pp);
//		model.addAttribute("menu_id", menu_id);
//
//        model.addAttribute("choiceDetailProduct", res);
//        model.addAttribute("pi", pi);
//        model.addAttribute("popularI", res2.getProductList());
//        model.addAttribute("cate", res2.getCategoryProduct());
//        model.addAttribute("brand2", res2.getBrandList());
//        model.addAttribute("review", rev);
//        model.addAttribute("isDev", isDev);
//        model.addAttribute("np_order", BalgreConstants.NAVER_PAY_ORDER);
//
//        String deviceType = (String) session.getAttribute("deviceType");
//        if(deviceType.equals("mobile")) {
//        	return "/product/m_productDetail";
//        }
//        return "/product/productDetail";
//
//    }
//
//    /*time sale list by minho*/
//    @RequestMapping(value = "/bg/timeSale", method = RequestMethod.GET)
//    public String timeSaleList(Model model, HttpSession session) {
//
//    	String menuCheck = "1";
//
//    	System.out.println(menuCheck);
//    	LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
//    	if (login != null) {
//    		model.addAttribute("Wish", wishService.wishList2(login.getToken()));
//    		model.addAttribute("menuCheck", menuCheck);
//    	}
//
//
//
//    	model.addAttribute("Res", service.timeSaleList2());
//    	model.addAttribute("menuCheck", menuCheck);
//
//    	return "/timeSale/timeSale";
//    }
//
//
//    /*balgeure box by minho*/
//    @RequestMapping(value = "/bg/box", method = RequestMethod.GET)
//    public String balgeureBox(Model model, HttpSession session) {
//
//    	LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
//    	if (login != null) {
//    		model.addAttribute("Wish", wishService.wishList2(login.getToken()));
//    	}
//
//    	model.addAttribute("Res", service.balgeureBox2());
//
//    	return "/product/balgeureBox";
//    }
//
//
//    /*new product by minho*/
//    @RequestMapping(value = "/bg/new", method = RequestMethod.GET)
//    public String newProduct(Model model, HttpSession session) {
//
//    	String menuCheck = "4";
//
//    	LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
//    	if (login != null) {
//    		model.addAttribute("Wish", wishService.wishList2(login.getToken()));
//    		model.addAttribute("menuCheck", menuCheck);
//    	}
//
//    	BestResponse res = service.newProduct2();
//
//    	model.addAttribute("best", res);
//    	model.addAttribute("menuCheck", menuCheck);
//    	//model.addAttribute("Res", res.getProductList());
//
//    	return "/product/new";
//    }
//
//    /*brand all by minho*/
//    @RequestMapping(value = "/brandAll", method = RequestMethod.GET)
//    public String brandAll(Model model, HttpSession session, @RequestParam(value = "search", required = false)String search) {
//
//    	LoginDTO02 login = (LoginDTO02)session.getAttribute("login");
//    	if (login != null) {
//    		model.addAttribute("Wish", wishService.wishList2(login.getToken()));
//    	}
//
//
//    	model.addAttribute("brandAll", searchService.search2(search));
//
//    	return "/product/brand";
//    }

}