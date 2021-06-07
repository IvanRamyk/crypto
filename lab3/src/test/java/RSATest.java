import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RSATest {

    @Test
    void encrypt() {
        Random random = new Random();
        RSA rsa = new RSA(BigInteger.probablePrime(1024, random), BigInteger.probablePrime(1024, random), new BigInteger("983"));
        BigInteger number1 = new BigInteger("10");
        BigInteger number2 = new BigInteger("15");
        assertNotEquals(new BigInteger("0"), rsa.encrypt(number1));
        assertNotEquals(new BigInteger("0"), rsa.encrypt(number2));

        assertEquals(1, rsa.decrypt(number1).compareTo(new BigInteger("10")));
        assertEquals(1, rsa.decrypt(number2).compareTo(new BigInteger("15")));
    }

    @Test
    void encryptBigInteger() {
        Random random = new Random();
        RSA rsa = new RSA(BigInteger.probablePrime(1024, random), BigInteger.probablePrime(1024, random), new BigInteger("983"));
        for (int i = 0; i < 100; ++i) {
            BigInteger number = new BigInteger(512, random);
            assertEquals(number, rsa.decrypt(rsa.encrypt(number)));
        }
    }



    @Test
    void encryptMessage() {
        Random random = new Random();
        RSA rsa = new RSA(BigInteger.probablePrime(1024, random), BigInteger.probablePrime(1024, random), new BigInteger("983"));
        System.out.println(rsa);
        String message = "Hello, world!";
        assertEquals(message, rsa.decryptMessages(rsa.encryptMessage(message)));

    }
}