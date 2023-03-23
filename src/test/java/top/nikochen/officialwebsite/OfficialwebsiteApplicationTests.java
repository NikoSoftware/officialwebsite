package top.nikochen.officialwebsite;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OfficialwebsiteApplicationTests {

	/**
	 * Spring Boot 默认已经配置好了数据源，程序员可以直接 DI 注入然后使用即可
	 */
	@Resource
	DataSource dataSource;


	@Autowired
	JavaMailSender jms;


	@Test
	public void test(){

		//建立邮件消息
		SimpleMailMessage mainMessage = new SimpleMailMessage();
		//发送者
		mainMessage.setFrom("chenzhongqin@hifive.ai");
		//接收者
		mainMessage.setTo("1194142140@qq.com");
		//发送的标题
		mainMessage.setSubject("小魔头官网咨询");
		ObjectMapper mapper = new ObjectMapper();

		String data = null;
		try {
			data = mapper.writeValueAsString("测试数据");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		//发送的内容
		mainMessage.setText(data);
		jms.send(mainMessage);

	}




}

