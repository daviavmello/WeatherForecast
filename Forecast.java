import java.util.Scanner;

public class Forecast {

    public float Temperature(float temperature, boolean isValid) {
        isValid = false;

        Scanner scnr = new Scanner(System.in);
        temperature = scnr.nextFloat();

        if (temperature >= -100 && temperature <= 150) {
            isValid = true;
        }

        while (!isValid) {
            temperature = 72;
        }

        return temperature;
    }

    public String SkyCondition(String skyCondition, boolean isSet) {
        isSet = false;

        Scanner scnr = new Scanner(System.in);
        skyCondition = scnr.nextString();

        while (!isSet) {
        skyCondition = "Clear";
        }

        return skyCondition;
    }
    
    // public static void main (Strin [] args) {

    // }
}