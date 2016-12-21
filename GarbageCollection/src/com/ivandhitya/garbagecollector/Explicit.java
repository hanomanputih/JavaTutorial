package com.ivandhitya.garbagecollector;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by iaprasetya on 12/20/2016.
 */
public class Explicit extends SuperClass{
    int i;

    public Explicit(int i) {
        this.i = i;
    }

//    @Override
//    protected void poke(){
//        System.out.println("poke Explicit");
//    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("From Finalize Method, i = " + i);
    }
}


class MainExplicit {
    public static void main(String[] args) throws Throwable {
        //Creating two instances of class A
        for (int i = 0; i <= 5; i++) {
            Explicit a1 = new Explicit(10);

            Explicit a2 = new Explicit(20);

            //Assigning a2 to a1
            System.out.println();

            a1 = a2;
            System.out.println(a1.i + " " + a2.i);
//        Explicit a3 = new Explicit(30);
            a1 = null;
            a2 = null;
            //Now both a1 and a2 will be pointing same object

            //An object earlier referred by a1 will become abandoned

            //Calling garbage collector thread explicitly
//          a1.poke();
            System.out.println("start GC");

//            a1.finalize();         //ignored by garbage collector

            //Must use either:
            System.gc();              //OR call Runtime.getRuntime().gc();

            System.out.println("done");
        }
    }
}