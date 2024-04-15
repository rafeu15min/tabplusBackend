package com.api.validator;

import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import java.security.SecureRandom;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class Password {

    public String hash(String passwordString) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        SecureRandom random = new SecureRandom();
        byte hashBytes[] = new byte[passwordString.length()];
        random.nextBytes(hashBytes);

        char hash[] = new char[passwordString.length()];
        char[] passwordCharArray = passwordString.toCharArray();

        for (int i = 0; i < hashBytes.length; i++) {
            hash[i] = (char) hashBytes[i];
        }

        for (int i = 0; i < passwordCharArray.length; i++) {
            passwordCharArray[i] += hash[i];
        }

        String base64dPassword = new String(
                Base64.encodeBase64(new String(passwordCharArray).concat(new String(hash)).getBytes()));

        char[] hexedPasswordCharArray = Hex.encodeHex(base64dPassword.getBytes(StandardCharsets.UTF_8));

        return new String(hexedPasswordCharArray);

    }

    public boolean validate(String encryptedPassword, String passwordString)
            throws DecoderException, UnsupportedEncodingException {

        String unHexedPassword = "";
        try {
            byte[] bytes = Hex.decodeHex(encryptedPassword);
            unHexedPassword = new String(bytes, StandardCharsets.UTF_8);
        } catch (DecoderException e) {
            throw new IllegalArgumentException("Invalid Hex format!");
        }

        String unBase64dPassword = new String(Base64.decodeBase64(unHexedPassword.getBytes()));

        char[] hash = unBase64dPassword.substring(unBase64dPassword.length() - passwordString.length()).toCharArray();

        char[] passwordCharArray = unBase64dPassword.substring(0,
                unBase64dPassword.length() - passwordString.length()).toCharArray();
        for (int i = 0; i < passwordCharArray.length; i++) {
            try {
                passwordCharArray[i] -= hash[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
        }
        String decryptedPassword = new String(passwordCharArray);
        return decryptedPassword.equals(passwordString);
    }

}
