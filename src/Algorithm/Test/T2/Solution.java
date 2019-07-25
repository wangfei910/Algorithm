package Algorithm.Test.T2;

import java.util.Scanner;

/**
 * 加减二叉树
 *
 * @author: wangfei
 * @date: 2019/4/5 17:25
 */
public class Solution {

    /**
     * 所有n都不大于2^k。考虑到n等于2^k时，一直往左走最后一步往右走。n等于2^k-1时一直往左走。
     * n等于2^k-d时，分d是奇数偶数讨论最后一步的走法（奇左偶右），前面k-1步一直往左走，
     * 令减去的值刚好等于d/2向下取整。
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            String str1 = in.next();
            String str2 = in.next();
        }
    }



//    #include <bits/stdc++.h.h>
//
//    using namespace std;
//
//    int main() {
//        long long n, k, a, d, b, i;
//        scanf("%lld%lld", &n, &k);
//        a = 1LL<<k;
//        d = a - n;
//        b = d / 2;
//        for(i = 0; i < k; i++) {
//            if((1LL<<i) & b)printf("%lld -\n",(1LL<<i));
//		else {
//                if(i == k - 1) {
//                    if(d & 1) printf("%lld +\n",(1LL<<i));
//				else printf("%lld +\n",(1LL<<i)+1LL);
//                }
//                else printf("%lld +\n",(1LL<<i));
//            }
//        }
//        return 0;
//    }
}
