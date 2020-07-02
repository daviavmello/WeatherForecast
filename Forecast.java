import java.util.Scanner;

public class Forecast {
    Scanner scnr = new Scanner(System.in);

    // Do these must be private?
    public double temperature;
    public String skyCondition;
    public int rainPercent;

    // I'm unsure if this is a functional constructor.
    public Forecast(double userTemp) {
       temperature = userTemp;
    }

    public Forecast(String userSkyCondition) {
        skyCondition = userSkyCondition;
    }

    public void setTemperature(double userTemp) {
        // Check later on if Forecast constructor can be called within this method.
        
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

    // Using a static method so we don't need to create an object to access it (even though I'm using a Scanner).
    public static void tempUnit(char userUnit) {
        // Why do I need to create a new Scanner object inside this method? Code will break if I get rid of it and refer to the global Scanner object.
        Scanner scnr = new Scanner(System.in);

        while ((userUnit != 'K') && (userUnit != 'C') && (userUnit != 'F')) {

            System.out.println("Choose between K, C, or F. (Capitalization matters!)");
            userUnit = scnr.next().charAt(0);
        }
    } 

    // What's the difference between declaring a variable as an argument vs declaring within the method?
    public static Double KToC(double kToCTemperature) {
        return kToCTemperature += (-273);
    }

    public static Double KToF(double kToFTemperature) {
        return kToFTemperature = (kToFTemperature * (9/5)) - 459.67;
    }

    public static Double CToF(double cToFTemperature) {
        return (cToFTemperature * 1.8) + 32;
    }

    public static Double CToK(double cToKTemperature) { 
        return cToKTemperature += (273.15);
    }

    public static Double FToC(double fToCTemperature) {
        return (fToCTemperature - 32) * 5/9;
    }

    public static Double FToK(double fToKTemperature) {;
        return (fToKTemperature - 32) * 5/9 + 273;
    }

    // If it's a return method, there is a need to specify what type of return it will be. In this case, it's a "Boolean" type.
    public static Boolean willItRain(int userRainPercent) {
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

    // Creates print(char, double) method.
    public static void print(char userUnit, double userTemp) {
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