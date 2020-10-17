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
            //enters each line
            Scanner wordScan = new Scanner(line);
            wordScan.useDelimiter(",");
            //gets rid of location
            wordScan.next();
            wordScan.next();
            wordScan.next();
            //period
            String period = wordScan.next();
            int idx = period.indexOf(" ");
            String month = period.substring(0, idx);
            //System.out.println(month);
            String year = period.substring(idx + 1);
            //yearData creates an instance of WeatherData
            //WeatherData yearData = new WeatherData(Integer.parseInt(year));
            WeatherData yearData = hmap.get(Integer.parseInt(year));
            if(yearData == null) {
                yearData = new WeatherData(Integer.parseInt(year));
                hmap.put(Integer.parseInt(year),yearData);
            }
            //System.out.println(Integer.parseInt(year));
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
            //max temp
            yearData.setTempHigh(monthIdx, Double.valueOf(wordScan.next()));
            //System.out.println("maxtemp:" + wordScan.next());
            //min temp
            yearData.setTempLow(monthIdx, Double.valueOf(wordScan.next()));
            //System.out.println("mintemp:" + wordScan.next());
            //avg temp
            yearData.setAvgTemp(monthIdx, Double.valueOf(wordScan.next()));
            //System.out.println(yearData.getAvgTemp()[1]);
            //System.out.println( Double.valueOf(wordScan.next()));
            //System.out.println("avg temp:" + wordScan.next());
            //wind chill
            wordScan.next();
            //System.out.println("windchill:" + wordScan.next());
            //heat index
            wordScan.next();
            //System.out.println("heat index:" + wordScan.next());
            //precipitation
            yearData.setPrecipitation(monthIdx, Double.valueOf(wordScan.next()));
            //System.out.println("precipitation:" + wordScan.next());
            //snow depth
            wordScan.next();
            //System.out.println("snow depth:" + wordScan.next());
            //wind speed
            wordScan.next();
            //System.out.println("wind speed:" + wordScan.next());
            //wind gust
            wordScan.next();
            //System.out.println("wind gust:" + wordScan.next());
            //visibility
            wordScan.next();
            //System.out.println("visibility:" + wordScan.next());
            //cloud cover
            yearData.setCloudCover(monthIdx, Double.valueOf(wordScan.next()));
            //System.out.println("cloud cover:" + wordScan.next());
            //hmap.put(Integer.parseInt(year), yearData);
            //System.out.println("new line");
        }
    }

    public HashMap<Integer,WeatherData> getMap() {
        return hmap;
    }

    public WeatherData getYearData(int year) {
        //System.out.println(hmap.get(2002).getAvgTemp()[0]);
        /*for(int i=0; i <hmap.get(2002).getAvgTemp().length; i++) {
            System.out.println(hmap.get(2002).getAvgTemp()[i]);
        }*/
        return hmap.get(year);
    }
}
