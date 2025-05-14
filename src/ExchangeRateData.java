import java.util.Map;

public record ExchangeRateData(String result, String base_code, Map<String, Double> conversion_rates) {}
