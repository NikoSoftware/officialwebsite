package top.nikochen.officialwebsite.client.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.nikochen.officialwebsite.client.entity.ClientMsg;
import top.nikochen.officialwebsite.client.mapper.ClientMsgMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author niko
 * @since 2018-12-26
 */
@Controller
@RequestMapping("/client")
public class ClientMsgController {

    @Value("${spring.mail.username}")
    //使用@Value注入application.properties中指定的用户名
    private String from;

    @Autowired
    JavaMailSender jms;

    @Resource
    ClientMsgMapper clientMsgMapper;

    @RequestMapping(value = "/submitMessage")
    public String submitMessage(@RequestHeader(value = "User-Agent") String device,
                                HttpServletRequest request,
                                @Valid ClientMsg clientMsg) {

      //  ClientMsg clientMsg = new ClientMsg();
        clientMsg.setDevice(device);
        clientMsg.setIp(request.getRemoteAddr());
//        clientMsg.setName(name);
//        clientMsg.setMtitle(title);
//        clientMsg.setPhone(phone);
//        clientMsg.setMessage(message);
        clientMsg.setCreateTime(LocalDateTime.now());
        clientMsgMapper.insert(clientMsg);
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        mainMessage.setFrom(from);
        //接收者
        mainMessage.setTo("1194142140@qq.com");
        //发送的标题
        mainMessage.setSubject("小魔头官网咨询");
        ObjectMapper mapper = new ObjectMapper();

        String data = null;
        try {
            data = mapper.writeValueAsString(clientMsg);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //发送的内容
        mainMessage.setText(data);
        jms.send(mainMessage);
        return "redirect:" + request.getContextPath() + "/";
    }


    @ResponseBody
    @RequestMapping("/getClientMsg")
    public String getTestJson(String id) {

        ClientMsg clientMsg = clientMsgMapper.selectById(id);
        return clientMsg == null ? "{}" : clientMsg.toString();
    }

    @ResponseBody
    @RequestMapping("/getAllMsg")
    public String getAllMsg() {
        QueryWrapper<ClientMsg> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        List<ClientMsg> clientMsgs = clientMsgMapper.selectList(queryWrapper);

        return JSON.toJSONString(clientMsgs);
    }


}
