package itzx.leyou.item.service.service;

import itzx.leyou.item.pojo.Category;
import itzx.leyou.item.service.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * itzx.leyou.item.service.service
 *
 * @author Rick Zhang
 * @version 1.0.0
 * @since 2020/5/10 18:53
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 根据父节点查询子节点
     * @param pid
     * @return
     */
    public List<Category> queryCategoriesByPid(Long pid) {
        Category category = new Category();
        category.setParentId(pid);
        return this.categoryMapper.select(category);
    }
}
