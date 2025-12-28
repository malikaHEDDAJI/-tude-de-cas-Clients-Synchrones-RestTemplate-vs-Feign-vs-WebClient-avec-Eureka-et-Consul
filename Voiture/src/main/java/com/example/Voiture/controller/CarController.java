package com.example.Voiture.controller;

import com.example.Voiture.model.Car;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @GetMapping("/byClient/{clientId}")
    public Car getCarByClient(@PathVariable Long clientId) throws InterruptedException {

        Thread.sleep(20);

        return new Car(
                10L,
                "Toyota",
                "Yaris",
                clientId
        );
    }
}
