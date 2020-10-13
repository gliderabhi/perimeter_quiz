package weather;

public class DayWeather implements Comparable<DayWeather> {
   String TemperatureF,Humidity,DateUTC;

    public DayWeather( String temperatureF, String humidity, String dateUTC) {
        TemperatureF = temperatureF;
        Humidity = humidity;
        DateUTC = dateUTC;
    }

    @Override
    public String toString() {
        String val= "DayWeather{" +
                "  TemperatureF='" + TemperatureF + '\'' +
                ", Humidity='" + Humidity + '\'' +
                ", DateUTC='" + DateUTC + '\'' +
                '}';
        System.out.println(val);
        return val;
    }

    public int compareTemperature(DayWeather weather) {
        return Double.compare( Double.parseDouble(this.TemperatureF) ,Double.parseDouble(weather.TemperatureF));
    }
    public int compareHumidity(DayWeather weather) {
        return Double.compare( Double.parseDouble(this.Humidity) ,Double.parseDouble(weather.Humidity));
    }

    @Override
    public int compareTo(DayWeather o) {
        return compareTemperature(o);
    }
}
