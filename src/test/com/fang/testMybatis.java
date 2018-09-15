package com.fang;

import com.alibaba.fastjson.JSON;
import com.fang.model.User;
import com.fang.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/10/14 0014.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class testMybatis {

    private static Logger logger = Logger.getLogger(testMybatis.class);
    @Resource
    private UserService userService = null;
    @Test
    public void test1() {
        User user = userService.selectUser(3);
        logger.info(JSON.toJSONString(user));
    }
}

