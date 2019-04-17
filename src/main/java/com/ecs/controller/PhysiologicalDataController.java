package com.ecs.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jojo
 * @Description:
 * @Date: Created on 2019/4/11 20:41
 */

@RestController
@RequestMapping(path = "/psl_data")
@Api(tags = "PhysiologicalData", description = "设备相关的操作")
public class PhysiologicalDataController {

    // TODO: 读取生理数据controller
}
