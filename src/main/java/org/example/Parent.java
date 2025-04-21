package org.example;

public class Parent {

    static void print(){
        System.out.println("parent");
    }

    static
    {
        System.out.println("FIRST");
    }

    void print(int a){
        System.out.println("parent");
    }

}
