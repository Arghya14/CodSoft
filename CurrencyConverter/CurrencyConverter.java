import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private Map<String, Double> exchangeRates;

    public CurrencyConverter() {

        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);    // Base currency (US Dollar)
        exchangeRates.put("EUR", 0.86);   // Euro
        exchangeRates.put("GBP", 0.74);   // British Pound
        exchangeRates.put("JPY", 109.78); // Japanese Yen
        exchangeRates.put("CAD", 1.26);   // Canadian Dollar
        exchangeRates.put("AUD", 1.35);   // Australian Dollar
        exchangeRates.put("INR", 73.92);  // Indian Rupee
        exchangeRates.put("CNY", 6.44);   // Chinese Yuan
    }

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        if (exchangeRates.containsKey(fromCurrency) && exchangeRates.containsKey(toCurrency)) {
            double fromRate = exchangeRates.get(fromCurrency);
            double toRate = exchangeRates.get(toCurrency);
            return amount * (toRate / fromRate);
        } else {
            System.out.println("Invalid currency codes.");
            return -1.0;
        }
    }

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Currency Converter");
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the source currency code (e.g., USD): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency code (e.g., EUR): ");
        String toCurrency = scanner.next().toUpperCase();

        double convertedAmount = converter.convertCurrency(amount, fromCurrency, toCurrency);

        if (convertedAmount != -1.0) {
            System.out.println(amount + " " + fromCurrency + " is equal to " + convertedAmount + " " + toCurrency);
        }
    }
}
