package vn.edu.iuh.fit.www_week07.fontend.controller;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.www_week07.backend.enums.ProductStatus;
import vn.edu.iuh.fit.www_week07.backend.models.CartDetail;
import vn.edu.iuh.fit.www_week07.backend.models.Product;
import vn.edu.iuh.fit.www_week07.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.www_week07.backend.services.ProductServices;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/client")
public class ShoppingController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductServices productServices;
    @GetMapping("/shopping/home")
    public String homePage(){
        return "/client/shopping/home";
    }

    @GetMapping("/shopping/cart")
    public String checkOut() {
        return "/client/shopping/cart";
    }

}
