import edu.duke.FileResource;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
            char inputChar = input.charAt(i);
            if (input.charAt(i) != Character.toUpperCase(input.charAt(i))) {
                alphabet = alphabet.toLowerCase();
                shiftedAlphabet = shiftedAlphabet.toLowerCase();
            }
            int index = alphabet.indexOf(inputChar);

            //System.out.println(inputChar + " " + index + " " + alphabet.charAt(0));

            if (index != -1) {
                char newChar = shiftedAlphabet.charAt(index);
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }

    public void testCaesarOnFile() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        int key = 23;
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }

    public String twoEncryptedKeys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String shiftedAlphabet;
            //Parameter key1 is used to encrypt every other character with the Caesar Cipher algorithm, starting with the first character
            if (i % 2 == 0) { //use key1
                shiftedAlphabet = alphabet.substring(key1) + alphabet.substring(0, key1);
            } else {
                shiftedAlphabet = alphabet.substring(key2) + alphabet.substring(0, key2);
            }
            char inputChar = input.charAt(i);
            if (input.charAt(i) != Character.toUpperCase(input.charAt(i))) {
                alphabet = alphabet.toLowerCase();
                shiftedAlphabet = shiftedAlphabet.toLowerCase();
            }
            int index = alphabet.indexOf(inputChar);

            //System.out.println(inputChar + " " + index + " " + alphabet.charAt(0));

            if (index != -1) {
                char newChar = shiftedAlphabet.charAt(index);
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }
}

