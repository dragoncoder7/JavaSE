package demo.mapper.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
