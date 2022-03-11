package fr.maven.exercicemvc.tools;

import java.math.BigInteger;
import java.security.MessageDigest;

public class HashTools {

    public static String hashSHA512(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.reset();


        byte[] hachedArray = md.digest(input.getBytes("utf-8"));


        BigInteger bi = new BigInteger(1, hachedArray);
        return String.format("%0128x", bi);
    }


}
