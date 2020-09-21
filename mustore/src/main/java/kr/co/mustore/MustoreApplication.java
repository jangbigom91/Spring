package kr.co.mustore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("kr.co.mustore.dao")
public class MustoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MustoreApplication.class, args);
	}

}
