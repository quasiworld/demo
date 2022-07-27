package org.ck.thread.lambda;

/**
 * @className: LambadLoveTest
 * @description:
 * @createDate: 2021年07月03日 18:18:49
 * @author: ck
 */
public class LambdaLoveTest {
    public static void main(String[] args) {
        int b = 20;
        ILove iLove = (a) -> {
            System.out.println("测试" + a);
        };

        iLove = a -> {
            System.out.println("测试" + a);
        };
        //
        iLove = a -> System.out.println("测试" + a);
        iLove.love(b);

        Thread thread = new Thread(() -> System.out.println("爱吗,痛吗"));

        thread.start();
    }

}



interface ILove {
    void love(int a);
}

class Love implements ILove {

    @Override
    public void love(int a) {
        System.out.println("love one" + a);
    }
}
