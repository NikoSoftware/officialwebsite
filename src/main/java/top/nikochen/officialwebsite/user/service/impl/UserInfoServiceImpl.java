package top.nikochen.officialwebsite.user.service.impl;

import top.nikochen.officialwebsite.user.entity.UserInfo;
import top.nikochen.officialwebsite.user.mapper.UserInfoMapper;
import top.nikochen.officialwebsite.user.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author niko
 * @since 2018-12-24
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
