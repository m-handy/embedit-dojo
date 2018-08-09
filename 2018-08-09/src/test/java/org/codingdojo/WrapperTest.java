package org.codingdojo;

import org.junit.Test;

import static org.codingdojo.Wrapper.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class WrapperTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullInput() {
        wrapString(null, 0);
    }

    @Test
    public void testNonWrappingInput() {
        assertEquals(wrapString("blahblah", 10), "blahblah");
    }

    @Test
    public void testSingleWrap() {
        assertEquals(wrapString("Hello world", 5), "Hello\nworld");
    }

    @Test
    public void testMultipleWrap() {
        assertEquals(wrapString("Hello world Hello", 5), "Hello\nworld\nHello");
    }

    @Test
    public void testMultipleWordsOnLineWrap() {
        assertEquals(wrapString("Hello world Hello", 11), "Hello world\nHello");
    }

    @Test
    public void testMultipleWordsOnLine2Wrap() {
        assertEquals(wrapString("Hello world Hello world", 11), "Hello world\nHello world");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeLength() {
        wrapString("Hello world Hello world", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroLength() {
        wrapString("Hello world Hello world", 0);
    }

    @Test
    public void testMultiWrap() {
        assertThat(wrapString("a baa c", 2), is("a\nb-\naa\nc"));
    }

    @Test
    public void testMultiWrap2() {
        assertThat(wrapString("a baaaa c", 3), is("a\nba-\naaa\nc"));
    }

    @Test
    public void testMultiWrap3() {
        assertThat(wrapString("aaaa", 2), is("a-\na-\naa"));
    }

    @Test
    public void testNewLine() {
        assertThat(wrapString("a\nahoj c", 3), is("a\nah-\noj\nc"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLength1() {
        wrapString("aaaaa", 1);
    }

    @Test
    public void testEmptyString() {
        assertThat(wrapString("", 2), is(""));
    }
}