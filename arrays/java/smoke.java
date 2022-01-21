package Array;

import java.util.Scanner;

public class smoke {
    public static boolean zeroSmoker(int[][] arr) {
        for(int i=0;i<3;i++){
            for (int j = 0; j < 3; j++) {
                if(arr[i][j]==0);
                return true ;
            }
        }
        return false;
    }
    public static boolean isEveryoneSmoker(int[][] arr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        int[][] arr2 = new int[3][3];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int numberOfDays = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr2[i][j] = arr[i][j];
            }
        }


        while (!isEveryoneSmoker(arr) && !zeroSmoker(arr)) {
            numberOfDays++;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (arr[i][j] == 1) {
                        if (i - 1 >= 0)
                            arr2[i - 1][j] = 1; // LEFT
                        if (i + 1 < 3)
                            arr2[i + 1][j] = 1; // RIGHT
                        if (j - 1 >= 0)
                            arr2[i][j - 1] = 1; // TOP
                        if (j + 1 < 3)
                            arr2[i][j + 1] = 1; // BOTTOM
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = arr2[i][j];
                }
            }
        }
        System.out.println("elememts of array are: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Number of days = " + numberOfDays);
        sc.close();
    }
}
