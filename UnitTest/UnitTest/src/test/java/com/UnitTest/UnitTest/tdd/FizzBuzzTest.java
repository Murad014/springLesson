package com.UnitTest.UnitTest.tdd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runners.Parameterized;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class FizzBuzzTest {
    /*
    *
    *  If number is divisible by 3, print Fizz +
    *  If number is divisible by 5, print Buzz +
    *  If number is divisible by 3 and 5, print FizzBuzz +
    *  If number is NOT divisible by 3 or 5, then print the number
    *
    * */

    private FizzBuzz fizzBuzz;

    @BeforeEach
    public void beforeEach(){
        fizzBuzz = new FizzBuzz();
    }

    @Test
    @DisplayName("Divisible by Three")
    @Order(1)
    void testForDivisibleByThree(){
        String excepted = "Fizz";
        assertEquals(excepted, fizzBuzz.fizzBuzz(9), "Must be Fizz");
    }

    @Test
    @DisplayName("Divisible by Three and Five")
    @Order(2)
    void testForDivisibleByThreeAndFive(){
        String expected = "FizzBuzz";
        assertEquals(expected, fizzBuzz.fizzBuzz(15), "Must be " + expected);
    }

    @Test
    @DisplayName("Divisible by Five")
    @Order(3)
    void testForDivisibleByFive(){
        String expected = "Buzz";
        assertEquals(expected, fizzBuzz.fizzBuzz(25), "Must be " + expected);
    }

    @Test
    @DisplayName("Divisible not by 3 or 5 ")
    @Order(4)
    void testForDivisibleNotThreeOrFive(){
        String expected = "13";
        assertEquals(expected, fizzBuzz.fizzBuzz(Integer.valueOf(expected)), "Must be " + expected);
    }



    @DisplayName("Multi Divisible Test!")
    @ParameterizedTest(name="value={0}, expected={1}")
    @CsvSource({
            "1,1",
            "2,2",
            "3,Fizz",
            "4,4",
            "5,Buzz",
            "6,Fizz",
            "7,7"
    })
    @Order(5)
    void testForMultipleDivisible(int value, String expected){
        assertEquals(expected, fizzBuzz.fizzBuzz(value));
    }

//    @Test
//    @DisplayName("Multi Divisible Test")
//    @Order(5)
//    void testForMultibleDivisible(){
//        String[][] input = new String[][]{
//                {"1", "1"},
//                {"2", "2"},
//                {"3", "Fizz"},
//                {"4", "4"},
//                {"5", "Buzz"},
//                {"6", "Fizz"},
//                {"7", "7"},
//        };
//
//        for (int i = 0; i < input.length; i++) {
//            String expected = input[i][1];
//            int ii = Integer.valueOf(input[i][0]);
//            assertEquals(expected, fizzBuzz.fizzBuzz(ii));
//        }
//
//    }



}
