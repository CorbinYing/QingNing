package com.xiesu.commonutils.excrise;

public class A {


    static void foo(String text){
        text="win";
        System.out.println(text.hashCode());
    }



    public static void mainrt(String[] args) {
        String str="linux";
        str+='a';
        foo(str);
        System.out.println(str.hashCode());
    }


    static int arr[]=new int[6];
    public static void main(String[] args) {
        System.out.println(arr[0]);
        int x=4;
        System.out.println("valueis"+((x>4)?99.9:9));
        System.out.println(x);
String str[] =new String[3];

    }
}
