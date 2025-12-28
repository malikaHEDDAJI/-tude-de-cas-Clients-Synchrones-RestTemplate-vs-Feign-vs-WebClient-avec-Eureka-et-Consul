package com.example.Client.feign;

import com.example.Client.dto.CarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "car-service",
        url = "http://localhost:8081"
)
public interface CarFeignClient {

    @GetMapping("/api/cars/byClient/{clientId}")
    CarDTO getCarByClient(@PathVariable Long clientId);
}
