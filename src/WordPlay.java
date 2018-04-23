import java.lang.StringBuilder;

public class WordPlay {
    public boolean isVowel(char ch) {
        // This method returns true if ch is a vowel (one of 'a', 'e', 'i', 'o',
        // or 'u' or the uppercase versions) and false otherwise
        ch = Character.toLowerCase(ch);
        if (Character.valueOf(ch) == 'a' || Character.valueOf(ch) == 'e' || Character.valueOf(ch) == 'i' ||
                Character.valueOf(ch) == 'o' || Character.valueOf(ch) == 'u') {
            return true;
        } else {
            return false;
        }
    }

    public String replaceVowels(String phrase, char ch) {
        // This method should return a String that is the string phrase with
        // all the vowels (uppercase or lowercase) replaced by ch
        StringBuilder replacePhrase = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
            if (isVowel(phrase.charAt(i))) {
                replacePhrase.append(ch);
            } else {
                replacePhrase.append(phrase.charAt(i));
            }
        }
        return replacePhrase.toString();
    }

    public String emphasize(String phrase, char ch) {
        // This method should return a String that is the string phrase
        // but with the Char ch (upper- or lowercase) replaced by
        // ‘*’ if it is in an odd number location in the string (e.g. the first character has an odd number location but an even index, it is at index 0), or
        // odd number location has even indexes - 0, 2, 4, 6, 8, 10
        // ‘+’ if it is in an even number location in the string (e.g. the second character has an even number location but an odd index, it is at index 1).
        // even number location has odd indexes - 1, 3, 5, 7, 9, 11
        StringBuilder replacePhrase = new StringBuilder();
        int vowelCount = 0;
        for (int i = 0; i < phrase.length(); i++) {
            if (Character.toLowerCase(phrase.charAt(i)) == ch) {
                //if odd
                if (i % 2 == 0) {
                    replacePhrase.append('*');
                } else {
                    replacePhrase.append('+');
                }
            } else {
                replacePhrase.append(phrase.charAt(i));
            }
        }
        return replacePhrase.toString();
    }
}

