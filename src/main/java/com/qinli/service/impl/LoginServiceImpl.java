package com.qinli.service.impl;

import com.qinli.dao.ILoginDao;
import com.qinli.pojo.User;
import com.qinli.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author supermantx
 * @time 2021/1/25 13:01
 * 登陆的服务层实现
 */
@Service
public class LoginServiceImpl implements ILoginService {


    @Autowired
    ILoginDao loginDao;

    @Override
    public boolean findUser(String username) {
        if (!loginDao.findUser(username).isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public boolean judge(String username, String pwd) {
        if (!loginDao.judge(new User(username, pwd)).isEmpty()){
            return true;
        }
        return false;
    }
}
