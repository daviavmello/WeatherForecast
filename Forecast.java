import java.util.Scanner;

public class Forecast {
    Scanner scnr = new Scanner(System.in);

    double temperature;
    String skyCondition;
    int rainPercent;

    // I'm unsure if this is a functional constructor.
    public Forecast() {
        temperature = 0;
        skyCondition = "";
        rainPercent = 0;
    }

    public void setTemperature(double userTemp) {
        // Check later on if Forecast constructor can be called within this method.
        System.out.println("Enter temperature below:");

        userTemp = scnr.nextDouble();
        
        if (userTemp >= -100 && userTemp <= 150) {
            temperature = userTemp;
        }
        else {
            temperature = 72;
        }
    }

    public void setSkyCondition(String userSkyCondition) {
        System.out.println("What's the sky conditions:");
        userSkyCondition = scnr.nextLine();

        if (userSkyCondition.length() == 0) {
            skyCondition = "clear";
        }
        else {
            skyCondition = userSkyCondition;
        }
    }

    public void setChanceOfRain(int userRainPercent) {
        System.out.println("What's the chance of rain, in percentage? (0-100)");

        userRainPercent = scnr.nextInt();

        if (userRainPercent >= 0 && userRainPercent <= 100) {
            rainPercent = userRainPercent;
        }
        else {
            rainPercent = 0;
        }
    }

    public Double getTemperature() {
        return this.temperature;
    }

    public String getSkyCondition() {
        return this.skyCondition;
    }

    public Integer getRainPercentage() {
        return this.rainPercent;
    }
    
    
    // Move Main method over to WeatherForecast.java 
    public static void main(String [] args) {
        double tempInput = 0;
        String skyConditionInput = "";
        int rainPercent = 0;

        Forecast tempCondition = new Forecast();
        Forecast skyCondition = new Forecast();
        Forecast rainCondition = new Forecast();
        
        tempCondition.setTemperature(tempInput);
        skyCondition.setSkyCondition(skyConditionInput);
        rainCondition.setChanceOfRain(rainPercent);

        // We can't call any methods in Java without creating an object.
        System.out.println("Temperature is " + tempCondition.getTemperature());
        System.out.println("Sky conditions are " + skyCondition.getSkyCondition());
        System.out.println("Chance of rain is " + rainCondition.getRainPercentage() + "%");
    }
}