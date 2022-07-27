package org.ck.patterns.FactoryDemo.FileReadLevel;

public interface IRead<T> {

    T read(String ... in);
}
