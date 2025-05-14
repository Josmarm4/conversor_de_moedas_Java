import java.util.Scanner;

public class CurrencyConverterApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CurrencyApiClient apiClient = new CurrencyApiClient();
        CurrencyDataExporter fileGenerator = new CurrencyDataExporter();

        int option;
        do {
            printMenu();
            option = input.nextInt();
            input.nextLine(); // Consome a quebra de linha

            try {
                switch (option) {
                    case 1:
                        convertAndShow(apiClient, "USD", "ARS", input);
                        break;
                    case 2:
                        convertAndShow(apiClient, "ARS", "USD", input);
                        break;
                    case 3:
                        convertAndShow(apiClient, "USD", "BRL", input);
                        break;
                    case 4:
                        convertAndShow(apiClient, "BRL", "USD", input);
                        break;
                    case 5:
                        convertAndShow(apiClient, "USD", "COP", input);
                        break;
                    case 6:
                        convertAndShow(apiClient, "COP", "USD", input);
                        break;
                    case 0:
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (RuntimeException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }

            if (option != 0) {
                System.out.println("\nPressione Enter para continuar...");
                input.nextLine();
            }
        } while (option != 0);

        input.close();
    }

    private static void printMenu() {
        System.out.println("""
            **************************************************
            ----- Seja Bem-Vindo/a ao Conversor de Moeda -----
            **************************************************
            
            1) Dólar --> Peso argentino
            2) Peso argentino --> Dolar
            3) Dólar --> Real brasileiro
            4) Real brasileiro --> Dólar
            5) Dólar --> Peso colombiano
            6) Peso colombiano --> Dólar
            0) Sair.
            **************************************************
            Escolha uma opção válida:
            """);
    }

    private static void convertAndShow(CurrencyApiClient apiClient, String fromCurrency, String toCurrency, Scanner input) {
        System.out.printf("\nDigite o valor em %s: ", fromCurrency);
        double amount = input.nextDouble();
        input.nextLine(); // Consome a quebra de linha

        ExchangeRateData response = apiClient.getExchangeRates(fromCurrency);
        double result = CurrencyConverter.convert(amount, fromCurrency, toCurrency, response);

        System.out.printf("\n%.2f %s = %.2f %s\n", amount, fromCurrency, result, toCurrency);
    }
}
