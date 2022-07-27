package org.ck.lambda;

/**
 * @className: App
 * @description:
 * @createDate: 2021年01月20日 17:29:33
 * @author: ck
 */
public class App {
    public static void main(String[] args) {
        IUserCredenbtial ic = new IUserCredenbtialImpl();

        System.out.println(ic.verifyUser("admin"));

        System.out.println(ic.getCredential("admin"));


        String msg = "hello world";

        if(MessageFound.verifyMessage(msg)){
            MessageFound found = new MessageFormatImpl();
            found.format(msg,"json");
        }

        IUserCredenbtial ic2 = new IUserCredenbtial() {
            @Override
            public String verifyUser(String username) {
                return "admin".equals(username)?"管理员":"会员";
            }
        };

        System.out.println(ic2.verifyUser("manager"));
        System.out.println(ic2.verifyUser("admin"));

        IUserCredenbtial ic3 = (String username)->{
            return "admin".equals(username)?"管理员":"会员";
        };

        System.out.println(ic3.verifyUser("manager"));
        System.out.println(ic3.verifyUser("admin"));
    }
}
