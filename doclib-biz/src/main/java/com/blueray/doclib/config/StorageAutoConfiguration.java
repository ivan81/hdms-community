/*   Copyright (c) 2019. 本项目所有源码受中华人民共和国著作权法保护，已登记软件著作权。 *     本项目版权归南昌瀚为云科技有限公司所有，本项目仅供学习交流使用，未经许可不得进行商用，开源（社区版）遵守AGPL-3.0协议。 * */
package com.blueray.doclib.config;

import com.blueray.doclib.config.properties.StorageConfig;
import com.blueray.doclib.dms.encryptor.Encryptors;
import com.blueray.doclib.dms.encryptor.NullEncryptors;
import com.blueray.doclib.dms.storage.LocalStorage;
import com.blueray.doclib.dms.storage.Storage;
import com.blueray.doclib.dms.uploader.DefaultUploader;
import com.blueray.doclib.dms.uploader.Uploader;
import com.blueray.doclib.setting.entity.Setting;
import com.blueray.doclib.setting.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * @author LIQIU
 * created on 2019/2/23
 **/
@Configuration
@EnableConfigurationProperties({StorageConfig.class})
public class StorageAutoConfiguration {

	@Autowired
	private SettingService settingService;

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		Setting setting = this.settingService.get();
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//文件最大
		factory.setMaxFileSize(DataSize.ofMegabytes(setting.getMaxUploadFileSize()));
		return factory.createMultipartConfig();
	}

	@Autowired
	private StorageConfig storageConfig;

	@Bean
	public Storage storage() {
		return new LocalStorage(storageConfig.getLocation());
	}

	@Bean
	public Encryptors encryptors() {
		return new NullEncryptors();
	}

	@Bean
	public Uploader defaultUploader(Storage storage, Encryptors encryptors) {
		DefaultUploader multiPartUploader = new DefaultUploader();
		multiPartUploader.setEncryptors(encryptors);
		multiPartUploader.setStorage(storage);
		return multiPartUploader;
	}

}
