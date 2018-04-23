public class CaesarCipherTwoKeysDecrypt {
    public String decrypt(String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4-maxDex);
        }
        return cc.encrypt(encrypted, 26-dkey);
    }

    public int[] countLetters(String message) {
        // Count 26 frequencies of 'a - z', 'A - Z'
        String alph = "abcdefghijklmnopqrstuvwxyz";
        // String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] counts = new int[26];
        for (int k = 0; k < message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int index = alph.indexOf(ch);
            if (index != -1) {
                counts[index] += 1;
            }
        }
        return counts;
    }

    public int maxIndex(int[] vals) {
        int maxDex = 0;
        for(int k = 0; k < vals.length; k++) {
            if (vals[k] > vals[maxDex]) {
                maxDex = k;
            }
        }
        return maxDex;
    }

    public String halfOfString(String message, int start) {
        StringBuilder newMessage = new StringBuilder();
        for (int i = start; i < message.length(); i++) {
            if (i % 2 == start) { // even
                newMessage.append(message.charAt(i));
            }
        }
        return newMessage.toString();
    }

    public int getKey(String s) {
        //call countLetters to get an array of the letter frequencies in string s
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4-maxDex);
        }
        return dkey;
    }

    public String decryptTwoKeys(String encrypted) {
        String firstKeyString = halfOfString(encrypted, 0);
        int key1 = getKey(firstKeyString);
        String secondKeyString = halfOfString(encrypted, 1);
        int key2 = getKey(secondKeyString);

        System.out.println("Key 1: " + key1 + " Key 2: "+ key2);

        CaesarCipher cc = new CaesarCipher();

        return cc.twoEncryptedKeys(encrypted, 26-key1, 26-key2);
    }

    //-----------------------------------------------------
    public String bruteDecryptSingleKey(String encrypted) {
        StringBuilder decrypted = new StringBuilder(encrypted);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        decrypted = iterator(alphabet, encrypted, decrypted);

        return decrypted.toString();
    }

    public String bruteDecryptSingleKey(String encrypted, int key) {
        StringBuilder decrypted = new StringBuilder(encrypted);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        decrypted = iterator(alphabet, key, encrypted, decrypted);

        return decrypted.toString();
    }

    // if you dont know the key
    public StringBuilder iterator(String alphabet, String encrypted, StringBuilder decrypted) {
        for(int i = 0; i < alphabet.length(); i++) {
            String shiftedAlphabet = alphabet.substring(i) + alphabet.substring(0, i);
            // use this alphabet to decrypt the message
            decrypted = iterator(alphabet, i, encrypted, decrypted);

            System.out.println(i + " " + decrypted.toString());
        }
        return decrypted;
    }

    //if you know the key
    public StringBuilder iterator(String alphabet, int key, String encrypted, StringBuilder decrypted) {
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        for (int j = 0; j < encrypted.length(); j++) {
            // first encrypted character of message - translate it to the alphabet
            // get the character at i (position zero) - lowercase it,
            char decryptedChar = Character.toLowerCase(encrypted.charAt(j));

            // now translate the character
            int index = shiftedAlphabet.indexOf(decryptedChar);
            if (index != -1) {
                char originalChar = alphabet.charAt(index);
                decrypted.setCharAt(j, originalChar);
            }
        }
        return decrypted;
    }

    //-----------------------------------------------------
    // THIS METHOD DOES NOT WORK PROPERLY - YET
    /*public String bruteDecryptTwoKeys(String encrypted) {
        StringBuilder decrypted = new StringBuilder(encrypted);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        decrypted = doubleIterator(alphabet, encrypted, decrypted);

        return decrypted.toString();
    }

    public StringBuilder doubleIterator(String alphabet, String encrypted, StringBuilder decrypted) {
        for (int i = 0; i < alphabet.length(); i++) {
            String shiftedAlphabet = alphabet.substring(i) + alphabet.substring(0, i);

            System.out.println(i + " " + decrypted.toString());
            for (int j = 0; j < shiftedAlphabet.length(); j++) {
                String secondShiftedAlphabet = shiftedAlphabet.substring(j) + shiftedAlphabet.substring(0, j);

                for (int k = 0; k < encrypted.length(); k++) {
                    char decryptedChar = Character.toLowerCase(encrypted.charAt(k));

                    int index = secondShiftedAlphabet.indexOf(decryptedChar);
                    if (index != -1) {
                        char originalChar = alphabet.charAt(index);
                        decrypted.setCharAt(k, originalChar);
                    }
                }
                System.out.println("\t" + j + " " + decrypted.toString());
            }
        }
        return decrypted;
    }*/

    public void testDecrypt() {
        //String encryptedMessage = "CFOPQ IBDFLK XQQXZH BXPQ CIXKH!";
        String encryptedMessage = "eeeeeeeeeeeeeeeees";
        System.out.println(decrypt(encryptedMessage));
        encryptedMessage = "Qyyqvo Xogc sc k pboo xogc kqqboqkdyb zbyfsnon kxn yzobkdon li Qyyqvo, covomdsxq xogc pbyw dryeckxnc yp xogc golcsdoc. K lodk fobcsyx gkc vkexmron sx Cozdowlob, kxn bovokcon yppsmskvvi sx Tkxekbi";
        System.out.println(decrypt(encryptedMessage));

        System.out.println(halfOfString("Qbkm Zgis", 0));
        System.out.println(halfOfString("Qbkm Zgis", 1));

        int key = getKey(encryptedMessage);
        System.out.println(key);

        //encryptedMessage = cc.twoEncryptedKeys("First Legion", 23, 17);
        encryptedMessage = "Qdyvvt Colc sh p ubto xtgh pqvbtqpddb zgykssos pxs dztbpdtn ln Vydqao, hoaordxxv colc pgyb irdehkcnh dp xtgh loqcxdtc. P qoik ftbhsdx gpc vpecmwos xx Ctziobltb, pxs goaopctn yupxmxkavn xx Tpxjkgi";
        System.out.println(decryptTwoKeys(encryptedMessage));

        encryptedMessage = "Top ncmy qkff vi vguv vbg ycpx";
        System.out.println("message: " + encryptedMessage);

        System.out.println("first half: " + halfOfString("Top ncmy qkff vi vguv vbg ycpx", 0));
        System.out.println("second half: " + halfOfString("Top ncmy qkff vi vguv vbg ycpx", 1));
        String message1 = "Tpnm kfv gvvgyp";
        String message2 = "o cyqf ivu b cx";
        System.out.println("decrypted1: " + bruteDecryptSingleKey(message1, 2));
        System.out.println("decrypted1: " + bruteDecryptSingleKey(message2, 20));

        System.out.println("-------------------------------");
        encryptedMessage = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
        System.out.println(decryptTwoKeys(encryptedMessage));

        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        System.out.println("first half: " + halfOfString("Hfs cpwewloj loks cd Hoto kyg Cyy.", 0));
        System.out.println("second half: " + halfOfString("Hfs cpwewloj loks cd Hoto kyg Cyy.", 1));
        message1 = "Hscwwo osc ookgCy";
        message2 = "f peljlk dHt y y";
        System.out.println("decrypted1: " + bruteDecryptSingleKey(message1, 14));
        System.out.println("decrypted1: " + bruteDecryptSingleKey(message2, 24));

        System.out.println("-------------------------------");
        encryptedMessage = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        System.out.println(decryptTwoKeys(encryptedMessage));

        System.out.println("\n\n");
        encryptedMessage = "Uybi Gfqgykii Jgziegv Uigeixdiex Smiizzin\n" +
                "\n" +
                "Sei sw klv deec lrpcqrvbw sw fyi jytgvwj yej sivr jiyzxwyc tscprffvrxzsew edsek hzjwiiiex kisltj nmklzr xyi hvtrvkqvrk, azxy iijirvtl kisltj zr sklvv hvtrvkqvrkw ek Uybi, nmkl sklvv mewkmkykij, eeh azxy zruyjxic. Rw av dsmi mexf klv zrwsiqrxzse rkv, xyi jfglw sw jgziegv zw wymwxzrx wvfq xyi hzwtsmiic sw ein zrwsiqrxzse ks xyi gfqgykekmfrrpcc mexvrjmmi xrwb fj tistijwzrx rru rrrppdzrx zrwsiqrxzse.\n" +
                "\n" +
                "Ni lrzv fykwkeehzrx gvfkiedw me xifqvximt tsdtlxzrx; mexvveik jcjxvqj, rvxnsiozrx, eeh wvglvzxp; fzscsxmtec tsdtlxzrx; qvqfvp jcjxvqj rru dejwzzv ueke qrrrkvqvrk; eeh pveirzrx rru dsuicmek. Klv iijirvtl mexvvvwkw sw fyi wetycxp fzvvceg nmkl xyiji eiirw eeh azxy iijirvtlvv eiirw me fxyii umjgztcmeij jytl ej smfpfkp, iekzrviimek, eeeskitlescsxc, rru vrmmiseqvrkec jgziegvw.\n" +
                "\n" +
                "GJ Uigx Tysks Av rpjs hf nsio me r eydfvv sw fxyii zqgsixrrk rvvej zrtplhzrx tsdtlxvv kieglzgj rru mmjyrpzdrxzse, wvrjsi eikafvbw, eydiimtec rrrppwzw, jswxneii iekzrviimek, tsdtciomkc xyifvp, eeh vfffxzgj.\n" +
                "\n" +
                "Klv uigeixdiex mj rvxyrfcc yemhyv zr xyi wpqsmfwzw xyek vbzwkw fvxnivr xyi iuytekmfr kislt eeh xyi vvwveigy wetycxp. Xyi wprvvxc fvxnivr xyid yej sivr e ovc xf klv jytgvwj zr gfrkmeyrpcc vvjfvdmek xyi glvimtycyd rru zrkixvrxzrx iijirvtl eeh iuytekmfr. Klv uigeixdiex mj lwzrx r uyrp egtisrgy ks gfqsmei vvwveigy rru vhlgrxzse. Fimekzrx iijirvtl mexf klv tyivzglplq mj klv sijx arc xf kvrme jxlhvrkw esslx xyi qfwk rhmeegvh xvgyrfpfkp rru ks hzwjidmeeki xyi prxvwk uimicsgqvrkw sw tsdtlxzrx kitlescsxc me jstmvxp.\n" +
                "\n" +
                "TW Hvtk Glfxf Ni iegfyiexi yehvvxvrhleki wkyuiexj ks kvx mezfpmiu nmkl sekfmek qrnfv vvwveigy gvfnvgkw xyvfyxl xyi G-WLVW gvfkied, yehvvxvrhleki xyijij, Vvwveigy Vbgiimvrti jfv Yehvvxvrhlekij (VVY) jygtfvk, mehvtvruiex wkyumvw, vxt. Wfqv fj slv iogvtkmfrrp jzvjx qrnfvj xvrhleki azxy umjxzrtxzse, aymtl mezfpmij r jmxrzjzgrrk iijirvtl gfqgseiex, rru zr qrrp tejij klv iijirvtl lrw vvwlpkiu zr tlfcmtekmfrj zr pveumek gfrwiiiegvw.\n" +
                "\n" +
                "Xyi idmeiegv fj slv vvwveigy rru kirgymek jrglpkc mj klv smxkvwk jxiiekkl sw klv uigeixdiex. Deec jrglpkc qvqsiiw lrzv sivr vvgfkemqiu sskl ek lrzzvvjmkc eeh rrxzseec cimicw jfv xyizv iogvpciegv zr vvwveigy, iuytekmfr, rru jiizzgv. Lzkypp mmjmspv, qlpkmumjgztcmeeic tisaitxj rvv sizrx tsehlgkiu, wgsewfvvh fp meimfyj wyehzrx rkvrtmvw.\n" +
                "\n" +
                "Xyi hvtrvkqvrk gvfzzhvw ee vbkvvqvpp jxzqlprxzrx, tisuytxzzv, eeh jimvrupp vrmmiseqvrk zr xyi jfvd fj gcejwisfq, fjwmti, rru ces jtrgv; gfqgykmek mejiejxiytxlvv; xvetlzrx jygtfvk; eeh kieuyrxv wicpfajlztj rru rwjmjxrrkwymgw. Zx ieespvw jrglpkc eeh wkyuiexj ks etgfqgpzwy klvmi wycp tfxvrkmrp. Klv uigeixdiex mj tsewkvlgkiu ks iegfyiexi merfzrxzzv tscprffvrxzsew edsek xyi wtmvrtij, iekzrviimek, vrmmiseqvrkec jxlhzij, eeh qvhzgzrv.";
        System.out.println(decryptTwoKeys(encryptedMessage));
    }
}
