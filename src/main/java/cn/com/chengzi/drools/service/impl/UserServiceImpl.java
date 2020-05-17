package cn.com.chengzi.drools.service.impl;

import cn.com.chengzi.drools.domain.model.User;
import cn.com.chengzi.drools.mapper.UserMapper;
import cn.com.chengzi.drools.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mengsj
 * @since 2020-05-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
