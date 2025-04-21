    package org.example;

    import javafx.print.Collation;

    import java.util.*;
    import java.util.function.Function;
    import java.util.stream.Collectors;
    import java.util.stream.IntStream;
    import java.util.stream.LongStream;

    public class TestPractice {
        public static void main(String[] args) {

            String s1="chanda";
            String s2="chanda";
            String s3=s2;
            String s4= new String("chanda");
            String s5= new String(s4);
            String s6= new String(s1);

            System.out.println(s1==s2);
            System.out.println(s1==s3);
            System.out.println(s4==s1);
            System.out.println(s6==s1);
            System.out.println(s5==s4);
            System.out.println("equals");
            System.out.println(s4.hashCode()==s1.hashCode());

            System.out.println(s1.equals(s2));
            System.out.println(s1.equals(s3));
            System.out.println(s4.equals(s1));
            System.out.println(s6.equals(s1));
            System.out.println(s5.equals(s4));



           System.out.println("------------------------ReverceOrder String--------------------------");
        String line="I am chanda";
            String output="adnahc ma I";
            Arrays.stream(line.split(""))
                    .sorted(Collections.reverseOrder())
                    .forEach(System.out::print);
            List<Integer> a = Arrays.asList(5,6,7,8,3,2);
            a.stream().sorted(Collections.reverseOrder())
                    .forEach(System.out::print);
            //List<Character> ar = line.to
            System.out.println("------------------------Reverce: ");
            System.out.println("------------------------Reverce String--------------------------");
            int len = line.length();
            IntStream.range(0, len)
                    .map(i -> len - 1 - i)
                    .mapToObj(j->line.charAt(j))
                    .forEach(System.out::print);
            System.out.println("------------------------factorial--------------------------");
            System.out.println(LongStream.rangeClosed(1,5).reduce(1,(x,y)->x*y));
            System.out.println("------------------------EvenOdd--------------------------");
            System.out.println(a.stream().collect(Collectors.partitioningBy(n->n%2==0)));
            System.out.println("------------------------Occurrence--------------------------");
            List<String> fruits = Arrays.asList("Apple","berry","Apple","Apple","Apple","mango","banana");

            Map<Character, Long> characterCount = fruits.stream()
                    .flatMapToInt(String::chars) // Flatten the list of strings to a stream of characters
                    .mapToObj(c -> (char) c) // Convert intStream to Stream<Character>
                    .collect(Collectors.groupingBy(c -> c, Collectors.counting())); // Count occurrences of each character

            System.out.println("Character Occurrence:"+ characterCount.toString());
            System.out.println("print 1 to 10 prime number using java8");
    IntStream.rangeClosed(2,20).filter(TestPractice::isPrime).forEach(System.out::println);
            Map<String, Long> stringCount =
                    fruits.stream().
                    collect(Collectors.groupingBy(
                            s -> s, Collectors.counting()));
            System.out.println("stringCount Occurrence:"+ stringCount);

            characterCount.forEach((character, count) ->
                    System.out.println(character + ": " + count));
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            System.out.println("Cube:");
            numbers.stream().map(in->in*in*in)
                    .forEach(System.out::println);








            /*Given a sorted array consisting of only integers where every element appears
        exactly twice except for one element which appears exactly once.
        Write an algorithm to find that single element. Assume the input array cannot be empty.*/
            List<Integer> ae = Arrays.asList(1,2,2,2,3,4,4);
            Map<Integer, Long> occurrences = ae.stream()
                    .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
            System.out.println(occurrences);
          HashMap<Integer,Integer> out=new HashMap<>();
        for(int i=0;i<ae.size();i++){
            int count=0;
            for(int j=0;j<ae.size();j++){
                if(ae.get(i)==ae.get(j)){
                    count++;
                   // a.set(i,0);
            }
            }
            out.put(ae.get(i),count);
        }
            System.out.println(out.containsValue(1));

    //        IntStream intStream = IntStream.rangeClosed(1, 5).filter(i -> i * 1).forEach(so);
            System.out.println();
            int n = 8; // replace with desired value of N
            IntStream.rangeClosed(1, n)
                    .forEach(i -> System.out.print(i + " "));
            System.out.println(); // move to next line

            // print top diagonal of Z pattern
            for (int c = 2; c <= n - 1; c++) {
                int box = c;
                IntStream.rangeClosed(1, n)
                        .forEach(j -> {
                    if (box + j == n + 1) {
                        System.out.print(j + " ");
                    } else {System.out.print("  "); // print spaces for other positions
                    }
                });
                System.out.println(); // move to next line
            }

            IntStream.rangeClosed(1, n).forEach(i -> System.out.print(i + " "));

            System.out.println();
            IntStream.rangeClosed(1, n)
                    .forEach(i -> System.out.print(i + " "));
            System.out.println();
            for(int k=2;k<=n-1;k++){
                int b = k;
                IntStream.rangeClosed(1,n)
                        .forEach(m -> {
                            if (b + m == n + 1) {
                                System.out.print(m + " ");
                            } else {System.out.print("  "); // print spaces for other positions
                            }
                });
                System.out.println();
            }
        }

        private static boolean isPrime(int i) {
        return IntStream.rangeClosed(2,(int) Math.sqrt(i)).allMatch(n->i%n!=0);
        }
    }
