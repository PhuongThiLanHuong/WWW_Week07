package vn.edu.iuh.fit.www_week07.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.www_week07.backend.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByCustomer_Id(long id);


}
