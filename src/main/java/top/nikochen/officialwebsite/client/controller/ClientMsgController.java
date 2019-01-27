package top.nikochen.officialwebsite.client.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.nikochen.officialwebsite.client.entity.ClientMsg;
import top.nikochen.officialwebsite.client.mapper.ClientMsgMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author niko
 * @since 2018-12-26
 */
@Controller
@RequestMapping("/client/client-msg")
public class ClientMsgController {

//    @Value("${spring.mail.username}")
//    //使用@Value注入application.properties中指定的用户名
//    private String from;
//
//    @Autowired
//    JavaMailSender jms;

    @Resource
    ClientMsgMapper clientMsgMapper;

    @RequestMapping(value = "/submitMessage")
    public String submitMessage(@RequestHeader(value = "User-Agent") String device,
//                                @RequestHeader(value="X-Real-IP") String ip,
                                String name, String email, String title, String message) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        ClientMsg clientMsg = new ClientMsg();
        clientMsg.setDevice(device);
        // clientMsg.setIp(ip);
        clientMsg.setName(name);
        clientMsg.setMtitle(title);
        clientMsg.setEmail(email);
        clientMsg.setMessage(message);
        clientMsg.setCreateTime(LocalDateTime.now());
        clientMsgMapper.insert(clientMsg);
//        //建立邮件消息
//        SimpleMailMessage mainMessage = new SimpleMailMessage();
//        //发送者
//        mainMessage.setFrom(from);
//        //接收者
//        mainMessage.setTo("1194142140@qq.com");
//        //发送的标题
//        mainMessage.setSubject("小魔头官网咨询");
//        ObjectMapper mapper = new ObjectMapper();
//
//        String data=null;
//        try {
//          data =  mapper.writeValueAsString(clientMsg);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        //发送的内容
//        mainMessage.setText(data);
//        jms.send(mainMessage);
        return "redirect:" + "/xiaomotou-official" + "/";

    }


}
