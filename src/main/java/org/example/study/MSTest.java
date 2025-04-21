package org.example.study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MSTest {
    public static void main(String[] args) {

//        7
//        8 7
//        7 8 7
//        8 7 8 7'
// number-- space

        int i = 8;
        IntStream.rangeClosed(1, 4)
                .forEach(n ->{
                        IntStream.rangeClosed(1, n)
                                .mapToObj(j -> {
                                    if (j%2==0) {
                                        return 8;
                                    } else{
                                        return 7;
                                    }
                                })
                                .forEach(
                                        print -> System.out.print(print + " "));
                System.out.println();});
    }
}
