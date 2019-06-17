package com.ecs.service;

import com.ecs.mapper.PrisonerPhysiologicalDataMapper;
import com.ecs.model.PrisonerPhysiologicalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Zhaoone on 2019/4/16
 **/
@Service
public class InsertDateToDbService {
    PrisonerPhysiologicalDataMapper prisonerPhysiologicalDataMapper;
    PrisonerPhysiologicalData prisonerPhysiologicalData;

    @Autowired
    public InsertDateToDbService(PrisonerPhysiologicalDataMapper prisonerPhysiologicalDataMapper) {
        this.prisonerPhysiologicalDataMapper = prisonerPhysiologicalDataMapper;
    }

    private void listenPort() throws IOException {
        Socket socket = new Socket();
        InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bReader = new BufferedReader(isReader);
        String s = bReader.readLine();
        String[] str = s.split(" ");
        prisonerPhysiologicalData.setPrisoner_id(str[0]);
        prisonerPhysiologicalData.setCurrent_time(str[1]);
        prisonerPhysiologicalData.setPrioner_heatbeat_permin(str[2]);
    }

    public void toDatabase() throws IOException {
        listenPort();
        prisonerPhysiologicalDataMapper.insertNewPhysiologicalDataMapper(prisonerPhysiologicalData);
    }
}
