package com.example.Practice.string;

import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.*;

@Component
public class RemoveDuplicates {
    public static Integer[] removeDuplicate(Integer [] arr){
       List<Integer> arrList = Arrays.asList(arr);
       HashSet<Integer> set = new HashSet<>(arrList);
       Integer [] newArr = set.toArray(new Integer[0]);
       return  newArr;
    }
    public static void main(String args[]){
        Integer[] array = {1, 2, 3, 1, 2, 4, 5, 6, 4, 7};
        Integer[] uniqueArray = removeDuplicate(array);

        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println("Array with duplicates removed: " + Arrays.toString(uniqueArray));
    }
}
