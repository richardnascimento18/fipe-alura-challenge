package br.com.alura.FipeTableChallenge.main;

import br.com.alura.FipeTableChallenge.models.*;
import br.com.alura.FipeTableChallenge.services.ConvertData;
import br.com.alura.FipeTableChallenge.services.Menu;
import br.com.alura.FipeTableChallenge.services.SearchAPI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private final Scanner reader = new Scanner(System.in);
    private final SearchAPI searchAPI = new SearchAPI();
    private final ConvertData convertData = new ConvertData();
    private final Menu menu = new Menu();
    private int option = 0;
    private String vehicleModel = null;
    private String chosenVehicle = null;

    public void showMenu() {
        HashMap<Integer, String> availableOpts = new HashMap<>();
        availableOpts.put(1, "carros");
        availableOpts.put(2, "motos");
        availableOpts.put(3, "caminhoes");

        this.menu.displayMenuOptions();

        while(!availableOpts.containsKey(option)) {
            System.out.println("Enter your Chosen Option: ");
            this.option = reader.nextInt();
        }

        String vehicleType = availableOpts.get(option);
        String json = this.searchAPI.searchType(vehicleType);
        Brand[] data = this.convertData.getData(json, Brand[].class);

        HashMap<String, String> availableModels = new HashMap<>();
        Arrays.stream(data).forEach(b -> availableModels.put(b.code(), b.name()));

        this.menu.displayBrandOptions(data);

        while(!availableModels.containsKey(vehicleModel)) {
            System.out.println("Enter the Code of the Chosen Vehicle Model: ");
            this.vehicleModel = reader.nextLine();
        }

        String vehicleModelJson = this.searchAPI.searchModel(this.vehicleModel);
        VehicleModelObject vehicleModelData = this.convertData.getData(vehicleModelJson, VehicleModelObject.class);
        VehicleModel[] vehicleModels = vehicleModelData.models().toArray(new VehicleModel[0]);

        HashMap<String, String> availableVehicleYears = new HashMap<>();
        Arrays.stream(vehicleModels).forEach(m -> availableVehicleYears.put(m.code(), m.name()));

        this.menu.displayVehicleModelOptions(vehicleModels);

        String[] matchedCodeKey = null;

        while (matchedCodeKey == null) {
            System.out.println("Enter the Name of the Chosen Vehicle: ");
            String input = reader.nextLine();

            matchedCodeKey = availableVehicleYears.entrySet().stream()
                    .filter(e -> e.getValue().toLowerCase().contains(input.toLowerCase()))
                    .map(Map.Entry::getKey)
                    .toArray(String[]::new);

            if (Arrays.stream(matchedCodeKey).anyMatch(e -> e.equals(input.toLowerCase()))) {
                System.out.println("Vehicle not found. Try again.");
            }
        }

        Arrays.stream(matchedCodeKey).forEach(k -> System.out.println("Code: " + k + " Description: " + availableVehicleYears.get(k)));

        while(!availableVehicleYears.containsKey(this.chosenVehicle)) {
            System.out.println("Please, enter the code of the Vehicle you wish to search a price table: ");
            this.chosenVehicle = reader.nextLine();
        }

        String vehicleYearJson = this.searchAPI.searchYear(this.chosenVehicle);
        VehicleYear[] vehicleYearsData = this.convertData.getData(vehicleYearJson, VehicleYear[].class);
        String[] pricesJson = Arrays.stream(vehicleYearsData).map(vehicleYear -> this.searchAPI.searchPrice(vehicleYear.code())).toArray(String[]::new);

        VehiclePrice[] vehiclePrices = Arrays.stream(pricesJson).map(priceJson -> this.convertData.getData(priceJson, VehiclePrice.class)).toArray(VehiclePrice[]::new);

        this.menu.displayVehiclePriceOptions(vehiclePrices);
    }
}
