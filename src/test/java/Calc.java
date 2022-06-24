import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;


/**
 * @author ZakrenichniyAN
 */
public class Calc {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String answer;
        do {
            System.out.println("Выберите операцию :");
            System.out.println("1 - Сложение");
            System.out.println("2 - Вычитание");
            System.out.println("3 - Умножение");
            System.out.println("4 - Деление");

            answer = br.readLine().trim();

        }while (!(answer.equals("1") || answer.equals("2") || answer.equals("3") || answer.equals("4")));

        double firstParam = getDoubleFromConsole("Введите первое число");
        double secondParam = getDoubleFromConsole("Введите второе число");

        double result = 0.0;
        try {
            switch (answer){
                case "1" :
                    result = sum(firstParam, secondParam);
                    break;
                case "2" :
                    result = subtraction(firstParam, secondParam);
                    break;
                case "3" :
                    result = multiplication(firstParam, secondParam);
                    break;
                case "4" :
                        result = division(firstParam, secondParam);
            }
            System.out.printf("%.4f", result);

        }catch (ArithmeticException e){
            System.out.println("Делить на 0 нельзя");
        }

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
     * @param a first double param
     * @param b second double param
     * @return subtraction of two params
     */
    public static Double subtraction(double a, double b){
        return a-b;
    }

    /**
     * @param a first double param
     * @param b second double param
     * @return multiplication of two params
     */
    public static Double multiplication(double a, double b){
        return a*b;
    }

    /**
     * @param a first double param
     * @param b second double param
     * @return division of two params
     */
    public static Double division(double a, double b) throws ArithmeticException {
        if (b==0) throw new ArithmeticException();
        return a/b;
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
