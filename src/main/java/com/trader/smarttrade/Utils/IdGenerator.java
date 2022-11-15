package com.trader.smarttrade.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IdGenerator {

    static Random random = new Random();
    static int sufix;



    //customIdGenerator class generates the primary keys (id) for the merchant,user, merchantResponse
    //transact and UserRequest entities.
    public static String customIdGenerator(String prefix, int min, int max){
        SimpleDateFormat dtf = new SimpleDateFormat("ddMMyyHHmmss");
        sufix = random.nextInt(min,max);
        String suffix = Integer.toString(sufix);
        Date date = new Date();
        return prefix + dtf.format(date) + suffix;
    }

    public static Long customWalletIdGenerator(){
        SimpleDateFormat dtf = new SimpleDateFormat("MMyyHHmm");
        Date date = new Date();
        String partB = dtf.format(date);
        String partC = Integer.toString(random.nextInt(100,500));
        return Long.parseLong( partB + partB);
    }

    static int count = 0;
    public static String transactionIdGenerator(String prefix){
        String suffix = Integer.toString(count++);
        return prefix + suffix;
    }
}
