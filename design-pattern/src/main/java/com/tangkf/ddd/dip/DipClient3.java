package com.tangkf.ddd.dip;

/**
 * 依赖倒置原则3
 * 我们引入一个抽象的接口IReader。读物，只要是带字的都属于读物：
 * Mother类与接口IReader发生依赖关系，而Book和Newspaper都属于读物的范畴，他们各自都去实现IReader接口，这样就符合依赖倒置原则了
 * 这样修改后，无论以后怎样扩展Client类，都不需要再修改Mother类了。
 * 这只是一个简单的例子，实际情况中，代表高层模块的Mother类将负责完成主要的业务逻辑，一旦需要对它进行修改，引入错误的风险极大。
 * 所以遵循依赖倒置原则可以降低类之间的耦合性，提高系统的稳定性，降低修改程序造成的风险。
 *
 * 采用依赖倒置原则给多人并行开发带来了极大的便利，比如上例中，原本Mother类与Book类直接耦合时，Mother类必须等Book类编码完成后才可以进行编码，因为Mother类依赖于Book类。
 * 修改后的程序则可以同时开工，互不影响，因为Mother与Book类一点关系也没有。参与协作开发的人越多、项目越庞大，采用依赖导致原则的意义就越重大。
 * @author t00458
 */
public class DipClient3 {
    public static void main(String[] args){
        Mother mother = new Mother();
        mother.narrate(new Newspaper());
    }


    static class Mother{
        public void narrate(IReader reader){
            System.out.println("妈妈开始讲故事");
            System.out.println(reader.getContent());
        }
    }

    interface IReader{
        /**
         * @return
         */
        String getContent();
    }

    static class Book implements IReader {
        public String getContent(){
            return "很久很久以前有一个阿拉伯的故事……";
        }
    }

    static class Newspaper implements IReader{
        public String getContent(){
            return "林书豪38+7领导尼克斯击败湖人……";
        }
    }
}
