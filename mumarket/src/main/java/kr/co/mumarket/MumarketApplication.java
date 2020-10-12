package kr.co.mumarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("kr.co.mumarket")
public class MumarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MumarketApplication.class, args);
	}

}