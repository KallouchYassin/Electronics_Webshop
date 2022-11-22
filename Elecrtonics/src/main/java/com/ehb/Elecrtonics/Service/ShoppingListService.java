package com.ehb.Elecrtonics.Service;

import com.ehb.Elecrtonics.Model.Product;
import com.ehb.Elecrtonics.Model.ShoppingList;
import com.ehb.Elecrtonics.Model.User;
import com.ehb.Elecrtonics.dao.ShoppingListDao;
import com.ehb.Elecrtonics.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingListService {

    @Autowired
    ShoppingListDao shoppingListDao;

@Autowired
ProductService productService;
    public void createShoppingList(ShoppingList shoppingList) {

        shoppingListDao.save(shoppingList);
    }

    public List<ProductDto> getShoppingList(User user) {
   final List<ShoppingList> shoppingLists=shoppingListDao.findByUser(user);
List<ProductDto> productDtos=new ArrayList<>();
for (ShoppingList shoppingList1:shoppingLists)
{
    productDtos.add(productService.getProductDto(shoppingList1.getProduct()));
}
return productDtos;
    }
}
