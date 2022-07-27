package org.ck.patterns.FactoryDemo.AbstractFactory;

import java.io.File;
import java.io.FileInputStream;

/**
 * @ClassName: TextRead
 * @description
 * @Date 2020年05月13日 14:46:19
 */
//读取文本文件
public class TextRead implements IRead<String> {
    public String read(String... in) {
        String result=null;
        try{
            File file=new File(in[0]);
            long len=file.length();
            FileInputStream input=new FileInputStream(in[0]);
            byte buf[] = new byte[(int)len];
            input.read(buf);
            result=new String(buf,in[1]);
            input.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }
}
