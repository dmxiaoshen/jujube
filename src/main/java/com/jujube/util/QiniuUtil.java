package com.jujube.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qiniu.common.QiniuException;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class QiniuUtil {
	private static final Logger logger = LoggerFactory.getLogger(QiniuUtil.class);
	private static String bucket = "test";
	private static String  prefix= "http://7xjivo.com2.z0.glb.qiniucdn.com";
	private static String  access_key= "B_4rspsmsLlMl8nMnw4uZIeATzNFlS8wQiwjIZ6i";
	private static String  secret_key= "ak0nk0_iYQ0mFz6z5e3Uvo1uvmkC84K5Ppx9m6J9";

	public static void deleteFileFromQiniu(String key) {
		// 实例化一个BucketManager对象
		BucketManager bucketManager = new BucketManager(getAuth());
		try {
			bucketManager.delete(bucket, key);
		} catch (QiniuException e) {
			logger.error("QiniuUtil deleteFileFromQiniu error {},{}", key, e.getMessage());
		}
	}

	public static InputStream getContentInputStream(String url) {
		URL resouceUrl = null;
		InputStream inputStream = null;
		try {
			resouceUrl = new URL(url);
		} catch (MalformedURLException e) {
			logger.error("QiniuUtil getContentInputStream error {},{}", url, e.getMessage());
			return inputStream;
		}
		try {
			inputStream = (InputStream) resouceUrl.getContent();
		} catch (IOException e) {
			logger.error("QiniuUtil getContentInputStream error {},{}", url, e.getMessage());
			return inputStream;
		}
		return inputStream;
	}

	public static String uploadFileToQiniu(byte[] data, String key) {
		Auth auth = getAuth();
		UploadManager uploadManager = new UploadManager();
		try {
			uploadManager.put(data, key, auth.uploadToken(bucket));
		} catch (QiniuException e) {
			logger.error("QiniuUtil uploadFileToQiniu error {},{}", key, e.getMessage());
			return null;
		}
		StringBuilder sb = new StringBuilder(prefix);
		if (prefix.lastIndexOf("/") == prefix.length() - 1) {
			return sb.append(key).toString();
		}
		return sb.append("/").append(key).toString();
	}

	private static Auth getAuth() {
		return Auth.create(access_key, secret_key);
	}
	
	
	public static void main(String[] args) {
		deleteFileFromQiniu("20160321111323509aca21ab54da24651a5ef34ed9a0ba233_credit_flow.bpmn");
	}
}
