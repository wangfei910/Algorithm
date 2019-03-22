package Algorithm.Offer.Test;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            String str1 = in.next();
            String str2 = in.next();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int temp = Math.abs(str1.charAt(i) - str2.charAt(i));
                if (temp <= 5) {
                    sum += temp;
                } else {
                    sum += (10 - temp);
                }
            }
            System.out.println(sum);
        }
    }
}

