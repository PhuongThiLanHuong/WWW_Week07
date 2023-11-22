package vn.edu.iuh.fit.www_week07.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.www_week07.backend.models.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long>, JpaSpecificationExecutor<Order> {
    @Query("""
        select o from Order o where o.orderDate = :orderDate
        """)
    List<Order> findByOrderDate(LocalDateTime orderDate);

    @Query("""
        select o from Order o where o.employee.id = :id
        """)
    List<Order> findByEmployee(Long id);


    List<Order> findByCustomer_Id(long id);

}
