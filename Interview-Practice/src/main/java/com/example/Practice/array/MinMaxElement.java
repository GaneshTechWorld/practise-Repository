package com.example.Practice.array;

import java.util.Arrays;
import java.util.OptionalInt;
public class MinMaxElement {
    public int getMaxElement(int[] arr){
       OptionalInt num = Arrays.stream(arr).max();
       return num.getAsInt();
        //List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public int getMinElement(int arr[]){
       OptionalInt number =  Arrays.stream(arr).min();
       return number.getAsInt();
    }

    public static void main(String args[]){
        int ar[] = {0,1,2,3,4,77,98,-89};
        MinMaxElement ele = new MinMaxElement();
        System.out.println("MaxElement Is :"+ele.getMaxElement(ar));
        System.out.println("Min Element Is :"+ele.getMinElement(ar));
    }
}
