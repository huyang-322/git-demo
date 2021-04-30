package com.ylkj.modules.sqfz.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ylkj.common.util.ResultVO;
import com.ylkj.modules.sqfz.domain.Picture;
import com.ylkj.modules.sqfz.service.IPictureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hyy
 * @since 2021-04-28
 */
@RestController
@RequestMapping("/sqfz/picture")
@RequiredArgsConstructor
@Api(tags = "社区发展-照片墙")
public class PictureController {
    private final IPictureService service;

    /**
    * 分页查询
    */
    @GetMapping("/page")
    @ApiOperation("分页查询")
    public IPage<Picture> page(@RequestParam(name = "current", defaultValue = "1", required = false) @ApiParam("当前页")Integer current,
    @RequestParam(name = "pageSize", defaultValue = "10", required = false) @ApiParam("每页显示条数")Integer pageSize){
        return service.page(new Page<>(current, pageSize));
    }

    /**
    * 新增
    */
    @ApiOperation("新增")
    @PostMapping
    public Boolean save(@RequestBody Picture body){
        return service.save(body);
    }

    /**
    * 修改
    */
    @ApiOperation("修改")
    @PutMapping
    public Boolean update(@RequestBody Picture body){
        return service.updateById(body);
    }

    /**
    * 根据ID获取当前对象
    */
    @ApiOperation("查询")
    @GetMapping("/{id}")
    public Picture getOneById(@PathVariable Long id){
        return service.getById(id);
    }


    /**
    * 删除
    */
    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id){
        return service.removeById(id);
    }

    @ApiOperation("全部查询")
    @GetMapping("/list/{type}")
    public ResultVO list(@PathVariable int type){
        return new ResultVO(service.findByType(type));
    }

}



