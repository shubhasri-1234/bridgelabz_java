public class WordFrequencyCounter {
    public static void main(String[] args) {
        // Example 1: Frequency of words in a sentence
        String sentence = "To be or not to be";
        HashTable wordFrequencyTable = new HashTable();

        String[] words = sentence.split("\\s+");
        for (String word : words) {
            wordFrequencyTable.insert(word);
        }

        System.out.println("Word frequencies in the sentence:");
        wordFrequencyTable.display();

        // Example 2: Frequency of words in a large paragraph
        String paragraph = "Paranoids are not paranoid because they are paranoid but " +
                           "because they keep putting themselves deliberately into paranoid avoidable situations";
        HashTable paragraphFrequencyTable = new HashTable();

        String[] paragraphWords = paragraph.split("\\s+");
        for (String word : paragraphWords) {
            paragraphFrequencyTable.insert(word);
        }

        System.out.println("\nWord frequencies in the paragraph:");
        paragraphFrequencyTable.display();

        // Example 3: Remove a specific word from the paragraph
        String wordToRemove = "avoidable";
        paragraphFrequencyTable.remove(wordToRemove);

        System.out.println("\nWord frequencies after removing '" + wordToRemove + "':");
        paragraphFrequencyTable.display();
    }
}