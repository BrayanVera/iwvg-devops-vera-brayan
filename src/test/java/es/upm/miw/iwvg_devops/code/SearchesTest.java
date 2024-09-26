package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
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

}
