package unit.iti;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NameInverterTest {

    private NameInverter nameInverter;

    @BeforeEach
    public void setup() {
        nameInverter = new NameInverter();
    }

    @Test
    void givenNull_ReturnEmptyString() {
        assertInverted(null, "");
    }

    @Test
    void givenEmpty_ReturnEmptyString() {
        assertInverted("", "");
    }

    @Test
    void givenSimpleName_ReturnSimpleName() {
        assertInverted("Name", "Name");
    }

    @Test
    void givenSimpleNameWithExtraSpaces_ReturnSimpleName() {
        assertInverted("       Name       ", "Name");
    }

    @Test
    void givenFirstLast_ReturnLastFirst() {
        assertInverted("First Last", "Last, First");
    }

    @Test
    void givenFirstLastWithExtraSpaces_ReturnLastFirst() {
        assertInverted("First       Last", "Last, First");
    }

    @Test
    void removeHonorific() {
        assertInverted("Mr. First Last", "Last, First");
        assertInverted("Mrs. First Last", "Last, First");
    }

    @Test
    void postNominals_stayAtEnd() {
        assertInverted("First Last CEO", "Last, First CEO");
        assertInverted("First Last CEO Phd.", "Last, First CEO Phd.");
    }

    @Test
    void integrationTest() {
        assertInverted("Mr.   First    Last CEO Phd.", "Last, First CEO Phd.");
    }

    private void assertInverted(String originalName, String expectedName) {
        Assertions.assertEquals(expectedName, nameInverter.invertName(originalName));
    }
}