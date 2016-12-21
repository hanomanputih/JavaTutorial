package com.ivandhitya.garbagecollector;

/**
 * Created by iaprasetya on 12/20/2016.
 */
public class Implicit {

    int i = 50;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("From Finalize Method");
    }
}

class MainImplicit {
    public static void main(String[] args) {
        //Creating two instances of class A

        Implicit a1 = new Implicit();

        Implicit a2 = new Implicit();

        //Assigning a2 to a1

        a1 = a2;

        //Making finalize() method to execute forcefully

        Runtime.getRuntime().runFinalization();

        System.out.println("done");
    }
}
