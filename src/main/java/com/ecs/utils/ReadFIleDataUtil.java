package com.ecs.utils;

import com.ecs.model.PrisonerGps;
import com.ecs.model.PrisonerPhysiologicalData;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Zhaoone on 2019/4/2
 **/
public class ReadFIleDataUtil {
    private static final String mysqlSdfPatternString = "yyyy-MM-dd HH:mm";
    private static final Date now = new Date();
    private static final SimpleDateFormat sdf = new SimpleDateFormat(mysqlSdfPatternString);
    private static final String now_string = sdf.format(now);

    /*  因为不知道数据具体的格式，例如，是否所有数据在一个文件中，文件格式是否为txt/csv，是否能直接读字符串，
      所以在数据量不是特别大得情况，暂且假设所有的数据均存在一个txt文件中，每行由“时间：心跳次数”组成*/
    /* 将当前对应分钟的心跳读出来放在PrisonerPhysiologicalData的对象中*/
    public static PrisonerPhysiologicalData getPhysiologicalData(String pathName) throws IOException {  //pathName应该与时间和犯人信息相关
        PrisonerPhysiologicalData prisonerPhysiologicalData = new PrisonerPhysiologicalData();
        prisonerPhysiologicalData.setCurrent_time(now_string);

        File file = new File(pathName);
        if (!file.exists())
            throw new RuntimeException("Not File!");   //当file找不到时，应该是失去和终端连接，不再有新的数据传入，catch exception前端提示失联
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s;
        while ((s = br.readLine()) != null) {
            String str[] = s.split(":");
            if (str[0].equals(now_string)) {
                prisonerPhysiologicalData.setPrioner_heatbeat_permin(str[1]);
                return prisonerPhysiologicalData;
            }
        }
        throw new RuntimeException("No Data!");   //Data找不到和file相同
    }

    public static PrisonerGps getGps(String pathName) throws IOException {
        PrisonerGps prisonerGps = new PrisonerGps();
        prisonerGps.setCurrent_time(now_string);

        File file = new File(pathName);
        if (!file.exists())
            throw new RuntimeException("Not File!");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s;
        while ((s = br.readLine()) != null) {
            String str[] = s.split(":");
            String strposition[] = str[1].split(";");
            if (str[0].equals(now_string)) {
                prisonerGps.setHeight(strposition[0]);
                prisonerGps.setLatitude(str[1]);
                prisonerGps.setLongitude(str[2]);
                return prisonerGps;
            }
        }
        throw new RuntimeException("No Data!");
    }
}