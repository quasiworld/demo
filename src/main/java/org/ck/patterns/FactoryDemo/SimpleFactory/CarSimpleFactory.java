package org.ck.patterns.FactoryDemo.SimpleFactory;

/**
 * @ClassName: CarSimpleFactory
 * @description
 * @Date 2020年05月07日 10:46:02
 */
//生成的工厂
public class CarSimpleFactory {
    public static final String UPTYPE="uptype";
    public static final String MIDETYPE="midetype";
    public static final String DNTYPE="dntype";

    private CarSimpleFactory(){}

    public static ICar create(String mark){
        ICar obj=null;
        if(mark.equals(UPTYPE)){
            obj=new UpCar();
        }else if(mark.equals(MIDETYPE)){
            obj=new MidCar();
        }else  if(mark.equals(DNTYPE)){
            obj=new DnCar();
        }
        return obj;
    }
}
