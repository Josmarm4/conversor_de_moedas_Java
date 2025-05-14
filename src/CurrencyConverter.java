public class CurrencyConverter {
        public static double convert(double amount, String fromCurrency,
                                     String toCurrency, ExchangeRateData exchangeData) {

            // Verifica se as moedas existem nos dados
            if (!exchangeData.conversion_rates().containsKey(fromCurrency)) {
                throw new IllegalArgumentException("Moeda de origem não suportada: " + fromCurrency);
            }
            if (!exchangeData.conversion_rates().containsKey(toCurrency)) {
                throw new IllegalArgumentException("Moeda de destino não suportada: " + toCurrency);
            }

            // Obtém as taxas de câmbio
            double fromRate = exchangeData.conversion_rates().get(fromCurrency);
            double toRate = exchangeData.conversion_rates().get(toCurrency);

            // Calcula o valor convertido
            return amount * (toRate / fromRate);
        }
}
