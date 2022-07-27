package org.ck.patterns;

import lombok.Data;

/**
 * @ClassName: Persion
 * @description
 * @Date 2020年05月22日 15:33:03
 */
@Data
public class Persion implements Cloneable {

    private String name;

    private int age;

    public Persion clone() throws CloneNotSupportedException {
        return (Persion) super.clone();
        //return (Persion) super.clone();
    }
}
