package vn.edu.iuh.fit.www_week07.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.www_week07.backend.enums.ProductStatus;
import vn.edu.iuh.fit.www_week07.backend.models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {
    @Query("SELECT p, pi, pp FROM Product p LEFT JOIN FETCH p.productImageList pi LEFT JOIN p.productPrices pp WHERE p.status = ?1")
    List<Object[]> findAllProductsWithDetails(ProductStatus status);

}
