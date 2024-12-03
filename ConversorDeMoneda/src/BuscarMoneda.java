
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscarMoneda {
    public static double tasaCambio(String monedaBase, String monedaDestino) {

        String direccion = "https://v6.exchangerate-api.com/v6/2d6fbc3d64e8489d29eb3d74/pair/" + monedaBase + "/" + monedaDestino;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);

            // Convertir el JSON a un objeto ApiResponse usando Gson
            ApiResponse apiResponse = new Gson().fromJson(json, ApiResponse.class);

            if ("success".equals(apiResponse.getResult())) {
                return apiResponse.getConversionRate();
            } else {
                System.out.println("Error en la API: " + apiResponse.getResult());
                return -1;
            }

        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }
}

