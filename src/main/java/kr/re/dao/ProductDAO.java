package kr.re.dao;

import kr.re.vo.Brand;
import kr.re.vo.MainFirstBanner;
import kr.re.vo.Product;
import kr.re.vo.ProductDelivery;
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
    public List<MainFirstBanner> mainFirstBanner() throws Exception {
        return sqlSession.selectList(namespace + ".mainFirstBanner");
    }

    public List<Product> product() throws Exception {
        return sqlSession.selectList(namespace + ".product");
    }

    public ProductDelivery productDelivery() throws Exception {
        return sqlSession.selectOne(namespace + ".productDelivery");
    }

    public Brand brand(int num) throws Exception {
        return sqlSession.selectOne(namespace + ".brand", num);
    }
    /* // 베스트 상품 가져오기 */


}