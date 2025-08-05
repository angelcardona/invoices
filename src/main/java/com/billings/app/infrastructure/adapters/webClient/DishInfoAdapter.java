package com.billings.app.infrastructure.adapters.webClient;

import java.util.Optional;

import com.billings.app.applicattion.ports.out.IDishInfoPort;
import com.billings.app.domain.models.Dish;

public class DishInfoAdapter implements IDishInfoPort {

    @Override
    public Optional<Dish> getDishById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDishById'");
    }

}
