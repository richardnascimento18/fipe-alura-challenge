package br.com.alura.FipeTableChallenge.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VehiclePrice(@JsonAlias("Marca") String brand,
                           @JsonAlias("Valor") String value,
                           @JsonAlias("Modelo") String model,
                           @JsonAlias("AnoModelo") String year,
                           @JsonAlias("Combustivel") String fuelType) {}
