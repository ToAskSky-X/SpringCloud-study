package org.goskyer;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MqProducerApplication.class)
public class Test {

    @Autowired
    private Producer producer;


    @org.junit.Test
    public void  test(){
        producer.send();
    }

}
