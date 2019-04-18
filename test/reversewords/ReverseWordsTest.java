/*
 * ReverseWordsTest.java
 * Create Date: Apr 18, 2019
 * Initial-Author: Janos Aron Kiss
 */
package reversewords;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import javax.annotation.Nonnull;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Janos Aron Kiss
 */
public class ReverseWordsTest {
    
    private static final String TEST_CASE_INPUT_1 = "word1 word2 word3";
    private static final String TEST_CASE_OUTPUT_1 = "1drow 2drow 3drow";
    
    private static final String TEST_CASE_INPUT_2 = "another sentence";
    private static final String TEST_CASE_OUTPUT_2 = "rehtona ecnetnes";

    public ReverseWordsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class ReverseWords.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        testCase(
                TEST_CASE_INPUT_1 + System.lineSeparator() + TEST_CASE_INPUT_2,
                TEST_CASE_OUTPUT_1 + System.lineSeparator() + TEST_CASE_OUTPUT_2 + System.lineSeparator()
        );
    }
    
    private void testCase(@Nonnull String input, @Nonnull String output) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        
        ReverseWords rw = new ReverseWords();
        rw.readSentences(inputStream);
        rw.printSentences(outputStream);
        
        assertEquals(new String(outputStream.toByteArray(), StandardCharsets.UTF_8), output);
    }

    /**
     * Test of reverseWords method, of class ReverseWords.
     */
    @Test
    public void testReverseWords() {
        System.out.println("reverseWords");
        ReverseWords rw = new ReverseWords();
        assertEquals(TEST_CASE_OUTPUT_1, rw.reverseWords(TEST_CASE_INPUT_1));
        assertEquals(TEST_CASE_OUTPUT_2, rw.reverseWords(TEST_CASE_INPUT_2));
    }
    
}
