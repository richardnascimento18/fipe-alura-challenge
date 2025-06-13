package br.com.alura.FipeTableChallenge.services;

import br.com.alura.FipeTableChallenge.models.Brand;
import br.com.alura.FipeTableChallenge.models.VehicleModel;
import br.com.alura.FipeTableChallenge.models.VehicleModelObject;
import br.com.alura.FipeTableChallenge.models.VehiclePrice;

import java.util.Arrays;

public class Menu {

    public void displayMenuOptions() {
        System.out.println("-------------------------");
        System.out.println("Hello there! Please select the type of vehicle below:");
        System.out.println("-------------------------");
        System.out.println("List: (Please use the number corresponding to the vehicle you choose)");
        System.out.println("1. Carros");
        System.out.println("2. Motos");
        System.out.println("3. Caminhões");
        System.out.println("-------------------------");
    }

    public void displayBrandOptions(Brand[] data) {
        Arrays.stream(data).forEach(b -> System.out.println("Code: " + b.code() + " Description: " + b.name()));
    }

    public void displayVehicleModelOptions(VehicleModel[] data) {
        Arrays.stream(data).forEach(m -> System.out.println("Code: " + m.code() + " Description: " + m.name()));
    }

    public void displayVehiclePriceOptions(VehiclePrice[] data) {
        Arrays.stream(data).forEach(p -> System.out.println("Brand: " + p.brand() + " Value: " + p.value() + " Model: " + p.model() + " Year: " + p.year() + " FuelType: " + p.fuelType()));
    }
}
