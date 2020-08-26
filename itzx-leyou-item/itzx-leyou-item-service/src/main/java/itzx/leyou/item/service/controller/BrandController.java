package itzx.leyou.item.service.controller;

import itzx.leyou.common.pojo.PageResult;
import itzx.leyou.item.pojo.Brand;
import itzx.leyou.item.service.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * itzx.leyou.item.service.controller
 *
 * @author Rick Zhang
 * @version 1.0.0
 * @since 2020/5/22 10:18
 */
@RestController

@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;
    @GetMapping("/page")
    public ResponseEntity<PageResult<Brand>> queryBrandsByPage(
            @RequestParam( value ="key",required = false) String key,
            @RequestParam( value ="page",defaultValue = "1") Integer page,
            @RequestParam( value ="rows",defaultValue = "5") Integer rows,
            @RequestParam( value ="sortBy",required = false) String sortBy,
            @RequestParam( value ="desc",required = false) Boolean desc
    ){
       PageResult result= this.brandService.queryBrandsByPage(key,page,rows,sortBy,desc);
       if(result==null|| CollectionUtils.isEmpty(result.getItems())){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand, @RequestParam("cids") List<Long> cids){
        this.brandService.saveBrand(brand,cids);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
