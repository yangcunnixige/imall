package com.yangnan.mall.controller;

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
}
