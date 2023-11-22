package vn.edu.iuh.fit.www_week07.backend.pks;

import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.www_week07.backend.models.Cart;
import vn.edu.iuh.fit.www_week07.backend.models.Product;

import java.io.Serializable;

@Getter
@Setter
public class CartDetailPK implements Serializable {
    private Cart cart;
    private Product product;
}