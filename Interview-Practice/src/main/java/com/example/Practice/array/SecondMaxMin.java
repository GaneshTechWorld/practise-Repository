package com.example.Practice.array;

import java.util.Arrays;

public class SecondMaxMin {

    public int secondMaxElement(int [] arr){
        int maxElement = Arrays.stream(arr).max().getAsInt();
        int secondMaxElement = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i] == maxElement){
                secondMaxElement = arr[i-1];
                break;
            }
        }
        return secondMaxElement;
    }

    public int secondMinElement(int [] ar){
        int minElement = Arrays.stream(ar).min().getAsInt();
        for(int i=1;i<ar.length;i++){
            if(ar[i] == minElement){
                minElement = ar[i+1];
            }
        }
        return minElement;
    }

    public static void main(String args[]){
        int ar[] = {-2,-34,9,5,4,2,56};
        Arrays.sort(ar);
        SecondMaxMin ele = new SecondMaxMin();
        System.out.println("Second Max Element Is :"+ele.secondMaxElement(ar));
        System.out.println("Second Min Element Is :"+ele.secondMinElement(ar));
    }
}
