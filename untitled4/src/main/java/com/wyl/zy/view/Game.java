package com.wyl.zy.view;

import com.wyl.zy.entity.GameEntity;
import com.wyl.zy.service.IGameService;
import com.wyl.zy.service.impl.GameServiceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        System.out.println("*******欢迎光临王者水晶*******");
        IGameService service = new GameServiceImpl();

        while (true) {
            System.out.println("1、充值\t2、购买道具\t3、退出系统");
            Scanner input = new Scanner(System.in);


            try {
                int action = input.nextInt();
                if (action == 1) {

                    System.out.println("请输入要充值的账号:");

                    String account = input.next();

                    System.out.println("请输入要充值的金额:");
                    double sum = input.nextDouble();


                    boolean result = service.topUp(account, sum);
                    if (result) {
                        System.out.println("充值完毕!");
                    } else {
                        System.out.println("输入账号不存在");
                    }

                } else if (action == 2) {
                    ArrayList<GameEntity> all = service.showAll();
                    System.out.println("编号\t道具名称\t价格");
                    for (GameEntity a : all) {
                        System.out.println(a);
                    }
                    System.out.println("请选择要购买的道具:");
                    int chosenId = input.nextInt();
                    System.out.println("请输入要购买的数量:");
                    int num = input.nextInt();

                    boolean result = service.buy(chosenId, num);
                    if (result) {
                        System.out.println("购买成功\t---" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                    } else {
                        System.out.println("购买失败!");
                    }
                } else {
                    System.out.println("退出成功");
                    break;
                }
            } catch (Exception e) {
                e.getMessage();
                System.out.println("请输入正确的指令");
            }


        }
    }
}
