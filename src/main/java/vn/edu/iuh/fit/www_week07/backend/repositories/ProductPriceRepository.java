package vn.edu.iuh.fit.www_week07.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.www_week07.backend.models.ProductPrice;

import java.util.Optional;

public interface ProductPriceRepository extends JpaRepository<ProductPrice,Long>, JpaSpecificationExecutor<ProductPrice> {
    @Query(
            """
            SELECT productPrice FROM ProductPrice productPrice
            LEFT JOIN Product product on productPrice.product = product
            WHERE productPrice.product.product_id = :productId
            ORDER BY productPrice.price_date_time DESC
            LIMIT 1
            """
    )
    Optional<ProductPrice> findProductPriceByProductId(long productId);
}
