package kr.or.connect.daoexam.main;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import kr.or.connect.daoexam.config.DBConfig;

@Configuration
@Import({DBConfig.class})
public class ApplicationConfig {

}
