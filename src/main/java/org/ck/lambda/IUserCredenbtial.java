package org.ck.lambda;

/**
 * @className: IUserCredebtial
 * @description:
 * @createDate: 2021年01月20日 17:19:44
 * @author: ck
 */
@FunctionalInterface
public interface IUserCredenbtial {

    /**
     * 功能描述:
     *
     * @param username
     * @return java.lang.String
     * @author ck
     * @date 2021-01-20 17:20
     */
    String verifyUser(String username);

    default String getCredential(String username) {
        if("admin".equals(username)){
            return username+"系统管理员用户";
        }else if("manager".equals(username)){
            return username+"用户管理员用户";
        }else {
            return "commons+普通会员用户";
        }
    }
    //boolean test();
}
