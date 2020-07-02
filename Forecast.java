import java.util.Scanner;

public class Forecast {
    Scanner scnr = new Scanner(System.in);

    private double temperature;
    private String skyCondition;
    private int rainPercent;

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
    public static Double KToC(char userUnit, double kToCTemperature) {
        if (userUnit == 'K') {
            kToCTemperature += (-273);
        }
        return kToCTemperature;
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

    // Create print() method.
    // public void print() {
    //    
    // }

    // Move Main method over to WeatherForecast.java
    public static void main(final String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("What's the default temperature unit? Choose between K, C, or F.");
        char unitInput = scnr.nextLine().charAt(0);
        tempUnit(unitInput);

        System.out.println("Enter temperature below:");
        double tempInput = scnr.nextDouble();
        Forecast tempCondition = new Forecast(tempInput);
        tempCondition.setTemperature(tempInput);
        System.out.println("Temperature is " + tempCondition.getTemperature());

        System.out.println("What's the sky conditions:");
        String skyConditionInput = scnr.nextLine();
        Forecast skyCondition = new Forecast(skyConditionInput);
        skyCondition.setSkyCondition(skyConditionInput);
        System.out.println("Sky conditions are " + skyCondition.getSkyCondition());

        System.out.println("What's the chance of rain, in percentage? (0-100)");
        int rainPercent = scnr.nextInt();
        Forecast rainCondition = new Forecast(rainPercent);
        rainCondition.setChanceOfRain(rainPercent);
        System.out.println("Chance of rain is " + rainCondition.getRainPercentage() + "%");

        System.out.println("Should you expect rain today?");
        System.out.println(willItRain(rainPercent));
        
        System.out.println("Temperature in Celsius is: " + KToC(unitInput, tempInput));
        
        // rainCondition.setChanceOfRain(rainPercent);
        
        // We can't call any non-static methods in Java without creating an object.
        // Calling getters methods.
        
        
        // System.out.println(rainCondition.willItRain(rainPercent, willItRain));
        // KtoC(tempInput, unitInput);
    }
}