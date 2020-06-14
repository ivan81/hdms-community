/*   Copyright (c) 2019. 本项目所有源码受中华人民共和国著作权法保护，已登记软件著作权。 *     本项目版权归南昌瀚为云科技有限公司所有，本项目仅供学习交流使用，未经许可不得进行商用，开源（社区版）遵守AGPL-3.0协议。 * */
package com.blueray.doclib.model;

import com.blueray.doclib.notice.entity.Notice;
import com.blueray.doclib.auth.core.AuthenticatedUser;
import com.blueray.doclib.dms.mount.entity.Mount;
import com.blueray.doclib.dms.permission.entity.Permission;
import com.blueray.doclib.user.model.UserSpace;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author LIQIU
 * created on 2019/2/24
 **/
@Data
public class Environment {

	private Map<String, Mount> mounts;

	private List<Permission> permissions;

	private AuthenticatedUser user;

	private UserSpace space;

	private AppSetting appSetting;

	private Notice notice;

}
