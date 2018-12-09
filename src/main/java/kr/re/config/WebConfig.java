package kr.re.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by A on 2018-12-08 오후 7:16
 * re / kr.re.config
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

@Configuration
@EnableWebMvc
@EnableAutoConfiguration
@EnableSwagger2
@MapperScan(value = {"mappers"})
//@MapperScan(value = {"com.example.**.mapper"})
public class WebConfig extends WebMvcConfigurerAdapter {

    /* Mapper 설정 */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        Resource[] arrResource = new PathMatchingResourcePatternResolver()
                .getResources("classpath:mappers/*Mapper.xml");
//                .getResources("classpath:mappers/**/*Mapper.xml");
        sqlSessionFactoryBean.setMapperLocations(arrResource);
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactoryBean.getObject();
    }
    /* // Mapper 설정 */

    /* 기본 url 설정 */
    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    /* // 기본 url 설정 */

    /* Swagger 설정 */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("kr.re.controller"))
//                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, getArrayList());

    }

    private ArrayList<ResponseMessage> getArrayList() {
        ArrayList<ResponseMessage> lists = new ArrayList<ResponseMessage>();

        lists.add(new ResponseMessageBuilder().code(500).message("서버 에러").responseModel(new ModelRef("Error")).build());
        lists.add(new ResponseMessageBuilder().code(403).message("권한 없음").responseModel(new ModelRef("Forbbiden")).build());
        lists.add(new ResponseMessageBuilder().code(404).message("페이지 없음").responseModel(new ModelRef("NotFound")).build());

        /* HTTP 상태코드 정리 */
        /* https://doublesprogramming.tistory.com/203 */

        return lists;
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Hello REST API",
                "Some custom description of API.",
                "API TOS",
                "Terms of service",
                new Contact("야훔", "www.example.com", "myeaddress@company.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
    /* // Swagger 설정 */


}