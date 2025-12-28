package com.example.Client.controller;

import com.example.Client.dto.CarDTO;
import com.example.Client.feign.CarFeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final RestTemplate restTemplate;
    private final WebClient webClient;
    private final CarFeignClient carFeignClient;

    private static final String CAR_SERVICE_URL =
            "http://localhost:8081/api/cars/byClient/{clientId}";

    public ClientController(RestTemplate restTemplate,
                            WebClient webClient,
                            CarFeignClient carFeignClient) {
        this.restTemplate = restTemplate;
        this.webClient = webClient;
        this.carFeignClient = carFeignClient;
    }

    @GetMapping("/{id}/car/rest")
    public CarDTO getCarWithRestTemplate(@PathVariable Long id) {
        return restTemplate.getForObject(
                CAR_SERVICE_URL,
                CarDTO.class,
                id
        );
    }

    @GetMapping("/{id}/car/feign")
    public CarDTO getCarWithFeign(@PathVariable Long id) {
        return carFeignClient.getCarByClient(id);
    }

    @GetMapping("/{id}/car/webclient")
    public CarDTO getCarWithWebClient(@PathVariable Long id) {
        return webClient.get()
                .uri(CAR_SERVICE_URL, id)
                .retrieve()
                .bodyToMono(CarDTO.class)
                .block(); // volontaire pour TP synchrone
    }
}
