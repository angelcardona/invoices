package com.billings.app.applicattion.ports.out;

import java.util.Optional;

import com.billings.app.domain.models.Dish;

public interface IDishInfoPort {

    Optional<Dish> getDishById(Long id);

}
