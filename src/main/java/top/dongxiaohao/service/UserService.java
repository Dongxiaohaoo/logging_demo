package top.dongxiaohao.service;

import top.dongxiaohao.entitiy.UserEntity;

/**
 * @Author: Dongxiaohao
 * @Date: 2025/2/23 20:23
 */
public interface UserService {
    String test();

    boolean save(UserEntity userEntity);
}
