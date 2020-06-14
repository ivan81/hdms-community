/*   Copyright (c) 2019. 本项目所有源码受中华人民共和国著作权法保护，已登记软件著作权。 *     本项目版权归南昌瀚为云科技有限公司所有，本项目仅供学习交流使用，未经许可不得进行商用，开源（社区版）遵守AGPL-3.0协议。 * */
package com.blueray.doclib.dms.activity.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blueray.doclib.dms.model.dto.DocumentActivityDto;
import com.blueray.doclib.dms.activity.model.ActivityQuery;
import com.blueray.doclib.dms.activity.service.ActivityService;
import com.blueray.doclib.framework.core.protocol.Result;
import com.blueray.doclib.framework.support.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LIQIU
 */
@RestController
@RequestMapping("/activity")
public class ActivityController extends BaseController {

	@Autowired
	private ActivityService activityService;

	@RequestMapping("/search")
	public Result<Page<DocumentActivityDto>> search(ActivityQuery query) {
		return this.success(this.activityService.search(query));
	}


}
