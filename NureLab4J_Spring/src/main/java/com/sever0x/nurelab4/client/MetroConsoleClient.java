package com.sever0x.nurelab4.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sever0x.nurelab4.model.BranchStation;
import com.sever0x.nurelab4.model.Station;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class MetroConsoleClient {

    private static final String BASE_URL = "http://localhost:8080";

    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;

    public MetroConsoleClient() {
        this.httpClient = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public static void main(String[] args) {
        MetroConsoleClient client = new MetroConsoleClient();
        client.run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Оберіть опцію:");
            System.out.println("1. Отримати всі станції");
            System.out.println("2. Отримати станцію за ID");
            System.out.println("3. Додати нову станцію");
            System.out.println("4. Оновити інформацію про станцію");
            System.out.println("5. Видалити станцію");
            System.out.println("0. Вийти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> getAllStations();
                case 2 -> getStationById(scanner);
                case 3 -> addStation(scanner);
                case 4 -> updateStation(scanner);
                case 5 -> deleteStation(scanner);
                case 0 -> System.exit(0);
                default -> System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    private void getAllStations() {
        Request request = new Request.Builder()
                .url(BASE_URL + "/stations")
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                List<Station> stations = Arrays.asList(objectMapper.readValue(response.body().string(), Station[].class));
                stations.forEach(System.out::println);
            } else {
                System.out.println("Помилка при отриманні станцій. HTTP-код: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getStationById(Scanner scanner) {
        System.out.print("Введіть ID станції: ");
        int stationId = scanner.nextInt();
        scanner.nextLine();

        Station station = getStationByIdRequest(stationId);
        System.out.println(station);
    }

    private Station getStationByIdRequest(int stationId) {
        Request request = new Request.Builder()
                .url(BASE_URL + "/stations/" + stationId)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return objectMapper.readValue(response.body().string(), Station.class);
            } else {
                System.out.println("Помилка при отриманні станції. HTTP-код: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void addStation(Scanner scanner) {
        System.out.print("Введіть назву станції: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("Назва станції не може бути порожньою.");
            return;
        }

        System.out.print("Введіть місто: ");
        String city = scanner.nextLine();
        if (city.isEmpty()) {
            System.out.println("Місто не може бути порожнім.");
            return;
        }

        System.out.print("Введіть лінію: ");
        String line = scanner.nextLine();
        if (line.isEmpty()) {
            System.out.println("Лінія не може бути порожньою.");
            return;
        }

        System.out.print("Введіть наступну станцію (або залиште порожнім): ");
        String nextStationName = scanner.nextLine();
        BranchStation nextStation = nextStationName.isEmpty() ? null : new BranchStation(nextStationName);

        System.out.print("Введіть попередню станцію (або залиште порожнім): ");
        String prevStationName = scanner.nextLine();
        BranchStation prevStation = prevStationName.isEmpty() ? null : new BranchStation(prevStationName);

        System.out.print("Введіть перехідну станцію (або залиште порожнім): ");
        String transferToName = scanner.nextLine();
        BranchStation transferTo = transferToName.isEmpty() ? null : new BranchStation(transferToName);

        Station newStation = Station.builder()
                .id(0)
                .name(name)
                .city(city)
                .line(line)
                .nextStation(nextStation)
                .prevStation(prevStation)
                .transferTo(transferTo)
                .build();

        try {
            String requestBody = objectMapper.writeValueAsString(newStation);
            RequestBody body = RequestBody.create(requestBody, MediaType.parse("application/json"));

            Request request = new Request.Builder()
                    .url(BASE_URL + "/stations")
                    .post(body)
                    .build();

            try (Response response = httpClient.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    Station createdStation = objectMapper.readValue(response.body().string(), Station.class);
                    System.out.println("Станція успішно додана:");
                    System.out.println(createdStation);
                } else {
                    System.out.println("Помилка при додаванні станції. HTTP-код: " + response.code());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateStation(Scanner scanner) {
        System.out.print("Введіть ID станції для оновлення: ");
        int stationId = scanner.nextInt();
        scanner.nextLine();

        Station currentStation = getStationByIdRequest(stationId);

        if (currentStation == null) {
            System.out.println("Станція з таким ID не існує.");
            return;
        }

        System.out.print("Введіть нову назву станції (або залиште порожнім): ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            name = currentStation.getName();
        }

        System.out.print("Введіть нове місто (або залиште порожнім): ");
        String city = scanner.nextLine();
        if (city.isEmpty()) {
            city = currentStation.getCity();
        }

        System.out.print("Введіть нову лінію (або залиште порожнім): ");
        String line = scanner.nextLine();
        if (line.isEmpty()) {
            line = currentStation.getLine();
        }

        System.out.print("Введіть нову наступну станцію (або залиште порожнім): ");
        String nextStationName = scanner.nextLine();
        BranchStation nextStation = nextStationName.isEmpty() ? currentStation.getNextStation() : new BranchStation(nextStationName);

        System.out.print("Введіть нову попередню станцію (або залиште порожнім): ");
        String prevStationName = scanner.nextLine();
        BranchStation prevStation = prevStationName.isEmpty() ? currentStation.getPrevStation() : new BranchStation(prevStationName);

        System.out.print("Введіть нову перехідну станцію (або залиште порожнім): ");
        String transferToName = scanner.nextLine();
        BranchStation transferTo = transferToName.isEmpty() ? currentStation.getTransferTo() : new BranchStation(transferToName);

        Station updatedStation = Station.builder()
                .id(stationId)
                .name(name)
                .city(city)
                .line(line)
                .nextStation(nextStation)
                .prevStation(prevStation)
                .transferTo(transferTo)
                .build();

        try {
            String requestBody = objectMapper.writeValueAsString(updatedStation);
            RequestBody body = RequestBody.create(requestBody, MediaType.parse("application/json"));

            Request request = new Request.Builder()
                    .url(BASE_URL + "/stations/" + stationId)
                    .patch(body)
                    .build();

            try (Response response = httpClient.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    Station updated = objectMapper.readValue(response.body().string(), Station.class);
                    System.out.println("Станція успішно оновлена:");
                    System.out.println(updated);
                } else {
                    System.out.println("Помилка при оновленні станції. HTTP-код: " + response.code());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteStation(Scanner scanner) {
        System.out.print("Введіть ID станції для видалення: ");
        int stationId = scanner.nextInt();
        scanner.nextLine();

        Request request = new Request.Builder()
                .url(BASE_URL + "/stations/" + stationId)
                .delete()
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                System.out.println("Станція успішно видалена");
            } else {
                System.out.println("Помилка при видаленні станції. HTTP-код: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
