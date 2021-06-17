import java.math.BigInteger;


public class DH {
    /**
     * Diffie-Hellman
     */
    public static void main(String[] args) {
        //Client
        int a = 125; //随机数-->私钥
        int p = 503; //素数*   "*"代表可以直接网络传输
        int g = 5; //底数*
        BigInteger A = new BigInteger(String.valueOf(g)).pow(a).mod(BigInteger.valueOf(p)); //-->公钥*
        System.out.println("A: " + A);

        //Server
        int b = 457; //随机数-->私钥
        BigInteger B = new BigInteger(String.valueOf(g)).pow(b).mod(BigInteger.valueOf(p)); //-->公钥*
        System.out.println("B: " + B);

        BigInteger s = new BigInteger(String.valueOf(A)).pow(b).mod(BigInteger.valueOf(p)); //协商密钥
        System.out.println("s: " + s);

        //Client
        BigInteger s2 = new BigInteger(String.valueOf(B)).pow(a).mod(BigInteger.valueOf(p));  //协商密钥
        System.out.println("s2: " + s2);

    }
}
