package com.kq.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kq.service.GenerateJsonService;
import com.kq.utils.FileOperateUtils;
import com.kq.vo.GenerateParams;
import com.kq.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huang on 2018/4/21.
 * =============================================
 */
@Controller
@RequestMapping("/json")
public class GenerateJsonController {

    private final Logger logger = LoggerFactory.getLogger(GenerateJsonController.class);
    private final GenerateJsonService generateJsonService;
    @Value("${generatejson.basePath}")
    private String basePath;

    @Autowired
    public GenerateJsonController(GenerateJsonService generateJsonService) {
        this.generateJsonService = generateJsonService;
    }

    @RequestMapping(value = "/generate", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    ResponseVO generateJson(@RequestBody GenerateParams generateParams) {
        logger.info("==========begin generate json===========");
        ResponseVO responseVO = new ResponseVO();
        try {
            JSONObject resultJsonObj = generateJsonService.generateJson(generateParams);
            if (resultJsonObj == null) {
                throw new RuntimeException("生成JSON为空");
            }
            if (basePath == null) {
                throw new RuntimeException("存储路径未配置！");
            }
            String fileName = generateParams.getDataType() + "_" + new Date().getTime() + ".json";
            String filePath = basePath + File.separator + fileName;
            FileOperateUtils.generateJsonFile(filePath, resultJsonObj);
            responseVO.setResultCode(200);
            Map<String, Object> result = new HashMap<>();
            result.put("fileName", fileName);
            responseVO.setResult(result);
            responseVO.setResultMessage("成功生成json文件！");
        }catch (ParseException p){
            logger.error(p.getMessage());
            responseVO.setResultCode(400);
            responseVO.setResultMessage("开始时间或结束时间格式不对！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            responseVO.setResultCode(500);
            responseVO.setResultMessage(e.getMessage());
        }
        return responseVO;
    }

    @RequestMapping(value = "/download/{fileName}", method = RequestMethod.GET)
    public void download(@PathVariable String fileName, HttpServletResponse response) {
        OutputStream out = null;
        ResponseVO responseVO = new ResponseVO();
        try {
            String contentType = "application/octet-stream";
            response.setHeader("content-type", contentType);
            response.setContentType(contentType);
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            out = response.getOutputStream();
            if (basePath == null) {
                throw new RuntimeException("存储路径未配置！");
            }
            if (fileName == null) {
                throw new RuntimeException("文件不存在！");
            }
            String filePath = basePath + File.separator + fileName;
            FileOperateUtils.readFile(filePath, out);
        } catch (Exception e) {
            logger.error(e.getMessage());
            responseVO.setResultCode(500);
            responseVO.setResultMessage(e.getMessage());
            try {
                if (out != null) {
                    out.write(JSON.toJSONString(responseVO).getBytes());
                    out.flush();
                }
            } catch (Exception e1) {
                logger.error(e1.getMessage());
            }
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }
}
