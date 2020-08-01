package com.nuc.zp.aop;

import com.nuc.zp.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestAop {

    @Autowired
    private User user;

    @Test
    public void test() {
        user.add(1, 2);
    }
}
