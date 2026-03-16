import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    // Bug 1: divide by zero - no validation
    public int divide(int a, int b) {
        return a / b;
    }

    // Bug 2: SQL injection vulnerability
    public String getUserById(int id) {
        String query = "SELECT * FROM users WHERE id = " + id;
        return query;
    }

    // Bug 3: terrible performance - printing 1 million times
    public void printNumbers() {
        for(int i = 0; i <= 1000000; i++) {
            System.out.println(i);
        }
    }

    // Bug 4: hardcoded credentials
    private String dbUrl = "jdbc:mysql://localhost:3306/mydb";
    private String dbUser = "root";
    private String dbPassword = "admin123";

    // Bug 5: connection never closed - resource leak
    public ResultSet getData() throws Exception {
        Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        Statement stmt = conn.createStatement();
        return stmt.executeQuery("SELECT * FROM users");
    }

    // Bug 6: null pointer exception risk
    public int getStringLength(String text) {
        return text.length();
    }

    // Bug 7: integer overflow risk
    public int multiply(int a, int b) {
        return a * b;
    }

    // Bug 8: wrong logic - should be > not >=
    public boolean isAdult(int age) {
        if (age >= 18) {
            return true;
        }
        return false;
    }

    // Bug 9: catching generic Exception - bad practice
    public int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Bug 10: recursive call with no base case - stack overflow
    public int factorial(int n) {
        return n * factorial(n - 1);
    }

    // Bug 11: memory leak - list keeps growing, never cleared
    private List<String> cache = new ArrayList<>();

    public void addToCache(String item) {
        cache.add(item);
    }

    // Bug 12: comparing strings with == instead of .equals()
    public boolean isAdmin(String role) {
        return role == "admin";
    }

    // Bug 13: index out of bounds risk
    public int getFirstElement(int[] arr) {
        return arr[0];
    }

    // Bug 14: negative number check missing
    public double squareRoot(double number) {
        return Math.sqrt(number);
    }

    // Bug 15: thread unsafe - not synchronized
    private static int counter = 0;

    public void incrementCounter() {
        counter++;
    }
}