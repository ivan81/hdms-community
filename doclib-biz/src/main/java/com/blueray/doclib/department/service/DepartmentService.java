/*   Copyright (c) 2019. 本项目所有源码受中华人民共和国著作权法保护，已登记软件著作权。 *     本项目版权归南昌瀚为云科技有限公司所有，本项目仅供学习交流使用，未经许可不得进行商用，开源（社区版）遵守AGPL-3.0协议。 * */
package com.blueray.doclib.department.service;

import com.blueray.doclib.department.domain.Department;
import com.blueray.doclib.department.model.DepartmentDto;
import com.blueray.doclib.framework.support.service.BaseService;

import java.util.List;

/**
 * @author LIQIU
 */
public interface DepartmentService extends BaseService<Department, Integer> {

	/**
	 * @param parent
	 * @return
	 */
	List<Department> findByParent(Integer parent);

	/**
	 * @param id
	 * @return
	 */
	DepartmentDto getFullById(Integer id);

	/**
	 * @param condition
	 * @return
	 */
	List<Department> search(String condition);

	/**
	 * @return
	 */
	Department getRootDepartment();

	/**
	 * @param departmenDto
	 */
	void save(DepartmentDto departmenDto);

	/**
	 * @param departmentDto
	 * @return
	 */
	Department update(DepartmentDto departmentDto);

	Department findByCode(String code);
}