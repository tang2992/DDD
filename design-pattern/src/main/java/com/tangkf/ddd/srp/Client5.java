package com.tangkf.ddd.srp;

/**
 * 在这个示例里，针对呼吸的主体进行分类，分为陆生动物和水生动物，实现原类别的职责扩散
 * 这种扩散对原来的修改是比较小的，方法名一致，有统一的功能，可以进一步针对动物做接口提炼，修改后的见Client5类
 * 这种实现方式是最容易扩展的
 * @author tangkaifei
 */
public class Client5 {
    public static void main(String[] args) {
        Animal terrestrial = new Terrestrial();
        terrestrial.breathe("牛");
        terrestrial.breathe("羊");
        terrestrial.breathe("猪");

        /**
         * 鱼呼吸水
         */
        Animal aquatic = new Aquatic();
        aquatic.breathe("鱼");
    }

    /**
     * 动物的抽象接口
     */
    public interface Animal{
        /**
         * 动物呼吸
         * @param animal
         */
        void breathe(String animal);
    }

    static class Terrestrial implements Animal {
        @Override
        public void breathe(String animal){
            System.out.println(animal+"呼吸空气");
        }
    }
    static class Aquatic implements Animal{
        @Override
        public void breathe(String animal){
            System.out.println(animal+"呼吸水");
        }
    }
}
