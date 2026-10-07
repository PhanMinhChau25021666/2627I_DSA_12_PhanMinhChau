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

class InsertionSortPart2 {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */
    private static void print(List<Integer> arr){
        for (int x : arr){
            System.out.print(x + " ");
        }
        System.out.println();
    }
    public static void insertionSort2(int n, List<Integer> arr) {
        int store;
        for (int i = 1; i < n; i++){
            store = arr.get(i);
            if (store > arr.get(i-1)) print(arr);
            else{
                for (int j = i - 1; j >= 0; j--){
                    if (store < arr.get(j)){
                        arr.set(j+1, arr.get(j));
                        if (j == 0) arr.set(0, store);
                    }else {
                        arr.set(j+1, store);
                        break;
                    }
                }
                print(arr);
                
            } 
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort2(n, arr);

        bufferedReader.close();
    }
}
