package com.tangkf.ddd.single;

/**
 * 在这个示例里，针对呼吸的主体进行分类，分为陆生动物和水生动物，实现原类别的职责扩散
 * 这种扩散对原来的修改是比较小的，方法名一致，有统一的功能，可以进一步针对动物做接口提炼，修改后的见Client5类
 * @author tangkaifei
 */
public class Client4 {
    public static void main(String[] args) {
        Terrestrial animal = new Terrestrial();
        animal.breathe("牛");
        animal.breathe("羊");
        animal.breathe("猪");

        /**
         * 鱼呼吸水
         */
        Aquatic aquatic = new Aquatic();
        aquatic.breathe("鱼");
    }



    static class Terrestrial{
        public void breathe(String animal){
            System.out.println(animal+"呼吸空气");
        }
    }
    static class Aquatic{
        public void breathe(String animal){
            System.out.println(animal+"呼吸水");
        }
    }
}
