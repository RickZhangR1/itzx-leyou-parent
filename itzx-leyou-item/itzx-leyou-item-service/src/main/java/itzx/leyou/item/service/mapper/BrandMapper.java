package itzx.leyou.item.service.mapper;

import itzx.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * itzx.leyou.item.service.mapper
 *
 * @author Rick Zhang
 * @version 1.0.0
 * @since 2020/5/22 11:03
 */
public interface BrandMapper extends Mapper<Brand> {
    @Insert("insert into tb_category_brand (category_id,brand_id) values(#{cid},#{bid})")
    void insertCategoryAndBrand(@Param("bid") Long bid, @Param("cid") Long cid);
}
