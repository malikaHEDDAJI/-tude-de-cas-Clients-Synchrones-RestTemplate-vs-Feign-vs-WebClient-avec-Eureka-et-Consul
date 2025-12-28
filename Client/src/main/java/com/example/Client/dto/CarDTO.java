package com.example.Client.dto;

public class CarDTO {

    private Long id;
    private String marque;
    private String modele;
    private Long clientId;

    public Long getId() { return id; }
    public String getMarque() { return marque; }
    public String getModele() { return modele; }
    public Long getClientId() { return clientId; }

    public void setId(Long id) { this.id = id; }
    public void setMarque(String marque) { this.marque = marque; }
    public void setModele(String modele) { this.modele = modele; }
    public void setClientId(Long clientId) { this.clientId = clientId; }
}
