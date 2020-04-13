package com.niit.mybatis.mybatisxml.mapper;

import com.niit.mybatis.mybatisxml.model.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author XieL
 * @date 2020/4/7 9:44
 */
@Mapper
@Repository
public interface MessageMapper {
    List<Message> selectAll();

    int insert(Message message);

    Message selectById(Integer id);

    int delete(Integer id);

    int updateText(Message message);

    int update(Message message);

    int batchInsert(List<Message> messages);
}
