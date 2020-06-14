/*   Copyright (c) 2019. 本项目所有源码受中华人民共和国著作权法保护，已登记软件著作权。 *     本项目版权归南昌瀚为云科技有限公司所有，本项目仅供学习交流使用，未经许可不得进行商用，开源（社区版）遵守AGPL-3.0协议。 * */
package com.blueray.doclib.dms.event;

import com.blueray.doclib.dms.document.entity.Document;
import org.springframework.context.ApplicationEvent;

/**
 * @author LIQIU
 */
public class DeleteEvent extends ApplicationEvent {

	private Document document;

	private Integer userId;

	public DeleteEvent(Document document, Integer userId) {
		super(document);
		this.document = document;
		this.userId = userId;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
