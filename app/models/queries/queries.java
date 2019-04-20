package models.queries;

import com.fasterxml.jackson.databind.JsonNode;
import models.DevSchedForm;
import models.PassengersCountForm;
import models.queries.passengersCount.passengersCountQueryHandler;
import models.queries.devSched.devSchedQueryHandler;
import models.queries.stations.stationsQueryHandler;
import play.libs.Json;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class queries {

    static JsonNode stations = null;
    public static ObjectMapper mapper = new ObjectMapper();


    public static JsonNode getStations(){
//        return readJsonFromFile("stations");
        stationsQueryHandler handler = new stationsQueryHandler();
        return handler.getResults();
    }

    public static JsonNode getStationsByCity(String city){
        stationsQueryHandler handler = new stationsQueryHandler();
        handler.setCity(city);
        return handler.getResults();
    }

    /* VISUALIZATIONS */
    public static JsonNode getResults(PassengersCountForm form){
        passengersCountQueryHandler handler = new passengersCountQueryHandler(form);
        return handler.getResult();
       // return readJsonFromFile("passengersCount");
    }

    public static JsonNode getResults(DevSchedForm form){
         devSchedQueryHandler handler = new devSchedQueryHandler(form);
         return handler.getResult();
        //return readJsonFromFile("devSched");
    }

    /* for demo files */
    private static JsonNode readJsonFromFile(String fileName){
        try {
            File initialFile = new File("app/models/queries/"+fileName+".json");
            InputStream targetStream = new FileInputStream(initialFile);
            return Json.parse(targetStream);
        } catch (IOException e) {
            return null;
        }
    }

}
