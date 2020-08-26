package itzx.leyou.item.service.service;

import itzx.leyou.common.pojo.PageResult;
import itzx.leyou.item.pojo.Brand;

import java.util.List;

/**
 * itzx.leyou.item.service.service
 *
 * @author Rick Zhang
 * @version 1.0.0
 * @since 2020/5/22 11:08
 */
public interface BrandService {
    /**
     * 根据查询条件，分页查询品牌
     * @param key
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    PageResult queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc);

    /**
     * 新增品牌
     * @param brand
     * @param cids
     */
    void saveBrand(Brand brand, List<Long> cids);
}
