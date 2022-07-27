package org.ck.lambda;

/**
 * @className: IUserCredenbtialImpl
 * @description:
 * @createDate: 2021年01月20日 17:31:08
 * @author: ck
 */
public class IUserCredenbtialImpl implements IUserCredenbtial{

    @Override
    public String verifyUser(String username) {
        if("admin".equals(username)){
            return "系统管理员";
        }else if("manager".equals(username)){
            return "用户管理员";
        }else {
            return "普通会员用户";
        }
    }
}
