package weather;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeatherImplementation {
    public static void main(String[] args) {
       /* FileResource fr = new FileResource();
        singleDayColdest(fr);*/
        filewithcoldestDay();
    }

    private static DayWeather singleDayColdest(FileResource fr) {
        List<DayWeather> weathers = generateList(fr);
        //coldestHourInFile(weathers);
        Collections.sort(weathers);
        while(weathers.get(0).compareTemperature(new DayWeather("0.0","","")) < 0 ) weathers.remove(0);
        return weathers.get(0);
    }

    private static List<DayWeather> generateList(FileResource fr) {
        CSVParser cv = fr.getCSVParser();
        List<DayWeather> weathers = new ArrayList<>();
        for (CSVRecord record : cv) {
            String Temperature = record.get("TemperatureF");
            String humidity = record.get("Humidity");

            String dateUTC = record.get("DateUTC");
            {
                DayWeather dayWeather = new DayWeather(
                        Temperature, humidity, dateUTC
                );

                weathers.add(dayWeather);
            }
            //record.toString();
        }
        return weathers;
    }

    public static void  coldestHourInFile(List<DayWeather> storageResource) {
         Collections.sort(storageResource);
         System.out.println(storageResource.get(0).toString() + " " + storageResource.get(storageResource.size()-1).toString());
     }

     public static void filewithcoldestDay() {
         DirectoryResource directoryResource = new DirectoryResource();
         DayWeather lowest = null;
         for (File f : directoryResource.selectedFiles()) {
             FileResource fr = new FileResource(f);
             DayWeather temp = singleDayColdest(fr);
             temp.toString();
             averageTempWithHighHumidityThan(fr,80.0);
             System.out.println(averageTempInFile(fr));
             if (lowest == null ) {
                 lowest = temp;
             }else {
                 if(lowest.compareTemperature(temp) > 0) {
                     lowest = temp;
                 }
             }

         }

         lowest.toString();
     }
     private static void averageTempWithHighHumidityThan(FileResource fr, double value) {
        List<DayWeather> weathers = generateList(fr);
        double sum =0;
        int count =0;
        for(DayWeather dayWeather : weathers) {
            if (dayWeather.compareHumidity(new DayWeather("","80",""))>0) {
                sum += Double.parseDouble(dayWeather.Humidity);
                count++;
            }
        }
        System.out.println(sum/count);
     }
     private static double averageTempInFile(FileResource fr) {
        List<DayWeather> files = generateList(fr);
        double total =0;
        for (DayWeather df : files){
            total+= Double.parseDouble(df.TemperatureF);
        }
        return total/files.size();
     }

}
