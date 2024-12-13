import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.HashMap;
import java.util.function.BiFunction;

public class Calculator {
    private static final Scanner scanner = new Scanner(System.in);
    
    // Operation maps
    private static final Map<String, BiFunction<Double, Double, Double>> BASIC_OPERATIONS = new HashMap<>();
    private static final Map<String, BiFunction<Double, Double, Double>> SCIENTIFIC_OPERATIONS = new HashMap<>();
    
    static {
        // Basic arithmetic operations
        BASIC_OPERATIONS.put("+", (a, b) -> a + b);
        BASIC_OPERATIONS.put("-", (a, b) -> a - b);
        BASIC_OPERATIONS.put("*", (a, b) -> a * b);
        BASIC_OPERATIONS.put("/", (a, b) -> {
            if (b == 0) throw new ArithmeticException("Cannot divide by zero");
            return a / b;
        });
        BASIC_OPERATIONS.put("^", Math::pow);
        BASIC_OPERATIONS.put("%", (a, b) -> a % b);
        
        // Scientific operations
        SCIENTIFIC_OPERATIONS.put("log", (base, x) -> Math.log(x) / Math.log(base));
        SCIENTIFIC_OPERATIONS.put("root", (n, x) -> Math.pow(x, 1.0 / n));
    }
    
    public static void main(String[] args) {
        while (true) {
            try {
                printMenu();
                int choice = getUserChoice();
                
                if (choice == 0) {
                    System.out.println("Exiting calculator. Goodbye!");
                    break;
                }
                
                performCalculation(choice);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Clear input buffer
            }
        }
    }
    
    private static void printMenu() {
        System.out.println("\n=== Scientific Calculator ===");
        System.out.println("1. Basic Arithmetic");
        System.out.println("2. Scientific Operations");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }
    
    private static int getUserChoice() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear invalid input
            throw new IllegalArgumentException("Invalid menu choice. Please enter a number.");
        }
    }
    
    private static void performCalculation(int choice) {
        switch (choice) {
            case 1:
                performBasicArithmetic();
                break;
            case 2:
                performScientificCalculation();
                break;
            default:
                throw new IllegalArgumentException("Invalid choice");
        }
    }
    
    private static void performBasicArithmetic() {
        // Clear any remaining newline
        scanner.nextLine();
        
        // Print available operators
        System.out.println("\nAvailable Basic Operators:");
        System.out.println("+ : Addition");
        System.out.println("- : Subtraction");
        System.out.println("* : Multiplication");
        System.out.println("/ : Division");
        System.out.println("^ : Exponentiation");
        System.out.println("% : Modulus");
        
        // Get operator
        System.out.print("Enter operator: ");
        String operator = scanner.nextLine().trim();
        
        // Validate operator
        if (!BASIC_OPERATIONS.containsKey(operator)) {
            throw new IllegalArgumentException("Invalid operator");
        }
        
        // Get operands
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        
        // Perform calculation
        double result = BASIC_OPERATIONS.get(operator).apply(num1, num2);
        
        // Display result
        System.out.printf("Result of %.2f %s %.2f = %.4f%n", num1, operator, num2, result);
    }
    
    private static void performScientificCalculation() {
        // Clear any remaining newline
        scanner.nextLine();
        
        // Print available scientific operations
        System.out.println("\nAvailable Scientific Operations:");
        System.out.println("log : Logarithm (base, value)");
        System.out.println("root : Root calculation (n-th root, value)");
        
        // Get operation
        System.out.print("Enter scientific operation: ");
        String operation = scanner.nextLine().trim().toLowerCase();
        
        // Validate operation
        if (!SCIENTIFIC_OPERATIONS.containsKey(operation)) {
            throw new IllegalArgumentException("Invalid scientific operation");
        }
        
        // Get parameters
        System.out.print("Enter first parameter: ");
        double param1 = scanner.nextDouble();
        
        System.out.print("Enter second parameter: ");
        double param2 = scanner.nextDouble();
        
        // Perform calculation
        double result = SCIENTIFIC_OPERATIONS.get(operation).apply(param1, param2);
        
        // Display result
        System.out.printf("Result of %s(%.2f, %.2f) = %.4f%n", operation, param1, param2, result);
    }
}
