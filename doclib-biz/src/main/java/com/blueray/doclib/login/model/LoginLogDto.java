/*   Copyright (c) 2019. 本项目所有源码受中华人民共和国著作权法保护，已登记软件著作权。 *     本项目版权归南昌瀚为云科技有限公司所有，本项目仅供学习交流使用，未经许可不得进行商用，开源（社区版）遵守AGPL-3.0协议。 * */
package com.blueray.doclib.login.model;

import lombok.Data;

import java.util.Date;

/**
 * @author LIQIU
 * created on 2019/3/13
 **/
@Data
public class LoginLogDto {

	private Integer id;

	private Date loginDate;

	private Integer userId;

	private String userAgent;

	private String client;

	private String loginIp;

	private String position;

	private String username;

	private String name;
}