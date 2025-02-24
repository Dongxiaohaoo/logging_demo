package top.dongxiaohao.service;

import top.dongxiaohao.entitiy.UserEntity;

import java.util.List;

/**
 * @Author: Dongxiaohao
 * @Date: 2025/2/23 20:23
 */
public interface UserService {
    String test();

    boolean save(UserEntity userEntity);

    List<UserEntity> queryUser(UserEntity userEntity);
}
