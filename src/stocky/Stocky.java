package stocky;

import analyser.LogisticSimplePredictor;
import analyser.StockPredictor;
import dataloader.StockDataLoader;
import dataloader.YahooStockLoader;
import org.joda.time.LocalDate;
import stock.Stock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erik on 04/03/14.
 */
public class Stocky {

    public static final boolean DEBUG = true;

    public static void main(String[] args) {

        List<String> symbols = new ArrayList<String>();
        symbols.add("AAPL");
        symbols.add("%5EOMX");
        LocalDate start = LocalDate.parse("2000-01-01");
        LocalDate end = LocalDate.parse("2014-03-05");
        StockDataLoader loader = new YahooStockLoader(symbols, start, end);
        List<Stock> stocks = loader.getStockList();
        for (Stock stock : stocks) {
            StockPredictor predictor = new LogisticSimplePredictor(stock);
            System.out.println(stock.getName() + ": " + predictor.prediction());
            System.out.println(predictor.toString());
        }

    }

}
