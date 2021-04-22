package weather;

import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class WeatherUtil {
    private File file;
    private HashMap<Integer,WeatherData> hmap;
    public WeatherUtil(String path) throws FileNotFoundException {
        //stores a year for the key and a instance of WeatherData for the value
        this.hmap = new HashMap<Integer,WeatherData>();

        this.file = new File(path);
        Scanner scan = new Scanner(file);
        String line = scan.nextLine();
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            Scanner wordScan = new Scanner(line);
            wordScan.useDelimiter(",");
            wordScan.next();
            wordScan.next();
            wordScan.next();
            String period = wordScan.next();
            int idx = period.indexOf(" ");
            String month = period.substring(0, idx);
            String year = period.substring(idx + 1);
            WeatherData yearData = hmap.get(Integer.parseInt(year));
            if(yearData == null) {
                yearData = new WeatherData(Integer.parseInt(year));
                hmap.put(Integer.parseInt(year),yearData);
            }
            int monthIdx = 0;
            switch (month) {
                case "Jan":
                    monthIdx = 0;
                    break;
                case "Feb":
                    monthIdx = 1;
                    break;
                case "Mar":
                    monthIdx = 2;
                    break;
                case "Apr":
                    monthIdx = 3;
                    break;
                case "May":
                    monthIdx = 4;
                    break;
                case "Jun":
                    monthIdx = 5;
                    break;
                case "Jul":
                    monthIdx = 6;
                    break;
                case "Aug":
                    monthIdx = 7;
                    break;
                case "Sep":
                    monthIdx = 8;
                    break;
                case "Oct":
                    monthIdx = 9;
                    break;
                case "Nov":
                    monthIdx = 10;
                    break;
                case "Dec":
                    monthIdx = 11;
                    break;
            }
            yearData.setTempHigh(monthIdx, Double.valueOf(wordScan.next()));
            yearData.setTempLow(monthIdx, Double.valueOf(wordScan.next()));
            yearData.setAvgTemp(monthIdx, Double.valueOf(wordScan.next()));
            wordScan.next();
            wordScan.next();
            yearData.setPrecipitation(monthIdx, Double.valueOf(wordScan.next()));
            wordScan.next();
            wordScan.next();
            wordScan.next();
            wordScan.next();
            yearData.setCloudCover(monthIdx, Double.valueOf(wordScan.next()));
        }
    }

    public HashMap<Integer,WeatherData> getMap() {
        return hmap;
    }

    public WeatherData getYearData(int year) {
        return hmap.get(year);
    }
}
