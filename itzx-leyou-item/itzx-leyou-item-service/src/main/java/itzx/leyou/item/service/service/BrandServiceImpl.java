package itzx.leyou.item.service.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import itzx.leyou.common.pojo.PageResult;
import itzx.leyou.item.pojo.Brand;
import itzx.leyou.item.service.mapper.BrandMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * itzx.leyou.item.service.service
 *
 * @author Rick Zhang
 * @version 1.0.0
 * @since 2020/5/22 11:08
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;


    /**
     * 根据查询条件，分页查询品牌，并排序
     *
     * @param key
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    @Override
    public PageResult queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) {
        //初始化Example
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(key)){
            criteria.andLike("name","%"+key+"%")
                    .orEqualTo("letter",key);
        }

        // page，rows： 添加分页条件
        PageHelper.startPage(page,rows);
        // sortBy,desc：添加排序条件
        if (StringUtils.isNotBlank(sortBy)){
            example.setOrderByClause(sortBy+" "+(desc?"desc":"asc"));
        }

        // key： 根据name模糊查询，或者根据首字母查询
        List<Brand> brands = this.brandMapper.selectByExample(example);

        //包装成PageInfo对象
        PageInfo<Brand> pageInfo=new PageInfo<>(brands);
        //包装成分页结果集返回
        return new PageResult<Brand>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 新增品牌
     *
     * @param brand
     * @param cids
     */
    @Transactional
    @Override
    public void saveBrand(Brand brand, List<Long> cids) {
        //先新增brand，再新增中间表
        if (this.brandMapper.insertSelective(brand)==1){//如果为true就新增中间表
            cids.forEach(cid->{
                this.brandMapper.insertCategoryAndBrand(brand.getId(),cid);
            });
        }
    }
}
