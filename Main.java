import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            String equation = scanner.nextLine().trim();

            if (equation.equalsIgnoreCase("exit")) {
                exit = true;
                continue;
            }

            try {
                double result = evaluateEquation(equation);
                if (result == (int) result) {
                    System.out.println("Result: " + (int) result);
                } else {
                    System.out.println("Result: " + result);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static double evaluateEquation(String equation) {
        String[] tokens = equation.split("[+\\-*/]");

        if (tokens.length != 2) {
            throw new IllegalArgumentException("Invalid number format");
        }

        int num1, num2;
        try {
            num1 = Integer.parseInt(tokens[0].trim());
            num2 = Integer.parseInt(tokens[1].trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format!");
        }

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new IllegalArgumentException("Numbers must be between 1 and 10 (inclusive)!");
        }

        char operator = equation.charAt(tokens[0].length());
        int result;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed!");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator!");
        }

        return result;
    }
}
