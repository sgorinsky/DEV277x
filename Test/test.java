import java.util.*;

public class test {
  public static void main(String[] args) {
    /* int[][] arr = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
            if (arr[i][j] % 2 == 0) {
                System.out.println(arr[i][j]);
            }
        } */

      /* int[] anArray = new int[4];
      anArray[0] = 4;
      anArray[1] = 6;
      anArray[2] = 7;
      anArray[3] = 3;
      for(int j = 0; j < anArray.length; j++){
          System.out.print(anArray[j] + " ");
      } */

      /* int[] nums = {5, 3, 6, 8, 11, 2};
      change(nums); */

      /* int[] array = new int[10];
      array[10] = 5; */

      /* int[][] twoDArray = {{1, 2}, {3, 4}};
      for (int j = 0; j < twoDArray.length; j++) {
        for(int i = 0; i < twoDArray[0].length; i++) {
        System.out.print(twoDArray[j][i] + " ");
        }
      }
      System.out.println(Arrays.toString(twoDArray));
      System.out.println(twoDArray[0][0] + twoDArray[0][1] + twoDArray[1][0] + twoDArray[1][1]); */

      ArrayList < Integer >  numbers = new ArrayList < Integer > ();
      numbers.add(1);
      numbers.add(2);
      numbers.add(3);
      numbers.remove(2); // removes value at index 2
      numbers.set(1, 0); // index 0 = 1
      numbers.add(5);
      numbers.remove(0);
      System.out.println(numbers);
    }

    /* public static void change (int[] arr) {
    int k = arr[0];
    for (int i = 0; i < arr.length; i++) {
        if (k < arr[i]) {
            arr[0] = arr[i];
            arr[i] = k;
            k = arr[0];
        }
      }
    System.out.println(Arrays.toString(arr));
  } */
  }
