package org.codingdojo;

import org.junit.Test;

import static org.codingdojo.Wrapper.*;
import static org.junit.Assert.*;

public class WrapperTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullInput() {
        fun(null, 0);
    }

    @Test
    public void testNonWrappingInput() {
        assertEquals(fun("blahblah", 10),"blahblah");
    }

    @Test
    public void testSingleWrap() {
        assertEquals(fun("Hello world", 5),"Hello\nworld");
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
}