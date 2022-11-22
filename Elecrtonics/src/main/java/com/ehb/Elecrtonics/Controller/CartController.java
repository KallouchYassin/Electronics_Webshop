package com.ehb.Elecrtonics.Controller;


import com.ehb.Elecrtonics.Model.User;
import com.ehb.Elecrtonics.Service.AuthenticationService;
import com.ehb.Elecrtonics.Service.CartService;
import com.ehb.Elecrtonics.dto.AddToCartDto;
import com.ehb.Elecrtonics.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
private CartService cartService;
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/add")
    public String addToCart(@RequestBody AddToCartDto addToCartDto, @RequestParam("token") String token)

    {
        authenticationService.authenticate(token);
        User user=authenticationService.getUser(token);
cartService.addToCart(addToCartDto,user);
return "Added to cart";
    }
    @GetMapping("/list")
    public CartDto getCartItems(@RequestParam("token") String token)
    {
        authenticationService.authenticate(token);
        User user=authenticationService.getUser(token);
CartDto cartDto =cartService.listCartItems(user);
return cartDto;
    }

    @DeleteMapping("/delete/{cartItemId}")
    public String deleteCartItem(@PathVariable("cartItemId")Integer itemId,@RequestParam("token") String token )
    {
        authenticationService.authenticate(token);
        User user=authenticationService.getUser(token);
cartService.deleteCartItem(itemId,user);

return "Cart succesfully deleted";
    }
}
