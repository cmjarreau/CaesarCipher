import edu.duke.FileResource;



public class WordLengths {
    public void countWordLengths(FileResource resource, int[] counts) {
        // This method should read in the words from resource and
        // count the number of words of each length for all the
        // words in resource, storing these counts in the array counts

        // count the words of each length 1, 2, 3, 4, ...

        String fileContents = resource.asString();
        int length = 1;
        for (int i = 0; i < fileContents.length(); i++) {
            // test if the character is a letter
            // if it is a letter, keep counting.
            // if its not a letter, its a word and need to index its length
            if (fileContents.charAt(i) == '\'' || Character.isLetter(fileContents.charAt(i))) {
                //special case for embark'd
                length++;
            } else {
                length--;
                counts[length] += 1;
                length = 1;
            }
        }

        for (int i = 2; i < counts.length; i++) {
            if (counts[i] != 0) {
                System.out.format("%d words of length %d\n", counts[i], i);
            }
        }
        System.out.println("index of max: " + indexOfMax(counts));
    }

    public void testCountWordLengths() {
        FileResource fr = new FileResource();
        int[] counts = new int[31];
        countWordLengths(fr, counts);

    }

    public int indexOfMax(int[] values) {
        //This method returns the index position of the largest element in values
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = i;
            }
        }
        return max;
    }
}
