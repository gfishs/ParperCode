package part5;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author kang
 * @create 2021-11-10-11:35
 */
public class randompoint {
    public static void main(String[] args) {
        double[] array = new double[200];
        for(int i = 0;i < 200; i++){
            double longitude1 =  0 + Math.random() * (24 - 0);
            BigDecimal b1   =   new   BigDecimal(longitude1);
            double   f1   =   b1.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
            array[i] = f1;
        }

        for(double i : array){
            System.out.println(i);
        }
    }
}
