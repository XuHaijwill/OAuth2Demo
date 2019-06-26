package cn.xhjc.controller;

import cn.xhjc.enums.ErrorCodeEnum;
import cn.xhjc.model.AuthAccessToken;
import cn.xhjc.model.User;
import cn.xhjc.service.AuthorizationService;
import cn.xhjc.service.UserService;
import cn.xhjc.utils.JsonUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 通过Access Token访问的API服务
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Resource(name = "authorizationServiceImpl")
    private AuthorizationService authorizationService;

    @Resource(name = "userServiceImpl")
    private UserService userService;

    @RequestMapping(value = "/users/getInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getUserInfo(HttpServletRequest request){
        String accessToken = request.getParameter("access_token");
        //查询数据库中的Access Token
        AuthAccessToken authAccessToken = authorizationService.selectByAccessToken(accessToken);

        if(authAccessToken != null){
            User user = userService.selectUserInfoByScope(authAccessToken.getUserId(), authAccessToken.getScope());
            return JsonUtils.toJson(user);
        }else{
            return this.generateErrorResponse(ErrorCodeEnum.INVALID_GRANT);
        }
    }

    /**
     * 组装错误请求的返回
     */
    private String generateErrorResponse(ErrorCodeEnum errorCodeEnum) {
        Map<String,Object> result = new HashMap<>(2);
        result.put("error", errorCodeEnum.getError());
        result.put("error_description",errorCodeEnum.getErrorDescription());

        return JsonUtils.toJson(result);
    }

}
