import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите стоимость товара (руб.): ");
        double price = scanner.nextInt();

        if(priceChecker(price)){
            double result = resulter(price);
            System.out.print("Стоимость товара c учетом таможенной пошлины (руб.): " + result);

        } else {

            System.out.print("Товар, стоимостью менее 500 UER не облагается таможенной пошлиной");
        }
    }

    private static boolean priceChecker(double price){
        if(price > 500){
            return true;
        }else{
            return false;
        }
    }

    private static double converterEur(double price){
        return price / 73;
    }

    private static double converterRub(double price){
        return price * 73;
    }

    private static double taxCounter(double priceEuro){
        return ((priceEuro - 500) / 100) * 30;
    }

    private static double resulter(double price){
        double x = converterEur(price);
        double y = taxCounter(x);
        double z = x + y;
        return (double) (Math.round(converterRub(z) * 100) / 100);
    }
}