public class Runner {
    public static void main(String[] args) {
        section1();

        //section2();

        //section3();
    }

    public static void section1() {
        // practice problems - Section 1
        WordPlay wp = new WordPlay();
        System.out.println(wp.isVowel('a'));
        System.out.println(wp.isVowel('A'));
        System.out.println(wp.isVowel('w'));
        System.out.println();

        System.out.println(wp.replaceVowels("Hello World", '*'));
        System.out.println();

        System.out.println(wp.emphasize("dna ctgaaactga", 'a'));
        System.out.println(wp.emphasize("Mary Bella Abracadabra", 'a'));
        System.out.println();
        System.out.println("-----------------------");

        //encrypt(“FIRST LEGION ATTACK EAST FLANK!”, 23)
        //“CFOPQ IBDFLK XQQXZH BXPQ CIXKH!”
        CaesarCipher cc = new CaesarCipher();
        String encryptedMessage = cc.encrypt("FIRST LEGION ATTACK EAST FLANK!", 23);
        System.out.println(encryptedMessage);
        //System.out.println();
        //cc.testCaesarOnFile();
        System.out.println();
        encryptedMessage = cc.encrypt("First Legion", 23);
        System.out.println(encryptedMessage);
        encryptedMessage = cc.encrypt("First Legion", 17);
        System.out.println(encryptedMessage);
        encryptedMessage = cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket", 15);
        System.out.println("** " + encryptedMessage);

        encryptedMessage = cc.twoEncryptedKeys("Can you imagine life WITHOUT the internet AND computers in your pocket", 21, 8);
        System.out.println("2 keys: " + encryptedMessage);
        System.out.println("-----------------------");
        System.out.println();
        //practice quiz - Section 1
        //At noon be in the conference room with your hat on for a surprise party. YELL LOUD!
        encryptedMessage = cc.encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15);
        System.out.println(encryptedMessage);
        encryptedMessage = cc.twoEncryptedKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21);
        System.out.println(encryptedMessage);
        encryptedMessage = cc.encrypt("Google News is a free news aggregator provided and operated by Google, selecting " +
                "news from thousands of news websites. A beta version was launched in September, and released " +
                "officially in January.", 10);
        System.out.println(encryptedMessage);

        encryptedMessage = cc.twoEncryptedKeys("Google News is a free news aggregator provided and operated by Google, selecting " +
                "news from thousands of news websites. A beta version was launched in September, and released " +
                "officially in January.", 10, 15);
        System.out.println("2 keys: " + encryptedMessage);
    }

    public static void section2() {
        WordLengths wl = new WordLengths();
        wl.testCountWordLengths();

        CaesarCipherTwoKeysDecrypt cctkd = new CaesarCipherTwoKeysDecrypt();
        cctkd.testDecrypt();
    }

    public static void section3() {
        Simple item = new Simple(3, "blue");
        //System.out.println(item.mystery(5, "ho"));
    }
}
