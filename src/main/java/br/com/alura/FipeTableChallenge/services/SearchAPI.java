package br.com.alura.FipeTableChallenge.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SearchAPI {
    private final String apiEndpoint = "https://parallelum.com.br/fipe/api/v1/";
    private String chosenVehicleType = null;
    private String chosenVehicleModel = null;
    private String chosenVehicle = null;
    private String chosenVehicleYear = null;

    public String searchType(String vehicleType) {
        this.chosenVehicleType = vehicleType;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiEndpoint + chosenVehicleType + "/marcas"))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }

    public String searchModel(String vehicleModel) {
        this.chosenVehicleModel = vehicleModel;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiEndpoint + this.chosenVehicleType + "/marcas/" + chosenVehicleModel + "/modelos"))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }

    public String searchYear(String vehicle) {
        this.chosenVehicle = vehicle;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiEndpoint + this.chosenVehicleType + "/marcas/" + this.chosenVehicleModel + "/modelos/" + this.chosenVehicle + "/anos"))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }

    public String searchPrice(String year) {
        this.chosenVehicleYear = year;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.apiEndpoint + this.chosenVehicleType + "/marcas/" + this.chosenVehicleModel + "/modelos/" + this.chosenVehicle + "/anos/" + this.chosenVehicleYear))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }
}
