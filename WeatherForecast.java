import java.util.Scanner;

public class WeatherForecast {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        // Made a few modifications to your suggestions. Decided to create data types here (unitInput, tempInput, skyCondition, rainInput) instead of sticking to scanner objects to store user input to use later on with printTemp(char, double) method. Is there a better approach to this solution?
                
        // Instantiate Forecast object using 0-arg constructor
        Forecast newForecast = new Forecast() ; 
        
        System.out.println("What's the default temperature unit? Choose between K, C, or F.");
        char unitInput = scnr.nextLine().charAt(0);
        newForecast.tempUnit(unitInput);

        /////////////////////////////////////////


        System.out.println("What is the temperature?");  // prompt
        double tempInput = scnr.nextDouble();
        newForecast.setTemperature(tempInput); 

        System.out.println("The temperature is " + newForecast.getTemperature() + "\n");

        /////////////////////////////////////////
        
        System.out.println("What is today's sky condition?");
        String skyCondition = scnr.nextLine();
        // Instantiate using 1-arg constructor
        Forecast weekdayCondition = new Forecast(skyCondition); 

        // Calling the setter here so that if userInput = enter key, skyConditions become "clear"
        weekdayCondition.setSkyCondition(skyCondition);
        System.out.println("Today it should be " + weekdayCondition.getSkyCondition());
        
        ////////////////////////////////////////////
        
        System.out.println("What's the chance of rain, in percentage? (0-100)");
        // rainInput data type was created to enable willItRain() method to output 'false' or 'true'
        int rainInput = scnr.nextInt();
        Forecast rainPercentage = new Forecast(rainInput);
        rainPercentage.setChanceOfRain(rainInput);
        System.out.println("Should you expect rain today?" + "\n" + rainPercentage.willItRain(rainInput));

        ////////////////////////////////////////////

        // 0-arg constructor to enable printTemp(char, double) method to work (method wouldn't initialize without constructor. Why?)
        Forecast tempConv = new Forecast();
        // Outputs converted temperatures
        tempConv.printTemp(unitInput, tempInput);
    }
}