package functional_java;

import functional_java.model.Employee;
import functional_java.model.Order;
import functional_java.model.Student;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FunctionalJavaPracticeTest {

    // --- Q1: filterMapAndSort ---

    @Test
    void q01_filterMapAndSort_basic() {
        List<String> input = List.of("alice", "bob", "anna", "alex");
        assertIterableEquals(
                List.of("ALEX", "ALICE", "ANNA"),
                FunctionalJavaPractice.filterMapAndSort(input, "a", 3));
    }

    @Test
    void q01_filterMapAndSort_noMatches() {
        assertTrue(FunctionalJavaPractice.filterMapAndSort(List.of("Amy", "bob"), "a", 4).isEmpty());
    }

    @Test
    void q01_filterMapAndSort_emptyInput() {
        assertTrue(FunctionalJavaPractice.filterMapAndSort(List.of(), "a", 1).isEmpty());
    }

    // --- Q2: sumSquaresOfEvens ---

    @Test
    void q02_sumSquaresOfEvens_mixed() {
        assertEquals(20, FunctionalJavaPractice.sumSquaresOfEvens(List.of(1, 2, 3, 4, 5)));
    }

    @Test
    void q02_sumSquaresOfEvens_noEvens() {
        assertEquals(0, FunctionalJavaPractice.sumSquaresOfEvens(List.of(1, 3, 5)));
    }

    @Test
    void q02_sumSquaresOfEvens_empty() {
        assertEquals(0, FunctionalJavaPractice.sumSquaresOfEvens(List.of()));
    }

    // --- Q3: groupOrdersByStatus ---

    @Test
    void q03_groupOrdersByStatus() {
        List<Order> orders = List.of(
                new Order("O1", "PENDING"),
                new Order("O2", "SHIPPED"),
                new Order("O3", "PENDING"));

        Map<String, List<Order>> grouped = FunctionalJavaPractice.groupOrdersByStatus(orders);

        assertEquals(2, grouped.get("PENDING").size());
        assertEquals(List.of("O1", "O3"), grouped.get("PENDING").stream().map(Order::id).toList());
        assertEquals(List.of("O2"), grouped.get("SHIPPED").stream().map(Order::id).toList());
    }

    @Test
    void q03_groupOrdersByStatus_empty() {
        assertTrue(FunctionalJavaPractice.groupOrdersByStatus(List.of()).isEmpty());
    }

    // --- Q4: partitionByEven ---

    @Test
    void q04_partitionByEven() {
        Map<Boolean, List<Integer>> partitioned =
                FunctionalJavaPractice.partitionByEven(List.of(3, 1, 4, 2));

        assertIterableEquals(List.of(2, 4), partitioned.get(true));
        assertIterableEquals(List.of(1, 3), partitioned.get(false));
    }

    @Test
    void q04_partitionByEven_allEven() {
        Map<Boolean, List<Integer>> partitioned =
                FunctionalJavaPractice.partitionByEven(List.of(4, 2));

        assertIterableEquals(List.of(2, 4), partitioned.get(true));
        assertTrue(partitioned.get(false).isEmpty());
    }

    // --- Q5: flattenDistinctSorted ---

    @Test
    void q05_flattenDistinctSorted_basic() {
        assertIterableEquals(
                List.of("a", "b", "c"),
                FunctionalJavaPractice.flattenDistinctSorted(List.of(List.of("b", "a"), List.of("b", "c"))));
    }

    @Test
    void q05_flattenDistinctSorted_emptyInner() {
        assertTrue(FunctionalJavaPractice.flattenDistinctSorted(List.of(List.of())).isEmpty());
    }

    // --- Q6: wordFrequency ---

    @Test
    void q06_wordFrequency() {
        Map<String, Long> freq =
                FunctionalJavaPractice.wordFrequency(List.of("apple", "banana", "apple"));

        assertEquals(2L, (long) freq.get("apple"));
        assertEquals(1L, (long) freq.get("banana"));
        assertEquals(2, freq.size());
    }

    @Test
    void q06_wordFrequency_empty() {
        assertTrue(FunctionalJavaPractice.wordFrequency(List.of()).isEmpty());
    }

    // --- Q7: priceAfterDiscountAndTax ---

    @Test
    void q07_priceAfterDiscountAndTax_standard() {
        assertEquals(108.0, FunctionalJavaPractice.priceAfterDiscountAndTax(100, 0.10, 0.20), 0.001);
    }

    @Test
    void q07_priceAfterDiscountAndTax_noDiscount() {
        assertEquals(55.0, FunctionalJavaPractice.priceAfterDiscountAndTax(50, 0.0, 0.10), 0.001);
    }

    // --- Q8: filterEmployees ---

    @Test
    void q08_filterEmployees() {
        List<Employee> employees = List.of(
                new Employee("Alice", 30, "ENG"),
                new Employee("Bob", 25, "ENG"),
                new Employee("Carol", 30, "SALES"));

        List<Employee> result = FunctionalJavaPractice.filterEmployees(employees, 30, "eng");

        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).name());
    }

    @Test
    void q08_filterEmployees_noneMatch() {
        List<Employee> employees = List.of(new Employee("Alice", 30, "ENG"));
        assertTrue(FunctionalJavaPractice.filterEmployees(employees, 31, "ENG").isEmpty());
    }

    // --- Q9: extractEmailDomain ---

    @Test
    void q09_extractEmailDomain_valid() {
        assertEquals(
                Optional.of("EXAMPLE.COM"),
                FunctionalJavaPractice.extractEmailDomain(Optional.of("user@example.com")));
    }

    @Test
    void q09_extractEmailDomain_invalidNoAt() {
        assertEquals(Optional.empty(), FunctionalJavaPractice.extractEmailDomain(Optional.of("invalid")));
    }

    @Test
    void q09_extractEmailDomain_emptyOptional() {
        assertEquals(Optional.empty(), FunctionalJavaPractice.extractEmailDomain(Optional.empty()));
    }

    @Test
    void q09_extractEmailDomain_multipleAt() {
        assertEquals(Optional.empty(), FunctionalJavaPractice.extractEmailDomain(Optional.of("a@b@c")));
    }

    @Test
    void q09_extractEmailDomain_emptyDomain() {
        assertEquals(Optional.empty(), FunctionalJavaPractice.extractEmailDomain(Optional.of("user@")));
    }

    // --- Q10: topStudentsByScore ---

    @Test
    void q10_topStudentsByScore_tieBreakByName() {
        List<Student> students = List.of(
                new Student("Alice", 90),
                new Student("Bob", 95),
                new Student("Charlie", 90));

        assertIterableEquals(
                List.of("Bob", "Alice"),
                FunctionalJavaPractice.topStudentsByScore(students, 2));
    }

    @Test
    void q10_topStudentsByScore_nLargerThanList() {
        List<Student> students = List.of(
                new Student("Alice", 90),
                new Student("Bob", 95),
                new Student("Charlie", 88));

        assertIterableEquals(
                List.of("Bob", "Alice", "Charlie"),
                FunctionalJavaPractice.topStudentsByScore(students, 5));
    }

    @Test
    void q10_topStudentsByScore_empty() {
        assertTrue(FunctionalJavaPractice.topStudentsByScore(List.of(), 3).isEmpty());
    }
}
