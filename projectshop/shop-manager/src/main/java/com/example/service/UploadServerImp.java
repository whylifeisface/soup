package com.example.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Service;
import java.io.InputStream;

@Service
public class UploadServerImp {
   public String upload(InputStream inputStream, String fileName){
       Configuration cfg = new Configuration(Region.region0());
       //...其他参数参考类注释
       UploadManager uploadManager = new UploadManager(cfg);
       //...生成上传凭证，然后准备上传
       String accessKey = "-8AowYUVXWbcTbmDX1e2jWCF3oBugGqxMBKQKSGP";
       String secretKey = "Kd8m4BbsJFJURN6K-AHtjOen6HU-d7uyhLpRm5di";
       String bucket = "project1-shop";
       //默认不指定key的情况下，以文件内容的hash值作为文件名
       String result = null;
       String key = fileName;
       try {

           Auth auth = Auth.create(accessKey, secretKey);
           String upToken = auth.uploadToken(bucket);
           try {
               Response response = uploadManager.put(inputStream,key,upToken,null, null);
               //解析上传成功的结果
               if (response.statusCode == 200) {
                   result = "http:reou73saa.hn-bkt.clouddn.com" + key;
               }
           } catch (QiniuException ex) {
               Response r = ex.response;
               System.err.println(r.toString());
               try {
                   System.err.println(r.bodyString());
               } catch (QiniuException ex2) {
                   //ignore
               }
           }
       } catch (Exception ex) {
           //ignore
       }
       return result;
   }
}
