import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CurrencyDataExporter {

    public void salvaJson(ExchangeRateData endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String filename = endereco.base_code() + "_exchange_rates.json";

        // Cria diretório se não existir
        new File("data").mkdirs();

        try (FileWriter escrita = new FileWriter("data/" + filename)) {
            escrita.write(gson.toJson(endereco));
        }
    }
}
