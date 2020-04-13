package com.mybatis.annotation.demo.mapper;
import com.mybatis.annotation.demo.model.Message;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author XieL
 * @date 2020/4/7 9:44
 */
//@Mapper
//@Repository
public interface MessageMapper {
    @Select("select * from message")
    List<Message> selectAll();
    @Insert("insert into message(msg_text,msg_summary)values(#{msgText},#{msgSummary}) ")
    int insert(Message message);
    @Select("select * from message where msg_id=#{msgId}")
    Message selectById(Integer id);
    @Delete("delete from message where msg_id=#{msgId}")
    int delete(Integer id);
    @Update({"<script>",
            "UPDATE message",
            "<set>",
            " <if test='msgText !=null'> msg_text=#{msgText}, </if>",
            "<if test='msgSummary !=null'> msg_summary=#{msgSummary}</if>",
            "</set>",
            "WHERE msg_id = #{msgId}",
            "</script>"})
    int updateText(Message message);
   @Update({"<script>",
             "UPDATE message SET",
           " <if test='msgText !=null'> msg_text=#{msgText}, </if>",
           "<if test='msgSummary !=null'> msg_summary=#{msgSummary}</if>",
           "WHERE msg_id = #{msgId}",
          "</script>"})
    int update(Message message);
    @Update({"<script>",
            "INSERT INTO message(msg_text,msg_summary) VALUES",
            "<foreach collection='list' item='msg' index='index' separator=','>",
           " (#{msg.msgText},#{msg.msgSummary})",
       " </foreach>",
            "</script>"})
    int batchInsert(List<Message> messages);
}
