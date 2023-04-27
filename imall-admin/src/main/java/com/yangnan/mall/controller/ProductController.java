package com.yangnan.mall.controller;

import com.yangnan.mall.pojo.Category;
import com.yangnan.mall.pojo.Product;
import com.yangnan.mall.pojo.query.ProductQuery;
import com.yangnan.mall.service.ICategoryService;
import com.yangnan.mall.service.IProductService;
import com.yangnan.mall.util.JSONResult;
import com.yangnan.mall.util.LayUITableJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("/getProductListPage")
    public String getProductListPage() {

        return "product_list";
    }


    @RequestMapping("/selectById")
    @ResponseBody
    public Product selectById(Integer id) {
        System.out.println("ProductController.selectById");
        Product product = productService.selectById(id);
        return product;
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Product> selectAll() {
        System.out.println("ProductController.selectAll");
        List<Product> list = productService.selectAll();
        return list;
    }

    @RequestMapping("/selectByPage")
    @ResponseBody
    public LayUITableJSONResult selectByPage(ProductQuery productQuery) {
        System.out.println("ProductController.selectByPage");
        return productService.selectByPage(productQuery);
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public JSONResult deleteById(Integer id) {
        System.out.println("ProductController.deleteById");
        return productService.deleteById(id);
    }

    @RequestMapping("/deleteAll")
    @ResponseBody
    public JSONResult deleteAll(Integer[] ids) {
        System.out.println("ProductController.deleteAll");
        return productService.deleteAll(ids);
    }


    @RequestMapping("/getProductAddPage")
    public String getProductAddPage(Model model) {
        List<Category> topCategoryList = categoryService.selectTopCategoryList();
        model.addAttribute("topCategoryList", topCategoryList);
        return "product_add";
    }

    @RequestMapping("/add")
    @ResponseBody
    public JSONResult add(Product product) {
        System.out.println("ProductController.add");
        return productService.add(product);
    }

}