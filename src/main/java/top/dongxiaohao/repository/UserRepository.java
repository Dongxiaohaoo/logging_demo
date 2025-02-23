package top.dongxiaohao.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import top.dongxiaohao.entitiy.UserEntity;

/**
 * @Author: Dongxiaohao
 * @Date: 2025/2/23 20:10
 */
@Repository
public interface UserRepository extends ElasticsearchRepository<UserEntity, Long> {
}
