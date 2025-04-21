package org.example;

import org.springframework.boot.SpringApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Child extends Parent{
    static void print(){
        System.out.println("child");
    }

    static
    {
        System.out.println("SECOND");
    }

    public static void main(String[] args) {
        List<String> stationeryList = Arrays.asList("Pen", "Eraser",
                "Note Book", "Pen", "Pencil", "Stapler", "Note Book",
                "Pencil");
        Child c = new Child();

    Map<String, Long> freq =
            stationeryList.stream()
                    .collect(Collectors.groupingBy(
                            s->s,Collectors.counting()));

    System.out.println(freq);
    }
}

