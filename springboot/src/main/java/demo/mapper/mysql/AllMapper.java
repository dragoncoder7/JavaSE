package demo.mapper.mysql;

import demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AllMapper {
    @Select("select * from user")
    List<User> getAllUsers();
}
