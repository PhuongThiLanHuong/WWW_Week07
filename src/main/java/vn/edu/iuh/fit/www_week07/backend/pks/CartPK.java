package vn.edu.iuh.fit.www_week07.backend.pks;

import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.www_week07.backend.models.Customer;

import java.io.Serializable;

@Setter
@Getter
public class CartPK implements Serializable {
    private Customer customer;
}