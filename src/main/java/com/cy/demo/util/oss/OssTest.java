package com.cy.demo.util.oss;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

public class OssTest {
    private static String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
    private static String accessKeyId = "LTAIrU7ih8qkN6pH";
    private static String accessKeySecret = "mHUeQU7Sfv2BKYUz2Uc0JM53jhIsRP";
    private static String bucketName = "cy20190514";

    public static void main(String[] args) throws IOException {
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            // 上传文件流。
            InputStream inputStream = new FileInputStream("D:/mailImg/图片2.jpg");
            client.putObject(bucketName, "test/b1.jpg", inputStream);

            // 生成URL
            // 设置URL过期时间为10年  3600l* 1000*24*365*10
            Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
            URL url = client.generatePresignedUrl(bucketName, "test/b1.jpg", expiration);
            if (url != null) {
                System.out.println(url.toString());
            }

        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message: " + oe.getErrorCode());
            System.out.println("Error Code:       " + oe.getErrorCode());
            System.out.println("Request ID:      " + oe.getRequestId());
            System.out.println("Host ID:           " + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ce.getMessage());
        } finally {
            client.shutdown();
        }
    }

}
