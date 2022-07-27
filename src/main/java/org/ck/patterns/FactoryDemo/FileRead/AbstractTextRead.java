package org.ck.patterns.FactoryDemo.FileRead;

/**
 * @ClassName: AbstractTextFactory
 * @description
 * @Date 2020年05月07日 18:34:48
 */
//文本读取工厂需要实现 GBK,UTF8,UN_CODE
//所以需要三个实现类
public  class AbstractTextRead implements IRead {

    @Override
    public void read(String fileName) {

    }
}
