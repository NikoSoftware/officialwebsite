package top.nikochen.officialwebsite.client.service.impl;

import top.nikochen.officialwebsite.client.entity.ClientMsg;
import top.nikochen.officialwebsite.client.mapper.ClientMsgMapper;
import top.nikochen.officialwebsite.client.service.IClientMsgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author niko
 * @since 2018-12-26
 */
@Service
public class ClientMsgServiceImpl extends ServiceImpl<ClientMsgMapper, ClientMsg> implements IClientMsgService {

}
