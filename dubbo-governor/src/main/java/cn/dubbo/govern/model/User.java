package cn.dubbo.govern.model;

import java.util.Date;

import cn.dubbo.govern.common.SuperEntity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

/**
 * 系统用户表
 */
@TableName("sys_user")
public class User extends SuperEntity {

	private static final long serialVersionUID = -73114010758995413L;

	/**
     * 用户名
     */
    private String name;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 自定义填充的创建时间
     */
    @TableField(fill = FieldFill.INSERT)// 该注解插入忽略验证，自动填充
    private Date ctime;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}