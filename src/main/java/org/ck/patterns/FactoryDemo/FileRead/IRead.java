package org.ck.patterns.FactoryDemo.FileRead;

//他们都有一个行为那就是读取文件
public interface IRead {
    //故所有的都需要实现read接口
    public void read(String fileName);
}
