/*   Copyright (c) 2019. 本项目所有源码受中华人民共和国著作权法保护，已登记软件著作权。 *     本项目版权归南昌瀚为云科技有限公司所有，本项目仅供学习交流使用，未经许可不得进行商用，开源（社区版）遵守AGPL-3.0协议。 * */
package com.blueray.doclib.user.service;

import com.blueray.doclib.framework.support.service.BaseService;
import com.blueray.doclib.user.domain.User;
import com.blueray.doclib.user.model.UpdatePasswordDto;
import com.blueray.doclib.user.model.UpdateProfileDto;
import com.blueray.doclib.user.model.UpdateQuotaDto;
import com.blueray.doclib.user.model.UserUpdateDto;
import com.blueray.doclib.user.model.UserUpdateVo;

import java.util.List;

/**
 * @author LIQIU
 */
public interface UserService extends BaseService<User, Integer> {

	/**
	 * 添加用户
	 *
	 * @param user
	 */
	void add(User user);


	/**
	 * @param id
	 * @param avatar
	 */
	void updateAvatar(Integer id, String avatar);

	/**
	 * @param userDto
	 */
	void update(UserUpdateDto userDto);

	/**
	 * 锁定
	 *
	 * @param id
	 */
	User lock(Integer id);

	/**
	 * 解锁
	 *
	 * @param id
	 */
	User unlock(Integer id);

	/**
	 * 禁用
	 *
	 * @param id
	 */
	User disable(Integer id);

	/**
	 * 启用
	 *
	 * @param id
	 */
	User enable(Integer id);

	/**
	 * 重置密码
	 *
	 * @param id
	 */
	void resetPassword(Integer id);

	UserUpdateVo getFullById(Integer id);

	/**
	 * @param departmentId
	 * @return
	 */
	List<User> findByDepartmentId(Integer departmentId);

	/**
	 * @param condition
	 * @return
	 */
	List<User> search(String condition);

	/**
	 * @param source
	 * @param target
	 */
	void transferAdmin(Integer source, Integer target);

	/**
	 * @param username
	 * @return
	 */
	User findByUsername(String username);

	/**
	 * @param user
	 */
	void updateProfile(UpdateProfileDto user);

	void updateQuota(UpdateQuotaDto quota);

	/**
	 * @param updatePasswordDto
	 */
	void updatePassword(UpdatePasswordDto updatePasswordDto);
}
