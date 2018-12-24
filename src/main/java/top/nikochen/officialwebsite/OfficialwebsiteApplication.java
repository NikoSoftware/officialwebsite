package top.nikochen.officialwebsite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("top.nikochen.officialwebsite")
public class OfficialwebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfficialwebsiteApplication.class, args);
	}

}

