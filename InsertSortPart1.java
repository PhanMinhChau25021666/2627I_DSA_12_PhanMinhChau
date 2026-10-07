import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class InsertSortPart1 {

    public static void insertionSort1(int n, List<Integer> arr) {
        int store = arr.get(n-1);
        for (int i = n-1; i > 0; i--){
            if (store < arr.get(i-1)){
               arr.set(i, arr.get(i-1)) ;
               for (int x : arr){
                System.out.print(x + " ");
               }
               System.out.println();
            } 
            if (store >= arr.get(i-1)) {
                arr.set(i, store);
                for (int x : arr){
                System.out.print(x + " ");
               }
               System.out.println();
                return;
            }
        }
        arr.set(0, store);
        for (int x : arr){
                System.out.print(x + " ");
        }
        System.out.println();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
