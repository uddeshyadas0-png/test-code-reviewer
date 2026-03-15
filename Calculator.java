public class Calculator {

    // Bug 1: no check for divide by zero
    public int divide(int a, int b) {
        return a / b;
    }

    // Bug 2: SQL injection vulnerability
    public String getUserById(int id) {
        String query = "SELECT * FROM users WHERE id = " + id;
        return query;
    }

    // Bug 3: terrible performance
    public void printNumbers() {
        for(int i = 0; i <= 1000000; i++) {
            System.out.println(i);
        }
    }

    // Bug 4: hardcoded password
    private String password = "admin123";
}
