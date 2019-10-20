package com.tangkf.ddd.isp;

/**
 * 可以看到，如果接口过于臃肿，只要接口中出现的方法，不管对依赖于它的类有没有用处，实现类中都必须去实现这些方法，这显然不是好的设计。
 * 如果将这个设计修改为符合接口隔离原则，就必须对接口I进行拆分。在这里我们将原有的接口I拆分为三个接口，拆分后的设计如图2所示：
 *
 * 接口隔离原则的含义是：建立单一接口，不要建立庞大臃肿的接口，尽量细化接口，接口中的方法尽量少。
 * 也就是说，我们要为各个类建立专用的接口，而不要试图去建立一个很庞大的接口供所有依赖它的类去调用。
 * 本文例子中，将一个庞大的接口变更为3个专用的接口所采用的就是接口隔离原则。
 * 在程序设计中，依赖几个专用的接口要比依赖一个综合的接口更灵活。
 * 接口是设计时对外部设定的“契约”，通过分散定义多个接口，可以预防外来变更的扩散，提高系统的灵活性和可维护性。
 * @author t00458
 */
public class IspClient2 {
    public static void main(String[] args){
        A a = new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());

        C c = new C();
        c.depend1(new D());
        c.depend2(new D());
        c.depend3(new D());
    }


    interface I1 {
        public void method1();
    }

    interface I2 {
        public void method2();
        public void method3();
    }

    interface I3 {
        public void method4();
        public void method5();
    }

    static class A{
        public void depend1(I1 i){
            i.method1();
        }
        public void depend2(I2 i){
            i.method2();
        }
        public void depend3(I2 i){
            i.method3();
        }
    }

    static class B implements I1, I2{
        public void method1() {
            System.out.println("类B实现接口I1的方法1");
        }
        public void method2() {
            System.out.println("类B实现接口I2的方法2");
        }
        public void method3() {
            System.out.println("类B实现接口I2的方法3");
        }
    }

    static class C{
        public void depend1(I1 i){
            i.method1();
        }
        public void depend2(I3 i){
            i.method4();
        }
        public void depend3(I3 i){
            i.method5();
        }
    }

    static class D implements I1, I3{
        public void method1() {
            System.out.println("类D实现接口I1的方法1");
        }
        public void method4() {
            System.out.println("类D实现接口I3的方法4");
        }
        public void method5() {
            System.out.println("类D实现接口I3的方法5");
        }
    }
}
