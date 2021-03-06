package app.stock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.IOException;

import static app.Application.stockDao;
import static app.util.JsonUtil.dataToJson;

public class StockController {

    public static Route fetchAllStocks = (Request request, Response response) -> dataToJson(stockDao.getAllStocks());

    public static Object createAStock(Request req, Response res) throws IOException {
        String json = req.body();
        ObjectMapper mapper = new ObjectMapper();
        ObjectReader reader = mapper.reader(Stock.class).withRootName("stock");
        Stock stock = reader.readValue(json);

        return dataToJson(stockDao.createStock(stock));
    }

//    public static Object updateAStock(Request req, Response res) throws IOException {
//        Set name = req.attributes();
//        System.out.println(req.body());
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        Stock stock = objectMapper.readValue(req.body(), Stock.class);
//
//        return dataToJson(stockDao.updateStock(stock));
//    }
//    public static Object deleteAStock(Request req, Response res) throws IOException {
//        Set name = req.attributes();
//        System.out.println(req.body());
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        Stock stock = objectMapper.readValue(req.body(), Stock.class);
//
//        return dataToJson(stockDao.deleteStock(stock));
//    }
}
