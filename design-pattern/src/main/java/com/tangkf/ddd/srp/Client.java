package com.tangkf.ddd.srp;

public class Client {
    public static void main(String[] args){
        Animal animal = new Animal();
        animal.breathe("牛");
        animal.breathe("羊");
        animal.breathe("猪");
    }

    public static class Animal {
        public void breathe(String animal){
            System.out.println(animal+"呼吸空气");
        }
    }
}
