package top.dongxiaohao.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @Author: Dongxiaohao
 * @Date: 2025/2/23 20:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "user_info")
public class UserEntity {
    private Long id;
    private Long userId;
    private String name;
    private Integer age;
    private String email;
    private String password;
    @Field(type = FieldType.Date, format = DateFormat.date_time)
    private Date createTime;
}
