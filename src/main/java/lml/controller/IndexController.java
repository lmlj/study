package lml.controller;

import com.alibaba.fastjson.JSON;
import lml.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Auther: Lmlj
 * @Date: 2016/2/12.
 */
@Controller
public class IndexController extends BaseController {

    public static final int PAGE = 25;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHomePage() {
        return "home";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserString() {
        return "{ \"age\": 11,\"name\":\"李四\"}";
    }

    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserOne() {
        User user = new User();
        user.setId(1L);
        user.setName("aaa");
        user.setAge(22);
        return JSON.toJSONString(user);
    }
}
