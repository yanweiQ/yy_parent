package com.youyue.framework.domain.ucenter;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by admin on 2018/3/19.
 */
@Data
@ToString
@Entity
@Table(name="yy_role")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class YyRole {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    @Column(name="role_name")
    private String roleName;
    @Column(name="roleCode")
    private String role_code;
    private String description;
    private String status;
    @Column(name="createTime")
    private Date create_time;
    @Column(name="update_time")
    private Date updateTime;


}
