public class replacer {
    public static void main(String[] args) {
        String sentence = "Java is a powerful programming language.";
        String wordToReplace = "powerful";
        String replacementWord = "versatile";
        
        String updatedSentence = replaceWord(sentence, wordToReplace, replacementWord);        
        System.out.println("Original Sentence: " + sentence);
        System.out.println("Updated Sentence: " + updatedSentence);
    }
}    
