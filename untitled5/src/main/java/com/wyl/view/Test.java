package com.wyl.view;

import com.wyl.service.IBankService;
import com.wyl.service.impl.BankServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 测试方法
 */
public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("**********天地银行转账系统**********");
        System.out.println("请输入用户名:");
        Scanner input = new Scanner(System.in);
        String account = input.nextLine();
        System.out.println("请输入密码:");
        String password = input.nextLine();
        IBankService service = new BankServiceImpl();
        boolean login = service.login(account, password);

//            如果账号和密码正确
        if (login) {
            System.out.println("请输入汇入账号:");
            String transTo = input.nextLine();
            if (transTo.equals(account)) {
                System.out.println("请尽量避免给自己转账");
            }
            System.out.println("请输入汇款金额:");
            double transAmount = input.nextDouble();


            //            判断汇入账号是否存在
            boolean ifExist = service.ifExist(transTo);
//查询自己所拥有余额
            double own = service.whetherLess(account);
//如果汇入账户存在并且自己的余额大于0并且自己的余额大于或等于转出金额
            if (ifExist && transAmount > 0 && own > 0 && own >= transAmount) {
//                执行转账操作
                boolean result = service.transfer(account, transTo, transAmount);
//                转账结果为true
                if (result) {
                    System.out.println("转账成功\t--" + new SimpleDateFormat("Gy年M月d日k_H时m分s秒S毫秒E_D_F_w_W_a_h_K_z_Z_y_u_X_L").format(new Date()));
                }
            } else {
                System.out.println("账号、金额输入不正确或卡内余额不足");
            }
        } else {
            System.out.println("用户名或密码错误!");
        }
    }
}
