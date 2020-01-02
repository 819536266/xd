package com.xd.common.base;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author huboxin
 * @title: BaseFegin
 * @projectName bk
 * @description: Fegin父类
 * @date 2019/12/3015:05
 */
public interface BaseFegin<T,ID extends Serializable>  {
    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param t 查询实体
     * @return 所有数据
     */
    @GetMapping
    R selectAll(@RequestParam Page<T> page,@RequestParam T t);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    R selectOne(@PathVariable ID id);


    /**
     * 新增数据
     *
     * @param t 实体对象
     * @return 新增结果
     */
    @PostMapping
    R insert(@RequestBody T t);


    /**
     * 修改数据
     *
     * @param t 实体对象
     * @return 修改结果
     */
    @PutMapping
    R update(@RequestBody T t);


    /**
     * 删除数据
     *
     * @param idList 主键集合
     * @return 删除结果
     */
    @DeleteMapping
    @Transactional(rollbackFor = Exception.class)
    R delete(@RequestParam("idList") List<ID> idList);

    /**
     * 删除单个数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping
    R deleteOne(@RequestParam("id") ID id);
}
