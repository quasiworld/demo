package org.ck.patterns.FactoryDemo.FileRead;

/**
 * @ClassName: IUTF8
 * @description UF8读取对象
 * @Date 2020年05月07日 18:37:01
 */public class IUTF8 extends AbstractTextRead {
    @Override
    public void read(String fileName) {
        System.out.println("IUTF8读取实现");
    }
}
