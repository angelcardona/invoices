package com.billings.app.infrastructure.adapters.webClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.billings.app.domain.models.Dish;

@FeignClient(name = "menus-service", url = "http://localhost:8081")
public interface DishClient {

    @GetMapping("dishes/{dishId}")
    Dish getDishById(@PathVariable("dishId") Long dishId);
}
