package zyx.userservice.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zyx.userservice.Mapper.UserMapper;
import zyx.userservice.Service.UserService;
import zyx.userservice.entity.User;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
