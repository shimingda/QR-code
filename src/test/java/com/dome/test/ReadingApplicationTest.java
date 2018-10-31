package com.dome.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Simon
 * @create 2018-10-15 11:42
 * @desc
 **/
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringJUnitConfig(classes = MainApplication.class)
public class ReadingApplicationTest {

    @Test
    public void testRunning(){
        TestDomeRunning testDomeRunning=new TestDomeRunning();
        testDomeRunning.test();
    }

}
