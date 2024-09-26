package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SearchesTest {

    @Test
    void testFindUserFamilyNameByAllNegativeSignFractionDistinct() {

        Stream<String> result = new Searches().findUserFamilyNameByAllNegativeSignFractionDistinct();
        List<String> expectedResult = Arrays.asList("Blanco", "López");
        assertEquals(expectedResult, result.collect(Collectors.toList()));

    }

    @Test
    void TestFindUserIdByAllProperFraction(){

        Stream<String> result = new Searches().findUserIdByAllProperFraction();
        List<String> expectedResult = Arrays.asList("1", "2", "3", "5");
        assertEquals(expectedResult, result.collect(Collectors.toList()));

    }

    @Test
    public void testFindFractionSubtractionByUserName() {

        Fraction fraction = new Fraction(21, -5);
        Fraction result = new Searches().findFractionSubtractionByUserName("Oscar");
        assertEquals(fraction, result);

    }

    @Test
    public void testFindFractionSubtractionByUserNameException() {

        Exception exception = assertThrows(
                Exception.class,
                () -> new Searches().findFractionSubtractionByUserName("Paula")
        );

        assertEquals("Cannot subtract by zero a/0", exception.getMessage());
    }

}
