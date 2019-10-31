package com.yzsunlei.xmall.admin.controller;


import com.yzsunlei.xmall.admin.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * 图片上传相关操作接口
 * Created by macro on 2018/4/26.
 */
@RestController
@RequestMapping("/upload")
@CrossOrigin
public class UploadImageController {
	@Value("${fileUploadPath}")
	private String fileUploadPath;
	private Logger logger = LoggerFactory.getLogger(UploadImageController.class);

	@RequestMapping(value = "/imgUpload", method = RequestMethod.POST)
	public Object singleFileUpload(MultipartFile file)
			throws IOException {
		if (Objects.isNull(file) || file.isEmpty()) {
			logger.error("文件为空");
			return "文件为空，请重新上传";
		}

		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(fileUploadPath + file.getOriginalFilename());
			//如果没有files文件夹，则创建
			if (!Files.isWritable(path)) {
				Files.createDirectories(Paths.get(fileUploadPath));
			}
			//文件写入指定路径
			Files.write(path, bytes);
			logger.debug("文件写入成功...");
			return "文件上传成功";
		} catch (IOException e) {
			e.printStackTrace();
			return "后端异常...";
		}
	}
}
