package br.com.alura.FipeTableChallenge.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VehicleModel(@JsonAlias("codigo") String code,
                           @JsonAlias("nome") String name) {}
