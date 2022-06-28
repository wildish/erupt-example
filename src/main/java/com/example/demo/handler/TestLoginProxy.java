package com.example.demo.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.erupt.jpa.dao.EruptDao;
import xyz.erupt.upms.base.LoginModel;
import xyz.erupt.upms.fun.LoginProxy;
import xyz.erupt.upms.model.EruptUser;
import xyz.erupt.upms.service.EruptUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class TestLoginProxy implements LoginProxy {
    @Resource
    private EruptDao eruptDao;

    @Autowired
    private EruptUserService eruptUserService;

    @Resource
    private HttpServletRequest request;

    @Override
    public EruptUser login(String account, String pwd) {
        // 调用默认登录方法
        LoginModel model = eruptUserService.login(account, pwd);
        if(!model.isPass()) {
            throw new RuntimeException("账号或密码错误");
        }
        return eruptDao.queryEntity(EruptUser.class, "account = '" + account + "'");
    }
}
