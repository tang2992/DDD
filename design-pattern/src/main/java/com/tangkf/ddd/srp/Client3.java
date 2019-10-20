package com.tangkf.ddd.srp;

/**
 *
 * @author tangkaifei
 */
public class Client3 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.breathe("牛");
        animal.breathe("羊");
        animal.breathe("猪");

        /**
         * 鱼呼吸水
         */
        animal.breathe("鱼");
    }


    static class Animal {
        /**
         * 这是常见的另一种修改方法，通过不同的方法区分
         * 这种修改方式没有改动原来的方法，而是在类中新加了一个方法，这样虽然也违背了单一职责原则，但在方法级别上却是符合单一职责原则的，因为它并没有动原来方法的代码。
         */
        public void breathe(String animal) {
            System.out.println(animal + "呼吸空气");
        }

        public void breathe2(String animal) {
            System.out.println(animal + "呼吸水");
        }
    }
}
