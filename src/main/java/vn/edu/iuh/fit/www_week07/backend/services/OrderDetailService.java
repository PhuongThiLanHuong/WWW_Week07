package vn.edu.iuh.fit.www_week07.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.www_week07.backend.models.OrderDetail;
import vn.edu.iuh.fit.www_week07.backend.repositories.OrderDetailRepository;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;


    public void insert(OrderDetail orderDetail){
        orderDetailRepository.save(orderDetail);
    }

}