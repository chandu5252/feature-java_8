package org.example.study;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Streams {

    public static void main(String args[]){
        String occure = "iam chandak ja v adeve loper";
        charOccureInString(occure);
        duplicateInString(occure);
        int a[]={4,3,5,6,2,1,4,4,5,5,6,1};
        int b[]={5,6,10,50,3,20};
        findSecondHighest(a);
        System.out.println(" separate odd and even numbers ");
        seperateEvenOdd(a);
        removeDuplicates(a);
        showCountInt(a);
        reverseOrderOfBoth(a,occure);
        System.out.println("Given a list of strings, join the strings with ‘[‘ as prefix" +
                ", ‘]’ as suffix and ‘,’ as delimiter?");
        splitSuffixPrefixDelimiter();
        multiplesOfNum(b);
        mergeArray(a,b);
        limitMinMax(b);
        duplicatesInInt(a,b);
        pairAdditionAndTargetMatch();

        String word = "madam";
        String collect =IntStream.rangeClosed(1, word.length())
                .mapToObj(i -> word.charAt(word.length() - i))
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(word+ "Palindrom "+collect+ " :" +word.equals(collect));
    }

    private static void pairAdditionAndTargetMatch() {
        int a[]={1,2,3,4,5};
        int k=7;
        // find the pair add the value match the target
        IntStream.range(0, a.length).boxed()
                .flatMap(i -> IntStream.range(i + 1, a.length)
                        .filter(j -> a[i] + a[j] == 7)
                        .mapToObj(j -> new int[]{a[i], a[j]})
                ).forEach(p->System.out.println(p[0]+","+p[1]));
    }

    private static void duplicatesInInt(int[] a, int[] b) {
        Arrays.stream(b).filter(
                Arrays.stream(a).boxed()
                        .collect(Collectors.toList())::contains);
    }

    private static void limitMinMax(int[] b) {
        Arrays.stream(b).sorted().limit(3)
                .forEach(System.out::println);

        Arrays.stream(b).boxed().sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(System.out::println);
    }

    private static void mergeArray(int[] a, int[] b) {
        IntStream.concat(Arrays.stream(a), Arrays.stream(b))
                .sorted().distinct().forEach(System.out::println);
    }

    private static void multiplesOfNum(int[] a) {
        IntStream.rangeClosed(1,10).map(i->i*5)
                .forEach(System.out::println);

        Arrays.stream(a).filter(i->i%5==0)
                .forEach(System.out::print);
    }

    private static void splitSuffixPrefixDelimiter() {
        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        String collect = listOfStrings.stream()
                .collect(Collectors
                        .joining(", ", "[", "]"));
        System.out.println(collect);
    }

    private static void reverseOrderOfBoth(int[] a, String occure) {
        List<Integer> sorted = Arrays.stream(a).boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("reverseOrderOfBoth"+sorted);
        System.out.println(Arrays.stream(occure.split(""))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList()));
    }

    private static void showCountInt(int[] a) {
        Map<Integer, Long> collect = Arrays.stream(a)
                .boxed().collect(
                        Collectors.groupingBy(
                                s -> s, Collectors.counting()));
        System.out.println("showCountInt: "+ collect);

        List<Integer> integerList = Arrays.stream(a)
                .boxed().collect(
                        Collectors.groupingBy(
                                s -> s, Collectors.counting()))
                .entrySet().stream()
                .filter(s -> s.getValue() > 2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("showCountInt with condition: "+ integerList);
    }

    private static void removeDuplicates(int[] a) {
        List<Integer> integerList = Arrays.stream(a).boxed()
                .distinct().sorted()
                .collect(Collectors.toList());
        System.out.println("removeDuplicates: \n"+ integerList);
    }

    private static void seperateEvenOdd(int[] a) {
        Map<Boolean, List<Integer>> collect =
                Arrays.stream(a)
                        .boxed()
                        .collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("Odd"+ collect.get(false));
        System.out.println("Even"+ collect.get(true));
    }

    private static void findSecondHighest(int[] a) {
        List<Integer> integerList = Arrays.stream(a).boxed().distinct()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("reverseOrder :"+integerList);

        System.out.println(
                Arrays.stream(a)
                .boxed()
                .collect(
                        Collectors.groupingBy(s-> s, Collectors.counting())));

        System.out.println(Arrays.stream(a).sum());

        System.out.println("factorial:" + IntStream
                .rangeClosed(1,5).reduce(1,(x,y)-> x*y));

        Integer integer = Arrays.stream(a)
                .distinct()
                .boxed()
                .sorted(Collections.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println("findSecondHighest :"+integer);
    }

    private static void charOccureInString(String occure){
        Map<String, Long> map=
                Arrays.stream(occure.split(""))
                .collect(Collectors.groupingBy(s-> s,Collectors.counting()));
        System.out.println("occurance" + map);
        String s = new String("I am wealthy I am class");

        Map<String, Long> collect = Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(
                        i -> i, Collectors.counting()));
        System.out.println(collect);

        String s1 = Arrays.stream(s.split(" "))
                .reduce((x, y) -> x.length() > y.length() ? x : y)
                .get();
        System.out.println("reduce: "+s1);

    }

    private static void duplicateInString(String occure){

        List<String> entryStream =
                Arrays.stream(occure.split(""))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .filter(key -> key.getValue() > 1)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());

        System.out.println("duplicates: " + entryStream);
        Arrays.stream(occure.split(""))
                .collect(Collectors.groupingBy(h-> h,Collectors.counting()))
                .entrySet().stream()
                .filter(v->v.getValue()==1)
                .map(Map.Entry::getKey).collect(Collectors.toList());

        /*1st non repeat element*/
        String key1 = Arrays.stream(occure.split(""))
                .collect(
                        Collectors.groupingBy(
                                Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(key -> key.getValue() == 1)
                .findFirst().get().getKey();
        System.out.println("1st non repeat element: " + key1);
    }
}
