package vn.edu.iuh.fit.www_week07.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.www_week07.backend.models.ProductPrice;
import vn.edu.iuh.fit.www_week07.backend.repositories.ProductPriceRepository;

import java.util.Optional;

@Service
public class ProductPriceService {

    @Autowired
    private ProductPriceRepository productPriceRepository;


    public Optional<ProductPrice> findPriceByProductId(long id){
        return productPriceRepository.findProductPriceByProductId(id);
    }
}
