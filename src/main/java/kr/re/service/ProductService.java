package kr.re.service;

import kr.re.dao.ProductDAO;
import kr.re.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Inject
    private ProductDAO productDAO;

    @Inject
    private ApplicationProps applicationProps;

    public BestResponse bestResponseGET() throws Exception { /* 베스트 상품 가져오기 */
        BestResponse bestResponse = new BestResponse();
        /* 36 하드코딩 */
        List<MainFirstBanner> mainFirstBannerList = productDAO.mainFirstBanner();
        List<Product> productList = productDAO.product();

        List<MainFirstBanner> mainFirstBanner = new ArrayList<>();
        for (int i = 0; i < mainFirstBannerList.size(); i++) {
            MainFirstBanner mainFirstBannerOne = new MainFirstBanner();

            int productId = mainFirstBannerList.get(i).getProductId();

            mainFirstBannerOne = productDAO.mainFirstBannerOne(i);

            Product productFirstBanner = new Product();
            productFirstBanner = productDAO.productOneByParam(productId);

            int brandId = productFirstBanner.getBrandId();
            String sellerId = productFirstBanner.getSeller();
            int deliveryId = productFirstBanner.getDeliveryId();

            Brand brand = new Brand();
            brand = productDAO.brandOne(brandId);
            productFirstBanner.setBrand(brand);

            User user = new User();
            user = productDAO.userOne(sellerId);
            productFirstBanner.setSellerUser(user);

            ProductDelivery productDelivery = new ProductDelivery();
            productDelivery = productDAO.productDeliveryOne(deliveryId);
            productFirstBanner.setProductDelivery(productDelivery);

            DeliveryCompany deliveryCompany = new DeliveryCompany();
            String companyString = productFirstBanner.getProductDelivery().getCompany();
            int companyNo = Integer.parseInt(companyString);
            deliveryCompany = productDAO.deliveryCompanyOne(companyNo);
            productDelivery.setDeliveryCompany(deliveryCompany);
            productFirstBanner.setProductDelivery(productDelivery);

            mainFirstBannerOne.setProduct(productFirstBanner);

            mainFirstBanner.add(mainFirstBannerOne);
        }

        List<Product> prod = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            int brandId = productList.get(i).getBrandId();
            String sellerId = productList.get(i).getSeller();
            int deliveryId = productList.get(i).getDeliveryId();

            Product product = new Product();
            product = productDAO.productOne(i);

            Brand brand = new Brand();
            brand = productDAO.brandOne(brandId);
            product.setBrand(brand);

            User user = new User();
            user = productDAO.userOne(sellerId);
            product.setSellerUser(user);

            ProductDelivery productDelivery = new ProductDelivery();
            productDelivery = productDAO.productDeliveryOne(deliveryId);
            product.setProductDelivery(productDelivery);

            DeliveryCompany deliveryCompany = new DeliveryCompany();
            String companyString = product.getProductDelivery().getCompany();
            int companyNo = Integer.parseInt(companyString);
            deliveryCompany = productDAO.deliveryCompanyOne(companyNo);
            productDelivery.setDeliveryCompany(deliveryCompany);
            product.setProductDelivery(productDelivery);

            prod.add(product);
        }

        bestResponse.setFirstBanner(mainFirstBanner);
        bestResponse.setProductList(prod);

        return bestResponse;
    }

    public CategoryResponse categoryResponseGET() throws Exception {

        CategoryResponse categoryResponse = new CategoryResponse();

        List<Brand> brandList = new ArrayList<>();
        List<CategoryLvResult> categoryLvResultList = new ArrayList<>();

        brandList = productDAO.brandGET();
        categoryLvResultList = productDAO.categoryLvResultGET();

        for (int i = 0; i < categoryLvResultList.size(); i++) {

//            select * from app_category WHERE 1 = 1
//;
//
//SELECT *, (SELECT * FROM app_category WHERE 1 = 1) FROM (select * from app_category WHERE 1 = 1) A WHERE 1 = 1 AND menu_depth = 4
//;
//
//-- *, (SELECT * FROM app_category WHERE 1 = 1 AND menu_parent = A.menu_parent)


        }

        logger.info(categoryLvResultList.toString());

        categoryResponse.setBrandList(productDAO.brandGET());
        categoryResponse.setCategoryList(categoryLvResultList);


//        categoryResponse.setBrandList();
//        categoryResponse.setCategoryList();

        return categoryResponse;
    }

    public CategoryResponse2 categoryResponseSec() throws Exception {

        return null;
    }


}