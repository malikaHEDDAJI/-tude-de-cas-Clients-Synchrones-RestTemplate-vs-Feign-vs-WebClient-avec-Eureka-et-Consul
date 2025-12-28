package com.example.Voiture.model;

public class Car {

    private Long id;
    private String marque;
    private String modele;
    private Long clientId;

    public Car(Long id, String marque, String modele, Long clientId) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.clientId = clientId;
    }

    public Long getId() { return id; }
    public String getMarque() { return marque; }
    public String getModele() { return modele; }
    public Long getClientId() { return clientId; }
}
