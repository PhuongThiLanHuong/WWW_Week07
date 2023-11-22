package vn.edu.iuh.fit.www_week07.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.www_week07.backend.models.CartDetail;

public interface CartDetailRepository extends JpaRepository<CartDetail,Long> {
}
