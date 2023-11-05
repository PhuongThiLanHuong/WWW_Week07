package vn.edu.iuh.fit.www_week07.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.edu.iuh.fit.www_week07.backend.models.ProductPrice;

public interface ProductPriceRepository extends JpaRepository<ProductPrice,Long>, JpaSpecificationExecutor<ProductPrice> {
}
