/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.dongxiaohao.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.dongxiaohao.entitiy.UserEntity;
import top.dongxiaohao.repository.UserRepository;
import top.dongxiaohao.service.UserService;
import top.dongxiaohao.service.impl.UserServiceImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Slf4j
@RestController
public class BasicController {
    @Resource
    private UserService userService;
    @Resource
    private UserRepository userRepository;
    @RequestMapping("/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "unknown user") String name) {
        log.info("hello 接口被调用");
        userService.test();
        return "Hello " + name;
    }

    @GetMapping("/save")
    public String save() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("dongxiaohao");
        userEntity.setAge(18);
        userEntity.setEmail("dongxiaohao@163.com");
        userEntity.setPassword("123456");

        //userRepository.save(userEntity);
        userService.save(userEntity);
        return "success";
    }

    @GetMapping("/getUser")
    public void getUser() {
        List<UserEntity> userEntities = userService.queryUser(new UserEntity());
    }

}
