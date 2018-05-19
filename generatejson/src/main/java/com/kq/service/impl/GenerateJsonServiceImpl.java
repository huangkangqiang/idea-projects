package com.kq.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kq.service.GenerateJsonService;
import com.kq.utils.DataType;
import com.kq.utils.RandomUtils;
import com.kq.vo.GenerateParams;
import com.kq.vo.KqiVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by huang on 2018/4/21.
 * =============================================
 */
@Service
public class GenerateJsonServiceImpl implements GenerateJsonService {

    private static final long aDayTimestamp = 86400000L;
    private static final long aWeekTimestamp = 604800000L;
    private static final Logger logger = LoggerFactory.getLogger(GenerateJsonServiceImpl.class);
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

    @Override
    public JSONObject generateJson(GenerateParams generateParams) throws ParseException {
        logger.info("==========begin generate json=========");
        JSONObject resultJsonObj = new JSONObject();
        JSONArray resultJsonArr = putKqiJsonObj(generateParams);
        resultJsonObj.put("result", resultJsonArr);
        resultJsonObj.put("resultCode", 20000);
        resultJsonObj.put("resultMessage", "Request is successful.");
        logger.info("==========end generate json=========");
        return resultJsonObj;
    }

    private JSONArray putKqiJsonObj(GenerateParams generateParams) throws ParseException {
        String dataType = generateParams.getDataType();
        long interval = generateParams.getInterval();
        String startTime = generateParams.getStartTime();
        String endTime = generateParams.getEndTime();
        List<KqiVO> kqiVOList = generateParams.getKqiVOList();
        JSONArray resultJsonArr = null;
        switch (dataType) {
            case DataType.KQITREND:
                List<String> timeList = getTimeList(startTime, endTime, interval, 0L);
                resultJsonArr = generateKqiJsonArray(kqiVOList, timeList);
                break;
            case DataType.HISTORYKQITREND:
                resultJsonArr = new JSONArray();
                JSONObject jsonObject = new JSONObject();
                List<String> todayTimeList = getTimeList(startTime, endTime, interval, 0L);
                JSONArray todayJsonArr = generateKqiJsonArray(kqiVOList, todayTimeList);
                jsonObject.put("today", todayJsonArr);
                List<String> yesterdayTimeList = getTimeList(startTime, endTime, interval, aDayTimestamp);
                JSONArray yesterdayJsonArr = generateKqiJsonArray(kqiVOList, yesterdayTimeList);
                jsonObject.put("yesterday", yesterdayJsonArr);
                List<String> lastweekTimeList = getTimeList(startTime, endTime, interval, aWeekTimestamp);
                JSONArray lastweekJsonArr = generateKqiJsonArray(kqiVOList, lastweekTimeList);
                jsonObject.put("lastweek", lastweekJsonArr);
                resultJsonArr.add(jsonObject);
                break;
        }
        return resultJsonArr;
    }

    private JSONArray generateKqiJsonArray(List<KqiVO> kqiVOList, List<String> timeList) {
        JSONArray kqiJsonArray = new JSONArray();
        for (String timeStr : timeList) {
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = putRandomKqi(kqiVOList);
            jsonObject.put("kqi", jsonArray);
            jsonObject.put("objId", "");
            jsonObject.put("objName", "");
            jsonObject.put("objTime", timeStr);
            kqiJsonArray.add(jsonObject);
        }
        return kqiJsonArray;
    }

    private JSONArray putRandomKqi(List<KqiVO> kqiVOList) {
        JSONArray kqiJsonArray = new JSONArray();
        for (KqiVO kqiVO : kqiVOList) {
            JSONObject kqiJsonObj = putRandomValue(kqiVO);
            kqiJsonArray.add(kqiJsonObj);
        }
        return kqiJsonArray;
    }

    private JSONObject putRandomValue(KqiVO kqiVO) {
        JSONObject kqiJsonObj = new JSONObject();
        kqiJsonObj.put("id", kqiVO.getId());
        kqiJsonObj.put("value", RandomUtils.getRandomValue(kqiVO.getMin(), kqiVO.getMax(), kqiVO.getScale()));
        kqiJsonObj.put("unit", kqiVO.getUnit());
        kqiJsonObj.put("serType", kqiVO.getSerType());
        return kqiJsonObj;
    }

    private List<String> getTimeList(String startTime, String endTime, long interval, long change) throws ParseException {
        List<String> timeList = new ArrayList<>();
        interval *= 1000L;
        long startTimeStamp = timeFormat.parse(startTime).getTime() - change;
        long endTimeStamp = timeFormat.parse(endTime).getTime() - change;
        for (long i = startTimeStamp; i <= endTimeStamp; ) {
            String timeStr = timeFormat.format(new Date(i));
            timeList.add(timeStr);
            i += interval;
        }
        return timeList;
    }
}
