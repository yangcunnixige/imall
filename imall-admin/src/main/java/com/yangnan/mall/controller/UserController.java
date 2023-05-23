package com.yangnan.mall.controller;

import com.google.code.kaptcha.Constants;
import com.yangnan.mall.pojo.Category;
import com.yangnan.mall.pojo.Product;
import com.yangnan.mall.pojo.User;
import com.yangnan.mall.pojo.query.UserQuery;
import com.yangnan.mall.service.IUserService;
import com.yangnan.mall.util.JSONResult;
import com.yangnan.mall.util.LayUITableJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService userService;

    @RequestMapping("/getUserListPage")
    public String getUserListPage() {
        return "user_list";
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public User selectById(Integer id) {
        System.out.println("UserController.selectById");
        User user = userService.selectById(id);
        System.out.println(user);
        return user;
    }

    @RequestMapping("/selectByPage")
    @ResponseBody
    public LayUITableJSONResult selectByPage(UserQuery userQuery) {
        System.out.println("UserController.selectByPage");
        return userService.selectByPage(userQuery);
    }

    @RequestMapping("/getUserAddPage")
    public String getUserAddPage() {
        //List<Category> topCategoryList = categoryService.selectTopCategoryList();
        //model.addAttribute("topCategoryList", topCategoryList);
        return "user_add";
    }

    @RequestMapping("/add")
    @ResponseBody
    public JSONResult add(User user) {
        System.out.println("UserController.add");
        return userService.add(user);
    }

    @RequestMapping("/getUserUpdatePage")
    public String getUserUpdatePage(Integer id, Model model) {
        User user = userService.selectById(id);
        model.addAttribute("user", user);
        return "user_update";
    }

    @RequestMapping("/update")
    @ResponseBody
    public JSONResult update(User user) {
        System.out.println("ProductController.update");
        return userService.update(user);
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public JSONResult deleteById(Integer id) {
        System.out.println("UserController.deleteById");
        return userService.deleteById(id);
    }

    @RequestMapping("/deleteAll")
    @ResponseBody
    public JSONResult deleteAll(Integer[] ids) {
        System.out.println("UserController.deleteAll");
        return userService.deleteAll(ids);
    }

    @RequestMapping("/login")
    @ResponseBody
    public JSONResult login(String username, String password,String code,HttpSession session) {
        // 先判断验证码是不是正确
        // 验证码错误，返回一个错误提示信息
        // 验证码正确，再验证用户名和密码是否正确
        //String codeInSession = (String) session.getAttribute("codeInSession");
        String codeInSession = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (!codeInSession.equalsIgnoreCase(code)) {
            System.out.println("验证码错误");
            return JSONResult.error("验证码错误");
        }
        User user = userService.login(username, password);
        if (user == null) {
            return JSONResult.error("用户名密码错误");
        } else {
            if (user.getStatus() == 2) {
                return JSONResult.error("该用户已经被禁用");
            }
            //登录上之后，将登录的凭证user对象放到这个用户的Session中
            session.setAttribute("user", user);
            return JSONResult.ok("登录成功");
        }
        /*User user = null;
        if (user == null) {
            return JSONResult.error("登录失败");
        } else {
            session.setAttribute("user", user);
            return JSONResult.ok("登录成功");
        }*/
    }

    @RequestMapping("/getLoginPage")
    public String getLoginPage() {
        return "login";
    }


}
