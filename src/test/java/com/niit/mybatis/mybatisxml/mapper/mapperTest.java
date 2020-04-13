package com.niit.mybatis.mybatisxml.mapper;

import com.niit.mybatis.mybatisxml.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author XieL
 * @date 2020/4/7 10:27
 */
@Slf4j
@SpringBootTest
public class mapperTest {
    @Autowired
    private MessageMapper messageMapper;

    @Test
    public void testInsert(){
        Message msg = Message.builder().msgText("HUAWEI").msgSummary("华为").build();
        int num = messageMapper.insert(msg);
        log.info("插入的数据： {}",num);
    }

    @Test
    public void testSlectAll(){
        List<Message> msgs = messageMapper.selectAll();
        if(msgs==null){
            log.error("msg为null");
        }else {
            msgs.forEach(msg->log.info("查询到的记录： {}",msgs));
        }
    }

    @Test
    public void testSelectById(){
        Message message = messageMapper.selectById(1);
        log.info("id为1的数据:  {}",message);
    }

    @Test
    public void testDelete(){
        int num = messageMapper.delete(1);
        log.info("删除的数据条数: {}",num);
    }

    @Test
    public void  testUpdateText(){
        Message message = Message.builder().msgId(2).msgText("computer").msgSummary("").build();
        int num = messageMapper.updateText(message);
        log.info("更新Text的数据条数: {}",num);
    }

    @Test
    public void testUpdate(){
        Message message = Message.builder().msgId(1).msgText("computer").msgSummary("学校").build();
        int num = messageMapper.update(message);
        log.info("更新数据条数:{}",num);
    }

    @Test
    public void testBatchInsert(){
        List<Message> messages = new ArrayList<>(Arrays.asList(
                Message.builder().msgText("apple").msgSummary("水果").build(),
                Message.builder().msgText("orange").msgSummary("水果").build()));
       int num = messageMapper.batchInsert(messages);
       log.info("插入数据条数: {}",num);
    }
}

