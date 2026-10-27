package functional_java;

import functional_java.model.Employee;
import functional_java.model.Order;
import functional_java.model.Student;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Implement each method using functional style (streams, Optional, function composition).
 * Validate with: mvn test
 *
 * @see questions.md in project root for inputs and expected outcomes
 */
public final class FunctionalJavaPractice {

    private FunctionalJavaPractice() {
    }

    /**
     * Q1 — Filter names by prefix (case-insensitive) and min length; uppercase; sort.
     * <p>Example: ["alice","bob","anna","alex"], "a", 3 → ["ALEX","ALICE","ANNA"]
     */
    public static List<String> filterMapAndSort(List<String> names, String prefix, int minLength) {
        throw new UnsupportedOperationException("Implement Q1");
    }

    /**
     * Q2 — Sum of squares of even numbers.
     * <p>Example: [1,2,3,4,5] → 20
     */
    public static int sumSquaresOfEvens(List<Integer> numbers) {
        throw new UnsupportedOperationException("Implement Q2");
    }

    /**
     * Q3 — Group orders by status. Preserve encounter order within each group.
     */
    public static Map<String, List<Order>> groupOrdersByStatus(List<Order> orders) {
        throw new UnsupportedOperationException("Implement Q3");
    }

    /**
     * Q4 — Partition numbers into even (true) and odd (false); each list sorted ascending.
     * <p>Example: [3,1,4,2] → true:[2,4], false:[1,3]
     */
    public static Map<Boolean, List<Integer>> partitionByEven(List<Integer> numbers) {
        throw new UnsupportedOperationException("Implement Q4");
    }

    /**
     * Q5 — Flatten nested lists, distinct, sorted ascending.
     * <p>Example: [["b","a"],["b","c"]] → ["a","b","c"]
     */
    public static List<String> flattenDistinctSorted(List<List<String>> nested) {
        throw new UnsupportedOperationException("Implement Q5");
    }

    /**
     * Q6 — Word frequency map.
     * <p>Example: ["apple","banana","apple"] → {apple=2, banana=1}
     */
    public static Map<String, Long> wordFrequency(List<String> words) {
        throw new UnsupportedOperationException("Implement Q6");
    }

    /**
     * Q7 — Apply discount then tax using function composition. Pure function.
     * <p>Example: basePrice=100, discount=0.10, tax=0.20 → 108.0
     */
    public static double priceAfterDiscountAndTax(double basePrice, double discountRate, double taxRate) {
        throw new UnsupportedOperationException("Implement Q7");
    }

    /**
     * Q8 — Filter employees by min age and department (case-insensitive); sort by name.
     */
    public static List<Employee> filterEmployees(List<Employee> employees, int minAge, String department) {
        throw new UnsupportedOperationException("Implement Q8");
    }

    /**
     * Q9 — Extract domain from email Optional; uppercase; invalid → empty.
     * <p>Example: Optional.of("user@example.com") → Optional.of("EXAMPLE.COM")
     */
    public static Optional<String> extractEmailDomain(Optional<String> email) {
        throw new UnsupportedOperationException("Implement Q9");
    }

    /**
     * Q10 — Top n students by score desc, name asc; return names only.
     * <p>Example: Alice/90, Bob/95, Charlie/90, n=2 → ["Bob","Alice"]
     */
    public static List<String> topStudentsByScore(List<Student> students, int n) {
        throw new UnsupportedOperationException("Implement Q10");
    }
}
