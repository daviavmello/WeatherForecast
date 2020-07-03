import java.util.Scanner;

public class WeatherForecast {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
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
        
        print(unitInput, tempInput);
    }
}