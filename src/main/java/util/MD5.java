package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe para trabalhar com criptografica MD5
 * @author Ruan
 */
public class MD5 {

    public static String md5(String text) {
        String retorno = "";
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(text.getBytes(), 0, text.length());
            retorno = new BigInteger(1, m.digest()).toString(16);
        }
        catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }
    
}
