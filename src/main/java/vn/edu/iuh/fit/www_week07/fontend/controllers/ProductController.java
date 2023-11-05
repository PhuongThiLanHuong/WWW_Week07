package vn.edu.iuh.fit.www_week07.fontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import vn.edu.iuh.fit.www_week07.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.www_week07.backend.services.ProductService;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
}
