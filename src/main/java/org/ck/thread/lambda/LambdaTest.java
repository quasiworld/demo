package org.ck.thread.lambda;

/**
 * @className: LambdaTest
 * @description:
 * @createDate: 2021年06月28日 11:39:20
 * @author: ck
 */
public class LambdaTest {

    //静态内部类
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        //4.局部内部类
        class Like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }
        like = new Like3();
        like.lambda();

        //5.匿名内部类 没有类的名称，必须借助接口或父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };
        like.lambda();
        //6.用lambda简化
        //一个接口只包含一个抽象方法，那么他就是一个函数式接口
        like = () -> System.out.println("i like lambda5");
        like.lambda();
    }
}

//1.定义一个函数式接口
interface ILike {
    void lambda();
}

//2.实现类
class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}
