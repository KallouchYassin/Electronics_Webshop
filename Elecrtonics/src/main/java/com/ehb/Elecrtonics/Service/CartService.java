package com.ehb.Elecrtonics.Service;

import com.ehb.Elecrtonics.Model.Cart;
import com.ehb.Elecrtonics.Model.Product;
import com.ehb.Elecrtonics.Model.User;
import com.ehb.Elecrtonics.dao.CartDao;
import com.ehb.Elecrtonics.dto.AddToCartDto;
import com.ehb.Elecrtonics.dto.CartDto;
import com.ehb.Elecrtonics.dto.CartItemDto;
import com.ehb.Elecrtonics.exceptions.newException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    ProductService productService;
    @Autowired
    CartDao cartDao;
    public void addToCart(AddToCartDto addToCartDto, User user) {
Product product=productService.findById(addToCartDto.getProductId());

        Cart cart=new Cart();
        cart.setProduct(product);
        cart.setUser(user);
        cart.setQuantity(addToCartDto.getQuantity());
        cart.setCreatedDate(new Date());
        cartDao.save(cart);

    }

    public CartDto listCartItems(User user) {
        List<Cart> cartList=cartDao.findAllByUser(user);
        List<CartItemDto> cartItems=new ArrayList<>();
       double totalCost=0;
        for (Cart cart:cartList)
        {
            CartItemDto cartItemDto=new CartItemDto(cart);
            totalCost+=cartItemDto.getQuantity()+cart.getProduct().getPrice();
            cartItems.add(cartItemDto);

        }

        CartDto cartDto=new CartDto();
        cartDto.setTotalCost(totalCost);
        cartDto.setCartItems(cartItems);
        return cartDto;


    }

    public void deleteCartItem(Integer itemId, User user) {
        Optional<Cart> optionalCart=cartDao.findById(itemId);
        if(optionalCart.isEmpty())
        {
            throw new newException("cart item is invalid "+itemId);

        }
        Cart cart=optionalCart.get();
        if (cart.getUser()!= user) {
            throw new newException("cart item does not belong to user "+itemId);

        }
    cartDao.delete(cart);
    }
}
