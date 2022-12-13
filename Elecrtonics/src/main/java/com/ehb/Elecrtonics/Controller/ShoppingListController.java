package com.ehb.Elecrtonics.Controller;

import com.ehb.Elecrtonics.Model.Product;
import com.ehb.Elecrtonics.Model.ShoppingList;
import com.ehb.Elecrtonics.Model.User;
import com.ehb.Elecrtonics.Service.AuthenticationService;
import com.ehb.Elecrtonics.Service.ShoppingListService;
import com.ehb.Elecrtonics.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin
@RequestMapping("/shoppinglist")
public class ShoppingListController {

    @Autowired
    ShoppingListService shoppingListService;
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/add")
    public String addToList(@RequestBody Product product, @RequestParam("token") String token)
    {
authenticationService.authenticate(token);
        User user=authenticationService.getUser(token);
        ShoppingList shoppingList=new ShoppingList(user,product);
        shoppingListService.createShoppingList(shoppingList);
        return "Product added succesfully";

    }

    @GetMapping("/{token}")
    public List<ProductDto> getShoppingList(@PathVariable("token")String token)
    {
        authenticationService.authenticate(token);
        User user=authenticationService.getUser(token);
List<ProductDto> shoppingList= shoppingListService.getShoppingList(user);

return  shoppingList;
    }
}
