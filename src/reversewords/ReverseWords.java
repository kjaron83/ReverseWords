/*
 * ReverseWords.java
 * Create Date: Apr 18, 2019
 * Initial-Author: Janos Aron Kiss
 */
package reversewords;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.annotation.Nonnull;

/**
 * This class reverses the characters in the words of an input sentence.
 * @author Janos Aron Kiss
 */
public class ReverseWords {

    private final List<String> sentences = new ArrayList<>();

    /**
     * Reads lines from the STDIN and prints the results to the STDOUT.
     * @param args the command line arguments
     */
    public static void main(@Nonnull String[] args) {
        ReverseWords rw = new ReverseWords();
        rw.readSentences(System.in);
        rw.printSentences(System.out);
    }
    
    /**
     * Reads lines from the InputStream until an empty line.
     * @param input InputStream to read.
     */
    public void readSentences(@Nonnull InputStream input) {
        Scanner scanner = new Scanner(input);
        String sentence;
        while ( scanner.hasNextLine() ) {
            sentence = scanner.nextLine().trim();
            if ( sentence.isEmpty() )
                break;
            sentences.add(sentence);
        }
    }
    
    /**
     * Prints out the lines to the OutputStream while reversing the characters in words.
     * @param output OutputStream to write.
     */
    public void printSentences(@Nonnull OutputStream output) {
        PrintStream printer = new PrintStream(output);
        for ( String sentence : sentences )
            printer.println(reverseWords(sentence));
    }
    
    /**
     * Reverses the words in a sentence and returns the result.
     */
    @Nonnull
    public String reverseWords(@Nonnull String sentence) {
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();        
        char c;

        for ( int i = 0; i < sentence.length(); i++ ) {
            c = sentence.charAt(i);
            if ( Character.isLetterOrDigit(c) )
                word.append(c);
            else {
                result.append(word.reverse());
                word.setLength(0);
                result.append(c);
            }            
        }            

        if ( word.length() > 0 )
            result.append(word.reverse());
        
        return result.toString();
    }    
    
}
