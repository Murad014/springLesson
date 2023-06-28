package com.UnitTest.UnitTest.tdd;

public class FizzBuzz {

    /*
     *
     *  If number is divisible by 3, print Fizz
     *  If number is divisible by 5, print Buzz
     *  If number is divisible by 3 and 5, print FizzBuzz
     *  If number is NOT divisible by 3 or 5, then print the number
     *
     * */

    public String fizzBuzz(int a){
        if(a % 3 == 0 && a % 5 == 0)
            return "FizzBuzz";
        else if(a % 3 == 0)
            return "Fizz";
        else if(a % 5 == 0)
            return "Buzz";

        return String.valueOf(a);
    }


//     for(int i = a; i <= b; i++){
//        if(i % 3 == 0 && i % 5 == 0)
//            System.out.println("FizzBuzz");
//        else if(i % 3 == 0)
//            System.out.println("Fizz");
//        else if(i % 5 == 0)
//            System.out.println("Buzz");
//        else
//            System.out.println(i);
//    }



}
