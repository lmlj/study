package lml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: Lmlj
 * @Date: 2016/2/12.
 */
//@Controller
public class IndexController {

//    @RequestMapping(value = "/name", method = RequestMethod.GET)
//    @ResponseBody
    public Object getName() {
        String name = "aa:bb";
        return name;
    }
}
