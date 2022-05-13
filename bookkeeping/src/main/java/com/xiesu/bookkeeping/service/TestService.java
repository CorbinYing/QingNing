package com.xiesu.bookkeeping.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public  class TestService {



//
//    @Transactional()
//    public String get(String o){
//        return o;
//    }
//    static int a;
////static int b(){
////    static int c=0;
////}
//
////int static d =0;


    static int []arr=new int[5];
    public static void main(String[] args) {

        int x=3,y=6,a=0;
        while(x++!=(y-=1)){
            a+=1;
            if (y<x)
                break;
        }
        System.out.println(x);
        System.out.println(y);
        System.out.println(a);

        int i,b;
        i=3;b=i++;
        System.out.println(b);

        System.out.println(arr[0]);



        String [] s=new String[5];
        System.out.println(s[0]);
        System.out.println(s.length);
        System.out.println();


        System.out.println("------------------");
        System.out.println("abcd" instanceof Object);


        System.out.println(new TestService().f(2,3));



        Persion persion;
        Teacher t=new Teacher();
        Struden struden=new Struden();

        if (t instanceof Persion){
//            persion=(Struden)t;
        }

    }


int f(int x,int y){
        if (x==0) return y+2;
        if ((y==0)) return f(x-1,1);
        return f(x-1,f(x,y-1));
}









}
