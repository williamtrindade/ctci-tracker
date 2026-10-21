package CTCI91StockData;

import java.time.LocalDate;

public record StockRecord(String symbol, LocalDate date, double open, double close, double high, double low) {
}
