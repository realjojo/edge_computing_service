package com.ecs.controller;

import com.ecs.model.Prisoner;
import com.ecs.service.PrisonerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: jojo
 * @Description:
 * @Date: Created on 2019/5/6 21:22
 */
@RestController
@RequestMapping(path = "/prisoners")
@EnableAutoConfiguration
@Api(tags = "Prisoner", description = "获取犯人信息")
public class PrisonerController {

    private final PrisonerService prisonerService;

    @Autowired
    public PrisonerController(PrisonerService prisonerService) {
        this.prisonerService = prisonerService;
    }

    @ApiOperation(value = "获取单个犯人信息")
    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public Prisoner getById(@RequestParam("id") String id) {
        return prisonerService.getById(id);
    }

    @ApiOperation(value = "获取所有犯人信息")
    @RequestMapping(path = "/get_all", method = RequestMethod.GET)
    public List<Prisoner> getAll() {
        return prisonerService.getAll();
    }

}
