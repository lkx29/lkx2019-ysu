package com.neuedu.controller;


import com.neuedu.exception.MyException;
import com.neuedu.pojo.Category;
import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.List;

@Controller
@RequestMapping("/user/product/")
public class ProductController {

    @Autowired
    IProductService productService;
    @RequestMapping("find")
    public  String findAll(HttpSession session){
        List<Product> products=productService.findAll();
        session.setAttribute("products",products);
        return "productlist";
    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public String update (@PathVariable("id")Integer productId, HttpServletRequest request){
        Product product=productService.findById(productId);
        request.getSession().setAttribute("product",product);
        return "productupdate";
    }
    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public String update(Product product,HttpServletRequest request, HttpServletResponse response) throws MyException, UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        int count=productService.updateProduct(product);
        if (count>0){
            return "redirect:/user/product/find";
        }
        return "productupdate";
    }
    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String add(HttpSession session){

        return "productadd";
    }
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String add(Product product, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        int count =productService.addProduct(product);
        if (count>0){
            return "redirect:/user/product/find";
        }
        return "productadd";
    }
    @RequestMapping("delete/{id}")
    public String delete(Product product){
        int productId=product.getId();
        int count=productService.deleteProduct(productId);
        return "redirect:/user/product/find";
    }
}
