package top.dongxiaohao.dao;

import org.apache.ibatis.annotations.Mapper;
import top.dongxiaohao.entitiy.UserEntity;

import java.util.List;

/**
 * @Author: Dongxiaohao
 * @Date: 2025/2/23 20:18
 */
public interface UserDao {
    int save(UserEntity userEntity);

    UserEntity getOne(UserEntity userEntity);

    List<UserEntity> getList(UserEntity userEntity);
}
