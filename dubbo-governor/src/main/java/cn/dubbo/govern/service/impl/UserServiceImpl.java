package cn.dubbo.govern.service.impl;

import org.springframework.stereotype.Service;

import cn.dubbo.govern.mapper.UserMapper;
import cn.dubbo.govern.model.User;
import cn.dubbo.govern.service.IUserService;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}