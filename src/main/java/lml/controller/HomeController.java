package lml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Auther: Lmlj
 * @Date: 2016/2/12.
 */
@Controller
public class HomeController {

    public static final int PAGE = 25;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHomePage() {
        return "home";
    }

    @RequestMapping(value = "/string", method = RequestMethod.GET)
    @ResponseBody
    public String toGetString() {
        System.out.println("------------this is method----------");
        return "aaaa";
    }
}
