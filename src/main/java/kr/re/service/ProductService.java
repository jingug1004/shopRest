package kr.re.service;

import kr.re.dao.ProductDAO;
import kr.re.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        /* fori Product Case.01 */
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
        /* // fori Product Case.01 */

        bestResponse.setFirstBanner(mainFirstBanner);
        bestResponse.setProductList(prod);

        return bestResponse;
    }

    public CategoryResponse categoryResponseGET() throws Exception {
        CategoryResponse categoryResponse = new CategoryResponse();

        categoryResponse.setBrandList(productDAO.brandGET());
        categoryResponse.setCategoryList(productDAO.categoryLvResultGET());

        return categoryResponse;
    }

    /**
     * 사용 안 함.
     *
     * @return
     * @throws Exception
     */
    public CategoryResponse2 categoryResponseSec() throws Exception {

        return null;
    }

    public ProductResponse productResponseGET(int productId) throws Exception {
        ProductResponse productResponse = new ProductResponse();

        productResponse.setProduct(productDAO.productOneByPrdId(productId));
        productResponse.setProductItem(productDAO.productItemByPrdId(productId));
        productResponse.setProductTimeSale(productDAO.productTimeSaleByPrdId(productId));

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategory(productDAO.productCategoryByPrdId(productId));
        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList.add(productCategory);

        productResponse.setProductCategory(productCategoryList);

        return productResponse;
    }

    public PageBrand brandListGET(int page, int brandId, Integer sort) throws Exception {
        PageBrand pageBrand = new PageBrand();

        Map<String, Object> paramMap = new HashMap<String, Object>();

        int multiplyPage = (page - 1) * 10;
//        sort = 0;

        paramMap.put("page", multiplyPage);
        paramMap.put("brandId", brandId);
        paramMap.put("sort", sort);

        pageBrand.setContent(productDAO.brandListProductGET(paramMap));

        return pageBrand;
    }

    public List<Product> productSearchGET(String searchName) throws Exception {
        List<ProductTimeSale> productTimeSale = new ArrayList<>();
        productTimeSale = productDAO.productTimeSaleListGET();

        List<Product> products = new ArrayList<>();
        products = productDAO.productSearchGET(searchName);

        /* fori Product Case.01 */
        List<Product> prod = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            int brandId = products.get(i).getBrandId();
            String sellerId = products.get(i).getSeller();
            int deliveryId = products.get(i).getDeliveryId();

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

        return prod;

        /* // fori Product Case.01 */
    }

    public List<ProductTimeSale> productTimeSaleListGET() throws Exception {
        List<ProductTimeSale> products = new ArrayList<>();
        products = productDAO.productTimeSaleListGET();

        /* fori Product Case.02 */
        /* ToDo: 190110 DB 성능 개선 필요함. 이상은 없지만 너무 느림. */
        List<ProductTimeSale> listProductTimeSale = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            Product product = new Product();
            ProductTimeSale proTimSal = new ProductTimeSale();
            proTimSal = productDAO.productTimeSaleOneGET(i);

            int tem = products.get(i).getProductId();
            product = productDAO.productOneByPrdId(tem);

            int brandId = product.getBrandId();
            String sellerId = product.getSeller();
            int deliveryId = product.getDeliveryId();

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

            proTimSal.setProduct(product);

            listProductTimeSale.add(proTimSal);
        }

        return listProductTimeSale;
        /* // fori Product Case.02 */
    }

}