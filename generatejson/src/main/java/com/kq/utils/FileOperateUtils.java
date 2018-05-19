package com.kq.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 文件操作
 * Created by huang on 2018/4/21.
 * =============================================
 */
public class FileOperateUtils {

    private static final Logger logger = LoggerFactory.getLogger(FileOperateUtils.class);

    /**
     * 根据json对象生成json文件
     *
     * @param desPath    目标json文件路径
     * @param desJsonObj 目标json对象
     * @throws Exception 异常
     */
    public static void generateJsonFile(String desPath, JSONObject desJsonObj) throws Exception {
        BufferedWriter writer = null;
        File desFile = new File(desPath);
        try {
            if (!desFile.exists()) {
                if (!desFile.createNewFile()) {
                    throw new RuntimeException("无法创建json文件");
                }
            }
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(desFile), "UTF-8"));
            if (desJsonObj == null) {
                throw new RuntimeException("json对象为空");
            }
            writer.write(desJsonObj.toJSONString());
            writer.flush();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static void readFile(String filePath, OutputStream out) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("文件不存在！");
        }
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            byte[] bufferArray = new byte[1024];
            int byteReadLength;
            while ((byteReadLength = in.read(bufferArray)) != -1) {
                out.write(bufferArray, 0, byteReadLength);
                out.flush();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

}
