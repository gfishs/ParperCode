package part5;

import Utils.ConnectionUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;

/**
 * @author kang
 * @create 2021-11-08-11:21
 */

/*
    第五章中的 目标任务数据插入
 */
public class insertTaskData1 {

    public static void batchInsert(int countNum) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        System.out.println(connection);
        // 关闭自动提交
        connection.setAutoCommit(false);
        String sql = "insert into page5_tasksinfomation_"+countNum+" ( `LongitudePointOne`,\n" +
                "  `LatitudePointOne` ,\n" +
                "  `LongitudePointTwo` ,\n" +
                "  `LatitudePointTwo` ,\n" +
                "  `LongitudePointThree` ,\n" +
                "  `LatitudePointThree`,\n" +
                "  `LongitudePointFour` ,\n" +
                "  `LatitudePointFour` ,\n" +
                "  `TaskPriority`) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        double[] doubles = test01();
        ps.setDouble(1, doubles[0]);
        ps.setDouble(2, doubles[1]);
        ps.setDouble(3, doubles[2]);
        ps.setDouble(4, doubles[3]);
        ps.setDouble(5, doubles[4]);
        ps.setDouble(6, doubles[5]);
        ps.setDouble(7, doubles[6]);
        ps.setDouble(8, doubles[7]);
        ps.setDouble(9, doubles[8]);
            // addBatch

        ps.execute();
        // 提交事务
        connection.commit();
        ConnectionUtils.close();
    }
    public static void main(String[] args) throws Exception {
        batchInsert(200);
    }

    public  static double[]  test01(){
        double[] array = new double[8];
        double longitude1 = Math.random() * (180);
        BigDecimal b1   =   new   BigDecimal(longitude1);
        double   f1   =   b1.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);

        double altude1 = Math.random() * (180);
        BigDecimal b2   =   new   BigDecimal(altude1);
        double   f2   =   b2.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f2);


        double long1 = 0.3 + Math.random() * (0.5);
        BigDecimal b3   =   new   BigDecimal(long1);
        double   f3   =   b3.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f3);

        double long2 = 0.3 + Math.random() * (0.5);
        BigDecimal b4   =   new   BigDecimal(long2);
        double   f4   =   b4.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f4);


        array[0] = f1;
        array[1] = f2;
        array[2] = f1 +f3;
        array[3] = f2;
        array[4] = f1 ;
        array[5] = f2 + f4;
        array[6] = f1 + f3;
        array[7] = f2 + f4;
        for(int i = 0; i < array.length; i++){
            BigDecimal bigDecimal = new BigDecimal(array[i]);
            array[i] = bigDecimal.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        System.out.println(Arrays.toString(array));
        return array;


    }
}
