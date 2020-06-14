/*   Copyright (c) 2019. 本项目所有源码受中华人民共和国著作权法保护，已登记软件著作权。 *     本项目版权归南昌瀚为云科技有限公司所有，本项目仅供学习交流使用，未经许可不得进行商用，开源（社区版）遵守AGPL-3.0协议。 * */
package com.blueray.doclib;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author LIQIU
 * created on 2019/2/23
 **/
@EnableCaching
@MapperScan("com.blueray.**.mapper")
@ComponentScan("com.blueray")
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DocLibApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocLibApplication.class, args);
	}

}
