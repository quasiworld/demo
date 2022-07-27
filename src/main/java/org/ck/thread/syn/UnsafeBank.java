package org.ck.thread.syn;

/**
 * @className: UnsafeBank
 * @description: 不安全的取钱
 * @createDate: 2021年07月08日 18:25:59
 * @author: ck
 */
public class UnsafeBank {

    public static void main(String[] args) {
        Account account = new Account(100, "基金");
        Drawing you = new Drawing(account, 50, "你");
        Drawing youFriend = new Drawing(account, 100, "你朋友");
        you.start();
        youFriend.start();
    }
}

class Account {
    int money;//余额
    String name;//卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行
class Drawing extends Thread {

    Account account;//账户
    //取了多少钱
    int drawingMoney;
    //手里有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    public void run() {
        synchronized (account) {
            //判断有没有钱
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够");
                return;
            }
            //sleep
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额 = 余额 - 你取的钱
            account.money = account.money - drawingMoney;
            nowMoney = nowMoney + drawingMoney;

            System.out.println(account.name + "余额为" + account.money);
            System.out.println(this.getName() + "手里的钱" + nowMoney);
        }
    }
}

