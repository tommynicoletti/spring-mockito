package com.baeldung;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class StringIncrementorTest {
    private StringIncrementor incrementor=new StringIncrementor();;

    @Test
    public void tokenizeAndIncrement_ShouldReturnStringWith999And1000_WhenStringWith998And999IsPassed() {
        String testString="Once upon a time I had 998 cats, now they are 999";
        String outputString="Once upon a time I had 999 cats, now they are 1000";
        assertEquals(outputString,this.incrementor.tokenizeAndIncrement(testString));
    }

    @Test
    public void tokenizeAndIncrement_ShouldIncrementNumbers_WhenStringContainsNegativeNumbers() {
        String testString="Today it's freaking -5° cold";
        String outputString="Today it's freaking -4° cold";
        assertEquals(outputString,this.incrementor.tokenizeAndIncrement(testString));
    }
    @Test
    public void tokenizeAndIncrement_ShouldReturnString43_WhenString42IsPassed() {
        String testString="42";
        String outputString="43";
        assertEquals(outputString,this.incrementor.tokenizeAndIncrement(testString));
    }

    @Test
    public void tokenizeAndIncrement_ShouldIncrementNumbers_WhenWordsContainNumbers() {
        String testString="I was at bar101 yesterday";
        String outputString="I was at bar102 yesterday";
        assertEquals(outputString,this.incrementor.tokenizeAndIncrement(testString));
    }

    @Test
    public void tokenizeAndIncrement_ShouldPreserveSpaces() {
        String testString="It was a rainy     day";
        String outputString="It was a rainy     day";
        assertEquals(outputString,this.incrementor.tokenizeAndIncrement(testString));
    }

}