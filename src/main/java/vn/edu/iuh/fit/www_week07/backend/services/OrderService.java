package vn.edu.iuh.fit.www_week07.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.www_week07.backend.models.Order;
import vn.edu.iuh.fit.www_week07.backend.repositories.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findByOrderDate(LocalDateTime time){
        return orderRepository.findByOrderDate(time);
    }

    public List<Order> findByEmployeeId(long id){
        return orderRepository.findByEmployee(id);
    }


    public void insert(Order order){
        orderRepository.save(order);
    }

    public List<Order> findByCustomerId(long id){
        return orderRepository.findByCustomer_Id(id);
    }


}