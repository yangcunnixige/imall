package com.yangnan.mall.controller;

import com.yangnan.mall.pojo.Category;
import com.yangnan.mall.pojo.Shipping;
import com.yangnan.mall.pojo.User;
import com.yangnan.mall.service.ICategoryService;
import com.yangnan.mall.service.IShippingService;
import com.yangnan.mall.service.IUserService;
import com.yangnan.mall.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IShippingService shippingService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/checkUserLogin")
    @ResponseBody
    public JSONResult checkUserLogin(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return user != null ? JSONResult.ok() : JSONResult.error();
    }

    @RequestMapping("/login")
    @ResponseBody
    public JSONResult login(String username, String password, HttpSession session) {
        User user = userService.login(username, password);
        if (user == null) {
            return JSONResult.error("登录失败");
        } else {
            session.setAttribute("user", user);
            return JSONResult.ok("登录成功");
        }
    }

    @RequestMapping("/getLoginPage")
    public String getLoginPage(HttpSession session,Model model) {
        User user = (User) session.getAttribute("user");
        if(user == null) {
            return "login";
        }
        else {
            model.addAttribute("user", user);
            System.out.println(user);
            return "user_center";
        }
    }

    @RequestMapping("/getRegistPage")
    public String getRegistPage() {
        return "regist";
    }

    @RequestMapping("/regist")
    @ResponseBody
    public JSONResult regist(User user) {
        int count = userService.regist(user);
        if (count == 1) {
            return JSONResult.ok("注册成功");
        } else {
            return JSONResult.ok("注册失败");
        }
    }

    @RequestMapping("/getUserCenterPage")
    public String getUserCenterPage(HttpSession session,Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "user_center";
    }

    @RequestMapping("/getUserAddressPage")
    public String getUserAddressPage(Model model,HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Shipping> list = shippingService.selectByUserId(user.getId());
        System.out.println("123456"+list);
        model.addAttribute("list", list);
        return "user_address";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }

    @RequestMapping("/addShipping")
    @ResponseBody
    public JSONResult addShipping(Shipping shipping,HttpSession session) {
        User user = (User) session.getAttribute("user");
        shipping.setUserId(user.getId());
        return shippingService.addShipping(shipping);
    }

    @RequestMapping("/deleteShipping")
    @ResponseBody
    public JSONResult deleteShipping(Integer id) {
        return shippingService.deleteById(id);
    }
}