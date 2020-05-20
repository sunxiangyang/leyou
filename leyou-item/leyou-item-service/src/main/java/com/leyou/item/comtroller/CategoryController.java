package com.leyou.item.comtroller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import com.mysql.jdbc.log.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     *
     * @param pid
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoryServiceByPid(@RequestParam(value = "pid",defaultValue = "0")Long pid){

            if (pid == null || pid<0){
                return ResponseEntity.badRequest().build();
            }
            List<Category> categories = categoryService.queryCategoryServiceByPid(pid);
            if (CollectionUtils.isEmpty(categories)){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(categories);
        }
    }

