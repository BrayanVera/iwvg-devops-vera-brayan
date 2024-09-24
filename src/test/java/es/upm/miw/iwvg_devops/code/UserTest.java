package es.upm.miw.iwvg_devops.code;

import org.apache.commons.lang3.math.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void testDefaultConstructor() {
        assertNotNull(user.getId());
        assertNotNull(user.getName());
        assertNotNull(user.getFamilyName());
        assertTrue(user.getFractions().isEmpty());
    }

    @Test
    void testCustomConstructor() {
        String customId = "12345";
        String customName = "John Doe";
        String customFamilyName = "Smith";

        User customUser = new User(customId, customName, customFamilyName, Arrays.asList(new Fraction()));

        assertEquals(customId, customUser.getId());
        assertEquals(customName, customUser.getName());
        assertEquals(customFamilyName, customUser.getFamilyName());
        assertFalse(customUser.getFractions().isEmpty());
    }

    @Test
    void testFullName() {
        user.setName("John");
        user.setFamilyName("Doe");
        assertEquals("John Doe", user.fullName());
    }

    @Test
    void testInitials() {
        user.setName("John Michael Doe");
        assertEquals("J.M.", user.initials());
    }

    @Test
    void testAddFraction() {
        Fraction fraction = new Fraction();
        user.addFraction(fraction);
        assertTrue(user.getFractions().contains(fraction));
    }

}
