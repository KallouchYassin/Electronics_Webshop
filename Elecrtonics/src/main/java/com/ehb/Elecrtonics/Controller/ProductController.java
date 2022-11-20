package com.ehb.Elecrtonics.Controller;

import com.ehb.Elecrtonics.Model.Category;
import com.ehb.Elecrtonics.Model.Product;
import com.ehb.Elecrtonics.Service.ProductService;
import com.ehb.Elecrtonics.dao.CategoryDao;
import com.ehb.Elecrtonics.dao.ProductDao;
import com.ehb.Elecrtonics.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
@Autowired
CategoryDao categoryDao;

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody ProductDto productDto)
    {
        Optional<Category> optionalCategory=categoryDao.findById(productDto.getCategoryId());
        if(!optionalCategory.isPresent())
        {
            return "does not exist";
        }
         productService.addProduct(productDto,optionalCategory.get());
        return "Succeed";
    }
    @GetMapping("/listProduct")
    public Iterable<ProductDto> listProduct()
    {
        return productService.getProducts();
    }
    @PutMapping("/update/{productId}")
    public String editProduct(@PathVariable("productId")Integer productId,@RequestBody ProductDto productDto ) throws Exception {
        Optional<Category> optionalCategory=categoryDao.findById(productDto.getCategoryId());
        if(!optionalCategory.isPresent())
        {
            return "does not exist";
        }
        productService.updateProduct(productDto,productId);
        return "Succeed";
    }
}
