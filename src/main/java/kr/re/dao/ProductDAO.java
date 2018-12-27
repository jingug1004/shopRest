package kr.re.dao;

import kr.re.vo.*;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by A on 2018-12-08 오후 10:44
 * re / kr.re.dao
 * No pain, No gain!
 * What :
 * Why :
 * How :
 * << 개정이력(Modification Information) >>
 * 수정일         수정자          수정내용
 * -------       --------       ---------------------------
 * 2018/04/01     김진국          최초 생성
 * 2017/05/27     이몽룡          인증이 필요없는 URL을 패스하는 로직 추가
 *
 * @author 개발팀 김진국
 * @version 1.0
 * @see
 * @since 2018/04/01
 */

@Repository
public class ProductDAO {

    private static final Logger logger = LoggerFactory.getLogger(ProductDAO.class);

    @Inject
    private SqlSession sqlSession;

    private static String namespace = "mappers.productMapper";

    /* 베스트 상품 가져오기 */
    public List mainFirstBanner() throws Exception {
        return sqlSession.selectList(namespace + ".mainFirstBanner");
    }

    public MainFirstBanner mainFirstBannerOne(int rownum) throws Exception {
        return sqlSession.selectOne(namespace + ".mainFirstBannerOne", rownum);
    }

    public Product productOneByParam(int productId) throws Exception {
        return sqlSession.selectOne(namespace + ".productOneByParam", productId);
    }

    public List<Product> product() throws Exception {
        return sqlSession.selectList(namespace + ".product");
    }

    public Product productOne(int rownum) throws Exception {
        return sqlSession.selectOne(namespace + ".productOne", rownum);
    }

    public Brand brandOne(int brandNum) throws Exception {
        return sqlSession.selectOne(namespace + ".brandOne", brandNum);
    }

    public User userOne(String sellerId) throws Exception {
        return sqlSession.selectOne(namespace + ".userOne", sellerId);
    }

    public ProductDelivery productDeliveryOne(int productDeliveryCode) throws Exception {
        return sqlSession.selectOne(namespace + ".productDeliveryOne", productDeliveryCode);
    }

    public DeliveryCompany deliveryCompanyOne(int deliveryCompanyCode) throws Exception {
        return sqlSession.selectOne(namespace + ".deliveryCompanyOne", deliveryCompanyCode);
    }

    public ProductDelivery productDelivery() throws Exception {
        return sqlSession.selectOne(namespace + ".productDelivery");
    }
    /* // 베스트 상품 가져오기 */

    /* 카테고리 가져오기 */
    public List<Brand> brandGET() throws Exception {
        return sqlSession.selectList(namespace + ".brandGET");
    }

    public List<CategoryLvResult> categoryLvResultGET() throws Exception {
        return sqlSession.selectList(namespace + ".categoryLvResultGET");
    }
    /* // 카테고리 가져오기 */

    /* 상품 상세 정보 가져오기 */
    public Product productOneByPrdId(int productId) throws Exception {
        return sqlSession.selectOne(namespace + ".productOneByPrdId", productId);
    }

    public List<ProductItem> productItemByPrdId(int productId) throws Exception {
        return sqlSession.selectList(namespace + ".productItemByPrdId", productId);
    }

    public ProductTimeSale productTimeSaleByPrdId(int productId) throws Exception {
        return sqlSession.selectOne(namespace + ".productTimeSaleByPrdId", productId);
    }

    public List<ProductCategory> productCategoryByPrdId(int productId) throws Exception {
        return sqlSession.selectList(namespace + ".productCategoryByPrdId", productId);
    }
    /* // 상품 상세 정보 가져오기 */


}