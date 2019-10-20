package com.tangkf.ddd.lsp;

public class Client{
    public static void main(String[] args){
        A a = new A();
        System.out.println("100-50="+a.func1(100, 50));
        System.out.println("100-80="+a.func1(100, 80));
    }


    static class A{
        public int func1(int a, int b){
            return a-b;
        }
    }
}
