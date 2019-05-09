package com.ecs.service;

import com.ecs.mapper.PrisonerMapper;
import com.ecs.model.Prisoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jojo
 * @Description:
 * @Date: Created on 2019/5/6 21:23
 */
@Service
public class PrisonerService {

    private final PrisonerMapper prisonerMapper;

    @Autowired
    public PrisonerService(PrisonerMapper prisonerMapper) {
        this.prisonerMapper = prisonerMapper;
    }

    public Prisoner getById(String id) {
        return prisonerMapper.getById(id);
    }

    public List<Prisoner> getAll() {
        return prisonerMapper.getAll();
    }

}
