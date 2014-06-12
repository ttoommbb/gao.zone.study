package gao.zone.study.java8.lambdas;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamExamples2 {
  public static void main(String[] args) {
    List<String> words = Arrays.asList("hi", "hello", "hola", "bye", "goodbye", "adios");
    
    String combined = words.stream().reduce((s1,s2)->s1.toUpperCase()+s2.toUpperCase()).get();
    System.out.println(combined);
    
    combined = words.stream().map(String::toUpperCase).reduce(String::concat).get();
    System.out.println(combined);
    
    combined = words.stream().collect(Collectors.joining(","));
    System.out.println(combined);
    
    List<Double> doubles = randomNumberList(100);
    System.out.println(doubles);
    
    List<Integer> nums = orderedNumberList(50, 5, 50);
    System.out.println(nums);
  }
  
  
  public static List<Double> randomNumberList(int someSize){
	  return new Random().doubles(someSize).boxed().collect(toList());
  }
  
  public static List<Integer> orderedNumberList(int start, int difference, int size){
	  return IntStream.iterate(start, s->s+difference).limit(size).boxed().collect(toList());
  }
}
