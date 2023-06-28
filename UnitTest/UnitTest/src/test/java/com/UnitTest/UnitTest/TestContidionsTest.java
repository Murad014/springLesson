package com.UnitTest.UnitTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class TestContidionsTest {

    TestContidions testContidions;

    @BeforeEach
    public void beforeEach(){
        this.testContidions = new TestContidions();
    }


    @Test
    @EnabledOnOs({OS.WINDOWS})
    void testOSW(){
        String expected = "Microsoft Windows";
        String actual = testContidions.windowsOS();
        assertEquals("Microsoft Windows", actual, "Must be same");
    }

    @Test
    @Disabled("This is not avaliable when finished the task #312")
    void testSimple(){
        assertEquals(2,2,"simple Test");
    }




}
