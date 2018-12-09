package kr.re.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.re.service.ApiService;
import kr.re.vo.ApiResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by A on 2018-12-08 오후 7:26
 * re / kr.re.controller
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


@RestController
@Api(value = "ApiController", description = "헬로 에이피아이 2")
public class ApiController {

    @Inject
    private ApiService apiService;

    @GetMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
    }

    @RequestMapping(value = "/hello02", method = RequestMethod.GET)
    public String hello02() {
        return "hello02";
    }

    @RequestMapping(value = "/apiTest", method = RequestMethod.GET)
    @ApiOperation(value = "apiTest", notes = "apiTest를 반환하는 return apiService.getNow(); 통신 확인용.")
    public String apiTest() throws Exception {
        return apiService.getNow();
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiOperation(value = "hello, World API", notes = "hello, World를 반환하는 API, Ajax 통신 확인용.")
    public ResponseEntity<ApiResponseMessage> hello() {
        ApiResponseMessage message = new ApiResponseMessage("Success", "Hello, World!!!", "", "");

        return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
    }


}

