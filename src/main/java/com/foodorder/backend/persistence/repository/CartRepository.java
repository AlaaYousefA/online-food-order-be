package com.foodorder.backend.persistence.repository;

import com.foodorder.backend.domain.model.Cart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository {
    Cart save(Cart cart);
}
