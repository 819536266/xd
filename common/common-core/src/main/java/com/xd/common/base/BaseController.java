package com.xd.common.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author huboxin
 * @title: BaseController
 * @projectName bk
 * @description: 控制器父类
 * @date 2019/12/3013:40
 */


public class BaseController<E extends IService<T>, T ,ID extends Serializable> extends ApiController implements BaseFegin<T,ID>{

    /**
     * 服务对象
     */
    @Autowired
    protected E service;


    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param t 查询实体
     * @return 所有数据
     */

    @GetMapping
    @ApiOperation(value = "分页查询所有数据")
    @Override
    public R selectAll(@ApiParam("分页对象")@RequestParam Page<T> page,@ApiParam("查询实体") @RequestParam T t) {
        IPage<T> page1 = this.service.page(page, new QueryWrapper<>(t));
        return success(page1);
    }




    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation(value = "通过主键查询单条数据",notes = "通过主键查询单条数据")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="id",value = "id"),
    })
    @Override
    public R selectOne(@PathVariable ID id) {
        return success(this.service.getById(id));
    }

    /**
     * 新增数据
     *
     * @param t 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation(value = "新增数据",notes = "新增数据")
    @Override
    public R insert(@RequestBody @ApiParam("实体对象")  T t) {
        return success(this.service.save(t));
    }

    /**
     * 修改数据
     *
     * @param t 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation(value = "修改数据",notes = "修改数据")
    @Override
    public R update(@RequestBody @ApiParam("实体对象") T t) {
        return success(this.service.updateById(t));
    }




    /**
     * 删除数据
     *
     * @param idList 主键集合
     * @return 删除结果
     */
    @DeleteMapping("delete")
    @ApiOperation(value = "删除数据",notes = "删除数据")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="idList ",value = "主键集合"),
    })
    @Override
    @Transactional(rollbackFor = Exception.class)
    public R delete(@RequestParam("idList") List<ID> idList) {
        return success(this.service.removeByIds(idList));
    }

    /**
     * 删除单个数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("deleteOne")
    @ApiOperation(value = "删除单个数据",notes = "删除单个数据")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="id ",value = "主键"),
    })
    @Override
    public R deleteOne(@RequestParam("id") ID id) {
        return success(this.service.removeById(id));
    }

}
