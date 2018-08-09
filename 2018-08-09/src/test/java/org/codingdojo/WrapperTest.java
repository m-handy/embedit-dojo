package org.codingdojo;

import org.junit.Test;

import static org.codingdojo.Wrapper.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class WrapperTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullInput() {
        fun(null, 0);
    }

    @Test
    public void testNonWrappingInput() {
        assertEquals(fun("blahblah", 10), "blahblah");
    }

    @Test
    public void testSingleWrap() {
        assertEquals(fun("Hello world", 5), "Hello\nworld");
    }

    @Test
    public void testMultipleWrap() {
        assertEquals(fun("Hello world Hello", 5), "Hello\nworld\nHello");
    }

    @Test
    public void testMultipleWordsOnLineWrap() {
        assertEquals(fun("Hello world Hello", 11), "Hello world\nHello");
    }

    @Test
    public void testMultipleWordsOnLine2Wrap() {
        assertEquals(fun("Hello world Hello world", 11), "Hello world\nHello world");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeLength() {
        fun("Hello world Hello world", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroLength() {
        fun("Hello world Hello world", 0);
    }

    @Test
    public void testMultiWrap() {
        assertThat(fun("a baa c", 2), is("a\nb-\naa\nc"));
    }

    @Test
    public void testMultiWrap2() {
        assertThat(fun("a baaaa c", 3), is("a\nba-\naaa\nc"));
    }

    @Test
    public void testMultiWrap3() {
        assertThat(fun("aaaa", 2), is("a-\na-\naa"));
    }

    @Test
    public void testNewLine() {
        assertThat(fun("a\nahoj c", 3), is("a\nah-\noj\nc"));
    }

}