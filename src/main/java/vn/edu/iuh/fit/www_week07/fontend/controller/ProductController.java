package vn.edu.iuh.fit.www_week07.fontend.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.www_week07.backend.models.Employee;
import vn.edu.iuh.fit.www_week07.backend.models.Product;
import vn.edu.iuh.fit.www_week07.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.www_week07.backend.services.ProductServices;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private ProductServices productServices;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String showProductListPaging(
            HttpSession session,
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Page<Product> productPage = productServices.findPaginated(currentPage - 1,
                pageSize, "name", "asc");

        model.addAttribute("productPage", productPage);

        int totalPages = productPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "admin/product/listing";
    }

    @GetMapping("/product/show-add-form")
    public String add(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "admin/product/add-form";
    }

    @PostMapping("/products/add")
    public String addProduct(
            @ModelAttribute("product") Product product,
            BindingResult result, Model model) {
        productRepository.save(product);
        return "redirect:/admin/products";
    }

    //    @DeleteMapping("/products/delete/{id}")
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
        Product product = productRepository.findById(id).orElse(new Product());
        productRepository.delete(product);
        return "redirect:/admin/products";
    }
    @GetMapping("/products/show-edit-form/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Product> optionalProduct= productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            model.addAttribute("productToUpdate", optionalProduct.get());
            return "/admin/product/edit-form";
        }
        return "/admin/product/listing";
    }

    @PostMapping("/products/edit/{id}")
    public String updateProduct(@PathVariable Long id,
                                @RequestParam String name,
                                @RequestParam String description,
                                @RequestParam String unit,
                                @RequestParam String manufacturer
                                ) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
           existingProduct.setName(name);
           existingProduct.setDescription(description);
           existingProduct.setUnit(unit);
           existingProduct.setManufacturer(manufacturer);
            productRepository.save(existingProduct);
        } else {
            throw new Exception("Khong tim thay Product!");
        }
        return "redirect:/admin/products";
    }
}