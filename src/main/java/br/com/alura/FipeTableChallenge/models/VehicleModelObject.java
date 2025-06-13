package br.com.alura.FipeTableChallenge.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VehicleModelObject(@JsonAlias("modelos") ArrayList<VehicleModel> models) {}
