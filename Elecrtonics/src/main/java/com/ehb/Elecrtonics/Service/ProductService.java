package com.ehb.Elecrtonics.Service;

import com.ehb.Elecrtonics.Model.Category;
import com.ehb.Elecrtonics.Model.Product;
import com.ehb.Elecrtonics.dao.ProductDao;
import com.ehb.Elecrtonics.dto.ProductDto;
import com.ehb.Elecrtonics.exceptions.ProductErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    public void addProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setName(productDto.getName());
        product.setCategory(category);
        product.setPrice(productDto.getPrice());
        productDao.save(product);
    }

    public ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setName(product.getName());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setPrice(product.getPrice());
        productDto.setId(product.getId());
        return productDto;
    }

    public Iterable<ProductDto> getProducts() {
        List<Product> allProducts = (List<Product>) productDao.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : allProducts) {
            productDtos.add(getProductDto(product));
        }
        return productDtos;


    }

    public void updateProduct(ProductDto productDto, Integer productid) throws Exception {
   Optional<Product> optionalProduct=productDao.findById(productid);
   if(!optionalProduct.isPresent())
   {
       throw new Exception("product doesnt exist");
   }
        Product product = new Product();
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        productDao.save(product);
    }

    public Product findById(Integer productId) {
   Optional<Product> optionalProduct=productDao.findById(productId);
   if(optionalProduct.isEmpty())
   {
       throw new ProductErrorException("product doesn't exist"+productId);
   }
return optionalProduct.get();
    }
}
