package com.tangkf.ddd.dip;

/**
 * 依赖倒置原则2
 * 需求变成这样：不是给书而是给一份报纸，让这位母亲讲一下报纸上的故事，报纸的代码如下：
 * 这位母亲却办不到，因为她居然不会读报纸上的故事，这太荒唐了，只是将书换成报纸，居然必须要修改Mother才能读。很多人的设计会变成下面这样
 * 假如以后需求换成杂志呢？换成网页呢？还要不断地修改Mother，这显然不是好的设计。
 * 原因就是Mother与Book之间的耦合性太高了，必须降低他们之间的耦合度才行。
 * @author t00458
 */
public class DipClient2 {
    public static void main(String[] args){
        Mother mother = new Mother();
        mother.narrate(new Newspaper());
    }


    static class Book{
        public String getContent(){
            return "很久很久以前有一个阿拉伯的故事……";
        }
    }

    static class Mother{
        public void narrate(Book book){
            System.out.println("妈妈开始讲故事");
            System.out.println(book.getContent());
        }

        public void narrate(Newspaper newspaper){
            System.out.println("妈妈开始讲故事");
            System.out.println(newspaper.getContent());
        }
    }

    static class Newspaper{
        public String getContent(){
            return "林书豪38+7领导尼克斯击败湖人……";
        }
    }
}
