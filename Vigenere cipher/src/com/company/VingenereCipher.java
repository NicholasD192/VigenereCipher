package com.company;



public class VingenereCipher {

    //Vigenere cipher Class - Rosetta Code

    /**
     * Generates CipherText from plainText (Actual Encryption process)
     * @param plainTxt -
     * @param key
     * @return the encrypted message
     */
    public String generateCipherText(String plainTxt, String key) {


        String  cipherText = "";
        plainTxt = plainTxt.toUpperCase();
        for (int i = 0, j = 0; i < plainTxt.length(); i++) {
            char c = plainTxt.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            cipherText += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }

        return cipherText;
    }

    /**
     * Generates plainText from CipherText (Actual Decryption process)
     * @param cipherText
     * @param key
     * @return The original message
     */
    public String generatePlainText (String cipherText, String key){

        String plainText = "";
        cipherText = cipherText.toUpperCase();
        for (int i = 0, j = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            plainText += (char)((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return plainText;

    }
}
