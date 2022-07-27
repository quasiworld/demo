package org.ck.patterns.FactoryDemo.AbstractFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @ClassName: ImageRead
 * @description 读图像文件
 * @Date 2020年05月13日 14:58:03
 */
public class ImageRead implements IRead<ImageInfo>{
    public ImageInfo read(String... in){
        File f=new File(in[0]);
        try {
            BufferedImage bi = ImageIO.read(f);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
