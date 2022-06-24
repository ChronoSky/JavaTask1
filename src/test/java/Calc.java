import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author ZakrenichniyAN
 */
public class Calc {

    public static void main(String[] args) throws IOException {

        double firstParam = getDoubleFromConsole("Введите первое число");
        double secondParam = getDoubleFromConsole("Введите второе число");

        System.out.printf("%.4f", sum(firstParam, secondParam));
    }

    /**
     * @param a first double param
     * @param b second double param
     * @return sum of two params
     */
    public static Double sum(double a, double b){
        return a+b;
    }

    /**
     * @param text question text
     * @return answer from user Double type
     */
    public static double getDoubleFromConsole(String text) throws IOException {
        double result = 0.0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println(text);
            String value = br.readLine();
            if (value.matches("\\d+(.\\d+)?")){
                result = Double.parseDouble(value);
                break;
            }
        }while(true);
        return result;
    }
}
