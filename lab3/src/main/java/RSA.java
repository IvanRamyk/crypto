import java.math.BigInteger;

public class RSA {

    private final static BigInteger ONE = BigInteger.ONE;
    private BigInteger privateKey;
    private BigInteger e;
    private BigInteger modulus;
    private BigInteger p;
    private BigInteger q;
    private final BigInteger phi;

    public RSA(BigInteger p, BigInteger q, BigInteger e) {
        this.e = e;
        this.p = p;
        this.q = q;
        this.phi = (p.subtract(ONE)).multiply(q.subtract(ONE)); //phi = (p-1)*(q-1)
        this.modulus = p.multiply(q);
        this.privateKey = e.modInverse(phi);//d = e^-1 mod phi, закритий ключ, мультиплікативно обернене до числа е по модулю фі
    }


    public BigInteger encrypt(BigInteger message) {
        if (modulus.compareTo(message) < 0)
            throw new IllegalArgumentException("Message must be less than N");
        return message.modPow(e, modulus);
    }

    public BigInteger encryptMessage(final String message) {
        BigInteger integerMessage = new BigInteger(message.getBytes());
        if (modulus.compareTo(integerMessage) < 0) {
            throw new IllegalArgumentException("Too long message. It must be smaller than module");
        }
        return encrypt(integerMessage);
    }

    public BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(privateKey, modulus);
    }

    public String decryptMessages(BigInteger encryption) {
        return new String(decrypt(encryption).toByteArray());
    }

    @Override
    public String toString() {
        String s = "";
        s += "p                     = " + p + "\n";
        s += "q                     = " + q + "\n";
        s += "e                     = " + e + "\n";
        s += "privateKey            = " + privateKey + "\n";
        s += "modulus               = " + modulus;
        return s;
    }
}

