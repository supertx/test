package com.qinli.service;

import org.springframework.stereotype.Service;

/**
 * @author supermantx
 * @time 2021/1/25 12:58
 * 登陆的服务层
 */
public interface ILoginService {

    /**
     * 查找用户
     * @return
     */
    public boolean findUser(String username);

    /**
     * 验证登陆
     * @return
     */
    public boolean judge(String username, String pwd);
}
