package com.bin.bole.api;

import lombok.extern.slf4j.Slf4j;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.junit.jupiter.api.Test;

/**
 * @author binLi
 * @date 2021/5/16 11:33
 * Description:
 */
@Slf4j
public class FdfsTest extends BoleApplicationTests {


    @Test
    void testUpload() {
        try {
            ClientGlobal.initByProperties("fastdfs-client.properties");
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;
            StorageClient1 client = new StorageClient1(trackerServer, storageServer);
            NameValuePair nvp[] = null;
            //上传到文件系统
            String fileId = client.upload_file1("C:\\Users\\Bing\\Pictures\\图标\\1.png", "png",
                    nvp);
            log.info("fileId={}", fileId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
