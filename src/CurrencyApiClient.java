import com.google.gson.Gson;
import java.net.URI;
import java.net.http.*;
import java.util.Objects;

public class CurrencyApiClient {
    private static final String API_KEY = "SUA_CHAVE_AQUI"; // Substitua pela sua chave real

    public ExchangeRateData getExchangeRates(String baseCurrency) {
        // Verifica se a moeda base é válida
        Objects.requireNonNull(baseCurrency, "Moeda base não pode ser nula");
        if (baseCurrency.length() != 3) {
            throw new IllegalArgumentException("Código da moeda deve ter 3 caracteres");
        }
        if (API_KEY == null || API_KEY.isEmpty()) {
            throw new IllegalStateException("Chave API não configurada");
        }

        // Constrói a URI de forma segura
        String url = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s",
                API_KEY, baseCurrency);

        try {
            URI endpoint = URI.create(url);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(endpoint)
                    .build();

            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            ExchangeRateData apiResponse = new Gson().fromJson(response.body(), ExchangeRateData.class);

            if (!apiResponse.result().equals("success")) {
                throw new RuntimeException("API retornou erro: " + apiResponse.result());
            }

            return apiResponse;
        } catch (Exception e) {
            throw new RuntimeException("Falha ao obter taxas de câmbio: " + e.getMessage(), e);
        }
    }
}