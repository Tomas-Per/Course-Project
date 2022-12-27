package lt.vu.courseproject.stockexpertsystem.utils;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import lt.vu.courseproject.stockexpertsystem.models.indicator.Indicator;
import lt.vu.courseproject.stockexpertsystem.models.stock.Info;
import lt.vu.courseproject.stockexpertsystem.models.stock.Stock;
import lt.vu.courseproject.stockexpertsystem.models.stock.StockWeeklySeries;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AlphaVantageUtility {

    String baseApiUrl = "https://www.alphavantage.co/query?function=";
    Gson gson = new Gson();

    public Stock getStockFromAV(String ticker) {
        Stock stock = new Stock();
        try {
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(
                        URI.create(baseApiUrl + "TIME_SERIES_WEEKLY&symbol="+ ticker + "&apikey=" + System.getenv("alphaVantageApiKey")))
                .header("accept", "application/json")
                .build();

            HttpResponse<String> response = null;
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            LinkedTreeMap<String, LinkedTreeMap> data = gson.fromJson(response.body(), LinkedTreeMap.class);

            stock.setTicker(data.get("Meta Data").get("2. Symbol").toString());

            List<StockWeeklySeries> swsList = new ArrayList<>();
            for (Object dateInfo : data.get("Weekly Time Series").entrySet()) {
                LinkedTreeMap map = ((Map.Entry<String, LinkedTreeMap>) dateInfo).getValue();

                StockWeeklySeries stockWeeklySeries = new StockWeeklySeries();
                stockWeeklySeries.setDate(((Map.Entry<String, LinkedTreeMap>) dateInfo).getKey());
                Info info = new Info(
                        Double.parseDouble(map.get("1. open").toString()),
                        Double.parseDouble(map.get("2. high").toString()),
                        Double.parseDouble(map.get("3. low").toString()),
                        Double.parseDouble(map.get("4. close").toString()),
                        Integer.parseInt(map.get("5. volume").toString())
                );
                stockWeeklySeries.setInfo(info);
                swsList.add(stockWeeklySeries);
            }
            stock.setSeries(swsList);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return stock;
    }

}
