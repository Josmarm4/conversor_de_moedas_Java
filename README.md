# 💱 Conversor de Moedas em Java

![Badge](https://img.shields.io/badge/Java-17-blue.svg)
![Badge](https://img.shields.io/badge/ExchangeRateAPI-integrado-green.svg)
![Badge](https://img.shields.io/badge/Status-Concluído-brightgreen.svg)

## 📖 Descrição

Este projeto é um conversor de moedas desenvolvido em Java que utiliza a [ExchangeRate API](https://www.exchangerate-api.com/) para obter taxas de câmbio atualizadas em tempo real. A aplicação roda no terminal e permite converter valores entre diferentes moedas de forma prática e eficiente, além de salvar os dados em um arquivo `.json` localmente.

## 🚀 Funcionalidades

- Conversão entre:
  - Dólar ⇄ Peso argentino
  - Dólar ⇄ Real brasileiro
  - Dólar ⇄ Peso colombiano
- Consumo da ExchangeRate API para dados atualizados.
- Validação de entradas e tratamento de erros.
- Exportação das taxas de câmbio em formato JSON.
- Interface simples via terminal.

## 📦 Pré-requisitos

Antes de rodar o projeto, você precisa ter instalado:

- [Java JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- Conexão com a internet
- Chave de API gratuita da [ExchangeRate API](https://www.exchangerate-api.com/)

## 🛠️ Instalação e execução

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/conversor-moedas-java.git
   cd conversor-moedas-java
   ```
2. Substitua a chave da API no arquivo CurrencyApiClient.java
   ```
   private static final String API_KEY = "SUA_CHAVE_AQUI";
   ```
3. Compile os arquivos (certifique-se de que gson.jar está na mesma pasta):

  ```bash
  javac -cp gson-2.10.1.jar *.java
  ```
4. Execute a aplicação:
   ```bash
   java -cp .:gson-2.10.1.jar CurrencyConverterApp
   ```
   
   OBS: no Windows use ; em vez de : no classpath:
   
   ```
   java -cp .;gson-2.10.1.jar CurrencyConverterApp
   ```
   
# 💡 Como usar
- Ao iniciar, o programa exibe um menu com opções de conversão.

- Selecione uma opção (1 a 6) e insira o valor que deseja converter.

- O resultado será exibido no terminal.

- Os dados da conversão são salvos como JSON na pasta data.

# 🧰 Tecnologias utilizadas
- Java 21

- ExchangeRate API

- Gson (para manipulação de JSON)

- Java HTTP Client (java.net.http)

# 📂 Estrutura do Projeto
```
.
├── src
│   └── main
│       └── java
│           ├── CurrencyApiClient.java
│           ├── CurrencyConverter.java
│           ├── CurrencyConverterApp.java
│           ├── CurrencyDataExporter.java
│           └── ExchangeRateData.java
```
# 🤝 Contribuições
Contribuições são bem-vindas! Se você quiser corrigir bugs, melhorar o código ou adicionar novas funcionalidades, sinta-se à vontade para abrir uma issue ou enviar um pull request.

# 📄 Licença
Este projeto está licenciado sob a MIT License.

# 📬 Contato
Caso tenha dúvidas ou sugestões, entre em contato via josmarmiguel855@gmail.com.

