package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
private CategoryMapper categoryMapper;

    /**
     * 根据pid查询子节点
     * @param pid
     *
     */
    public List<Category> queryCategoryServiceByPid(Long pid) {
        Category category = new Category();
        category.setId(pid);
       return categoryMapper.select(category);
    }
}
