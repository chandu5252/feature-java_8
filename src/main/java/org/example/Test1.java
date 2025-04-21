package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test1 {

    public static void main(String[] args) {

        List<Integer> odd= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> res= odd.stream().filter(o->o%2!=0).limit(3)
                .collect(Collectors.toList());
        System.out.println(res);
        odd.stream()
                .collect(Collectors.toMap(number-> number, number-> number*number))
                .entrySet().stream()
                .filter(num->num.getValue()>40).forEach(s->System.out.println(s));
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> sum = numbers.stream().reduce((a, b) -> a + b);
        sum.ifPresent(System.out::println); // Outputs 15

        List<String> list = Arrays.asList("a", "bb", "cccccc");
        Stream<Integer> lengths = list.stream().map(String::length);
        lengths.forEach(System.out::print); // Outputs 1, 2, 3

        List<String> list1 = Arrays.asList("Hello", "World");
        Stream<String[]> mappedStream = list1.stream()
                .map(str -> str.split(""));
        Stream<String> flatMappedStream = list1.stream()
                .flatMap(str -> Arrays.stream(str.split("")));

        Stream<Integer> parallelStream = numbers.parallelStream();
        parallelStream.forEach(System.out::println); // Elements may be printed in any order

        int zRange= 8;
        IntStream.rangeClosed(1,zRange)
                .forEach(i -> System.out.print(i + " "));
        System.out.println();
        for(int line = 2; line <= zRange-1;line++){
            int space = line;
            IntStream.rangeClosed(1,zRange)
                    .forEach(
                            j-> {
                             if(space + j == zRange + 1){
                                 System.out.print(j + " ");
                             } else{
                                 System.out.print("  ");
                             }
                            });
            System.out.println();
        }
        System.out.println();
        IntStream.rangeClosed(1,zRange)
                .forEach(i -> System.out.print(i+" "));

        System.out.println();
        String str1 = new String("InterviewBit");
        String str2 = "InterviewBit";

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

    }

    public static <T> T findMiddleUsingStreams(LinkedList<T> linkedList) {
        return linkedList.get((linkedList.stream().collect(Collectors.toList()).size())/2);
    }
}
