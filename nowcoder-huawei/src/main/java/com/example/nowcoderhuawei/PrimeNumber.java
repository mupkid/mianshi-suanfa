package com.example.nowcoderhuawei;

/**
 * 求素数
 */
public class PrimeNumber {
    public static void main(String[] args) {
        new PrimeNumber().test1(100000);
        new PrimeNumber().test2(100000);
        new PrimeNumber().test3(100000);
        new PrimeNumber().test4(100000);
        new PrimeNumber().test5(100000);
        new PrimeNumber().test6(100000);
    }

    public void test1(int n) {
        long start = System.currentTimeMillis();
        int num = 0;
        boolean sign;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0 && i != 2) {
                continue;
            }
            sign = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    sign = false;
                    break;
                }
            }
            if (sign) {
                num++;
                //System.out.println("" + i);
            }
        }
        System.out.println(n + "以内的素数有" + num + "个");
        long end = System.currentTimeMillis();
        System.out.println("The time cost is " + (end - start));
    }

    public void test2(int n) {
        long start = System.currentTimeMillis();
        int num = 0;
        boolean sign;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0 && i != 2) {
                continue;
            }
            sign = true;
            for (int j = 2; j < i / 2; j++) {
                if (i % j == 0) {
                    sign = false;
                    break;
                }
            }
            if (sign) {
                num++;
                //System.out.println("" + i);
            }
        }
        System.out.println(n + "以内的素数有" + num + "个");
        long end = System.currentTimeMillis();
        System.out.println("The time cost is " + (end - start));
    }

    public void test3(int n) {
        long start = System.currentTimeMillis();
        int num = 0;
        boolean sign;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0 && i != 2) {
                continue;
            }
            sign = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    sign = false;
                    break;
                }
            }
            if (sign) {
                num++;
                //System.out.println("" + i);
            }
        }
        System.out.println(n + "以内的素数有" + num + "个");
        long end = System.currentTimeMillis();
        System.out.println("The time cost is " + (end - start));
    }

    public void test4(int n) {
        long start = System.currentTimeMillis();
        int sum = 0;
        int[] num = new int[n];
        num[0] = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i * i; j <= n; j += i) {
                num[j - 1] = 1;
            }
        }
        for (int j : num) {
            if (j == 0) {
                sum++;
            }
        }
        System.out.println(n + "以内的素数有" + sum + "个");
        long end = System.currentTimeMillis();
        System.out.println("The time cost is " + (end - start));
    }

    public void test5(int n) {
        long start = System.currentTimeMillis();
        if (n <= 1) {
            System.out.println(n + "以内的素数有0个");
            long end = System.currentTimeMillis();
            System.out.println("The time cost is " + (end - start));
            return;
        } else if (n == 2) {
            System.out.println(n + "以内的素数有1个");
            long end = System.currentTimeMillis();
            System.out.println("The time cost is " + (end - start));
            return;
        }
        int sum = 1;
        for (int i = 3; i < n; i += 2) {
            boolean sign = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    sign = false;
                    break;
                }
            }
            if (sign) {
                sum++;
                //System.out.println("" + i);
            }
        }
        System.out.println(n + "以内的素数有" + sum + "个");
        long end = System.currentTimeMillis();
        System.out.println("The time cost is " + (end - start));
    }

    public void test6(int n) {
        long start = System.currentTimeMillis();
        boolean[] isPrime = new boolean[n];
        int sum = 0;
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                for (int j = 2; i * j < n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (isPrime[i]) {
                sum++;
            }
        }
        System.out.println(n + "以内的素数有" + sum + "个");
        long end = System.currentTimeMillis();
        System.out.println("The time cost is " + (end - start));
    }
}
