package lml.controller;

import com.alibaba.fastjson.JSON;
import lml.domain.ResponseJSON;
import lml.domain.User;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Lmlj
 * @Date: 2016/2/14.
 */
public class BaseController extends RequestResponseController {

    public Map<Long, User> cache = new HashMap<Long, User>();

    public void addUser(User user) {
        cache.put(user.getId(), user);
    }

    public User getUser(Long id) {
        return cache.get(id);
    }

    public Object validateUser(String userName, String passWord) {
        for (Map.Entry<Long, User> entry : cache.entrySet()) {
            User user1 = entry.getValue();
            if (user1.getName().equals(userName) && user1.getPassWord().endsWith(passWord)) {
                return user1;
            }
        }
        ResponseJSON responseJSON = new ResponseJSON(false, "userName or passWord is error!");
        return responseJSON;
    }

    public User getUser() {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public Object getSuccessResponseBody() {
        ResponseJSON responseJSON = new ResponseJSON();
        responseJSON.setIsSuccess(true);
        responseJSON.setData(null);
        return JSON.toJSONString(responseJSON);
    }

    public Object getSuccessResponseBody(Object data) {
        ResponseJSON responseJSON = new ResponseJSON();
        responseJSON.setIsSuccess(true);
        responseJSON.setData(data);
        return JSON.toJSONString(responseJSON);
    }
}
