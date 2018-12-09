package kr.re.service;

import kr.re.dao.ProductDAO;
import kr.re.vo.BestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Inject
    private ProductDAO productDAO;

    public BestResponse bestResponseGET() throws Exception { /* 베스트 상품 가져오기 */

        BestResponse bestResponse = new BestResponse();

        bestResponse.setFirstBanner(productDAO.mainFirstBanner());
        bestResponse.setProductList(productDAO.product());

        return bestResponse;
    }

//    @Override
//    public BestResponse bestResponseGET() {
//
//        ProductRetroImpl client = new ProductRetroImpl();
//
//        BestResponse bestResponse = client.bestResponseGET();
//
//        return bestResponse;
//
//    }
//
//    @Override
//    public CategoryResponse categoryResponseGET() {
//
//        ProductRetroImpl client = new ProductRetroImpl();
//
//        CategoryResponse categoryResponse = client.categoryResponseGET();
//
//        return categoryResponse;
//    }
//
//    @Override
//    public ProductResponse productDetailGET(long product_id1) {
//
//        ProductRetroImpl client = new ProductRetroImpl();
//
//        ProductResponse response = client.detailGET(product_id1);
//
//        return response;
//    }
//
//
//    /*time sale list by minho*/
//	@Override
//	public List<ProductTimeSale> timeSaleList2() {
//		// TODO Auto-generated method stub
//
//		ProductRetroImpl PRI = new ProductRetroImpl();
//
//		List<ProductTimeSale> res = PRI.timeSaleList();
//
//		return res;
//	}
//
//
//	/*balgeure box by minho*/
//	@Override
//	public List<Product> balgeureBox2() {
//		// TODO Auto-generated method stub
//
//		ProductRetroImpl PRI = new ProductRetroImpl();
//
//		List<Product> res = PRI.balgeureBox();
//
//		return res;
//	}
//
//
//	/*new product by minho*/
//	@Override
//	public BestResponse newProduct2() {
//		// TODO Auto-generated method stub
//
//		ProductRetroImpl PRI = new ProductRetroImpl();
//
//		BestResponse res = PRI.newProduct();
//
//		return res;
//	}
//
//
//	/*category by minho*/
//	@Override
//	public CategoryResponse categoryList2() {
//		// TODO Auto-generated method stub
//
//		ProductRetroImpl PRI = new ProductRetroImpl();
//
//		CategoryResponse res = PRI.categoryList();
//
//		return res;
//	}
//
//
//	/*sub category by minho*/
//	@Override
//	public CategoryResponse subCategory2(long menu_id) {
//		// TODO Auto-generated method stub
//
//		ProductRetroImpl PRI = new ProductRetroImpl();
//
//		CategoryResponse res = PRI.subCategory(menu_id);
//
//		return res;
//	}
//
//
//	/*category list by minho*/
//	@Override
//	public PageProduct categoryList2(long parent, int page, long menu_id, int sort) {
//		// TODO Auto-generated method stub
//
//		ProductRetroImpl PRI = new ProductRetroImpl();
//
//		PageProduct res = PRI.categoryList2(parent, page, menu_id, sort);
//
//		return res;
//	}
//
//	@Override
//	public RelationResponse relationProduct(long product_id) {
//		// TODO Auto-generated method stub
//
//		ProductRetroImpl PRI = new ProductRetroImpl();
//
//		RelationResponse res = PRI.relationProduct2(product_id);
//
//		return res;
//	}
//
//	@Override
//	public CategoryResponse2 categoryList22() {
//		// TODO Auto-generated method stub
//
//		ProductRetroImpl PRI = new ProductRetroImpl();
//
//		CategoryResponse2 res = PRI.categoryList2();
//
//		return res;
//	}
//
//	@Override
//	public PageBrand brandList2(int page, long brand_id, int sort) {
//		// TODO Auto-generated method stub
//
//		ProductRetroImpl PRI = new ProductRetroImpl();
//
//		PageBrand res = PRI.brandList(page, brand_id, sort);
//
//		return res;
//	}

}