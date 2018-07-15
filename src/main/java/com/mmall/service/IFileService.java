package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by wangfei
 */
public interface IFileService {

    String upload(MultipartFile file, String path);
}
