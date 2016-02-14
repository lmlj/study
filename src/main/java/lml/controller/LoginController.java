package lml.controller;

import com.alibaba.fastjson.JSON;
import lml.domain.ResponseJSON;
import lml.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Lmlj
 * @Date: 2016/2/14.
 */
@Controller
public class LoginController extends BaseController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestParam String userName, @RequestParam String passWord) {
        //TODO 查询数据库中数据问题
        User user = new User();
        Object validateUser = validateUser(userName, passWord);
        if (validateUser instanceof ResponseJSON) {
            ResponseJSON responseJSON = (ResponseJSON) validateUser;
            return JSON.toJSONString(responseJSON);
        } else {
            user = (User) validateUser;
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return getSuccessResponseBody("login success!");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Object register(@RequestParam String userName, @RequestParam String passWord, @RequestParam Integer age) {
        User user = new User();
        user.setId(User.getFinalId());
        user.setName(userName);
        user.setPassWord(passWord);
        user.setAge(age);

        cache.put(user.getId(), user);
        return getSuccessResponseBody("register success!");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object getList() {
        List<User> userList = new ArrayList<User>();
        for (Map.Entry<Long, User> entry : cache.entrySet()) {
            User user = entry.getValue();
            userList.add(user);
        }

        return getSuccessResponseBody(userList);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public Object queryByName(@RequestParam String userName) {
        List<User> userList = new ArrayList<User>();
        for (Map.Entry<Long, User> entry : cache.entrySet()) {
            User user = entry.getValue();
            if (user.getName().equals(userName)) {
                userList.add(user);
            }
        }
        return getSuccessResponseBody(userList);
    }
}
