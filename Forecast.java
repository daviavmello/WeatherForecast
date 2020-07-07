import java.util.Scanner;

public class Forecast {
    Scanner scnr = new Scanner(System.in);

    private double temperature;
    private String skyCondition;
    private int rainPercent;

// Still unsure whether these constructors are useful. My solution to this problem might be less efficient

    public Forecast() {
    
    }

    public Forecast(double userTemp) {
        temperature = userTemp;
    }
    
    public Forecast(String userSkyCondition) {
        skyCondition = userSkyCondition;
    }
    
    public Forecast(int userRainPercent) {
        rainPercent = userRainPercent;
    }
    
    public void setTemperature(double userTemp) { 
        if (userTemp >= -100 && userTemp <= 150) {
            temperature = userTemp;
        }

        else {
            temperature = 72;
        }
    }

    public void setSkyCondition(String userSkyCondition) {
        userSkyCondition = scnr.nextLine();
        if (userSkyCondition.length() == 0) {
            skyCondition = "clear";
        }
        else {
            skyCondition = userSkyCondition;
        }
    }

    public void setChanceOfRain(int userRainPercent) {
        if ((userRainPercent >= 0) && (userRainPercent <= 100)) {
            rainPercent = userRainPercent;
        }
        else {
            rainPercent = 0;
        }
        
    } 

    public void tempUnit(char userUnit) {
        while ((userUnit != 'K') && (userUnit != 'C') && (userUnit != 'F')) {

            System.out.println("Choose between K, C, or F. (Capitalization matters!)");
            userUnit = scnr.next().charAt(0);
        }
    } 

    // A parameter indicates that the value will be passed in as an argument, whereas a locally declared variable is probably set inside the method

    public Double KToC(double kToCTemperature) {
        return kToCTemperature += (-273);
    }

    public Double KToF(double kToFTemperature) {
        return kToFTemperature = (kToFTemperature * (9/5)) - 459.67;
    }

    public Double CToF(double cToFTemperature) {
        return (cToFTemperature * 1.8) + 32;
    }

    public Double CToK(double cToKTemperature) { 
        return cToKTemperature += (273.15);
    }

    public Double FToC(double fToCTemperature) {
        return (fToCTemperature - 32) * 5/9;
    }

    public Double FToK(double fToKTemperature) {;
        return (fToKTemperature - 32) * 5/9 + 273;
    }

    // If it's a return method, there is a need to specify what type of return it will be. In this case, it's a "Boolean" type.
    public Boolean willItRain(int userRainPercent) {
        boolean chanceOfRain = false;

        if (userRainPercent > 50) {
            chanceOfRain = true;
        }
        return chanceOfRain;
    }

    // Getters
    public Double getTemperature() {
        return temperature;
    }

    public String getSkyCondition() {
        return skyCondition;
    }

    public Integer getRainPercentage() {
        return rainPercent;
    }

    // Creates print(char, double) method to output correct temperature conversion 
    public void printTemp(char userUnit, double userTemp) {
        if (userUnit == 'K') {
            System.out.println("Temperature in Celsius is: " + KToC(userTemp));
            System.out.println("Temperature in Farenheit is: " + KToF(userTemp));
        } 

        else if (userUnit == 'C') {
            System.out.println("Temperature in Farenheit is: " + CToF(userTemp));
            System.out.println("Temperature in Kelvin is: " + CToK(userTemp));
        }

        else if (userUnit == 'F') {
            System.out.println("Temperature in Celsius is: " + FToC(userTemp));
            System.out.println("Temperature in Kelvin is: " + FToK(userTemp));
        }
    }
}