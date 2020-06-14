/*   Copyright (c) 2019. 本项目所有源码受中华人民共和国著作权法保护，已登记软件著作权。 *     本项目版权归南昌瀚为云科技有限公司所有，本项目仅供学习交流使用，未经许可不得进行商用，开源（社区版）遵守AGPL-3.0协议。 * */
package com.blueray.doclib.dms.activity.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blueray.doclib.dms.activity.entity.Activity;
import com.blueray.doclib.dms.activity.mapper.ActivityMapper;
import com.blueray.doclib.dms.model.dto.DocumentActivityDto;
import com.blueray.doclib.dms.activity.model.ActivityQuery;
import com.blueray.doclib.dms.activity.service.ActivityService;
import com.blueray.doclib.framework.support.service.impl.BaseServiceImpl;
import com.blueray.doclib.framework.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author LIQIU
 */
@Service
public class ActivityServiceImpl extends BaseServiceImpl<Activity, Integer> implements ActivityService {

	@Autowired
	private ActivityMapper activityMapper;

	@Override
	public List<Activity> findDirectoryActivityByPath(String path) {
		return activityMapper.findDirectoryActivityByPath(path + "%");
	}

	@Override
	public List<Activity> findDocumentActivityById(Integer documentId) {
		return activityMapper.findDocumentActivityById(documentId);
	}

	@Override
	public Activity save(Activity activity) {
		activity.setOperateDate(new Date());
		activity.setOperateDate(new Date());
		super.save(activity);
		return activity;
	}

	@Override
	public Page<DocumentActivityDto> search(ActivityQuery query) {
		query.setStart((query.getPage() - 1) * query.getSize());
		query.setEnd(query.getPage() * query.getSize());
		if (StringUtils.isNotEmpty(query.getDocumentName())) {
			query.setDocumentName("%" + query.getDocumentName() + "%");
		}
		Page<DocumentActivityDto> page = new Page<>();
		page.setRecords(this.activityMapper.searchActivity(query));
		page.setTotal(this.activityMapper.countActivity(query));
		return page;
	}
}
