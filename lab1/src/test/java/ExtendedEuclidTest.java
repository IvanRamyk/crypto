
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class ExtendedEuclidTest {
    @Test
    void testNumbersWithGCDNotEqualsOne() {
        var result = ExtendedEuclid.extendedAlgorithm(
                new BigInteger("180234567898765432123456786543245678765432456"),
                new BigInteger("150234567890987654323456783456789034567898765432345678976")
        );

        assertEquals(BigInteger.valueOf(8), result[0]);
        assertEquals(new BigInteger("1229954313815509585227806282539030464679998834377949985"),
                result[1]);
        assertEquals(new BigInteger("-1475561100203085651023995393195990040638327"),
                result[2]);
    }

    @Test
    void testNumbersWithGCDEqualsOne() {
        var result = ExtendedEuclid.extendedAlgorithm(
                new BigInteger("1802345678987654321234567865432456787654324561"),
                new BigInteger("150234567890987654323456783456789034567898765432345678976")
        );

        assertEquals(BigInteger.ONE, result[0]);
        assertEquals(new BigInteger("-63524105172722478387163175082519043969162660373251473231"),
                result[1]);
        assertEquals(new BigInteger("762090896102493372855587198992341642241962142"),
                result[2]);
    }
}