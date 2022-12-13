package com.ehb.Elecrtonics.Controller;


import com.ehb.Elecrtonics.Service.AuthenticationService;
import com.ehb.Elecrtonics.Service.OrderService;
import com.ehb.Elecrtonics.dto.CheckoutItemDto;
import com.ehb.Elecrtonics.dto.StripeResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {

@Autowired
    private AuthenticationService authenticationService;

@Autowired
    private OrderService orderService;

@PostMapping("/create-checkout")
public StripeResponse checkoutList(@RequestBody List<CheckoutItemDto> checkoutItemDtoList) throws StripeException {
    Session session=orderService.createSession(checkoutItemDtoList);
    StripeResponse stripeResponse =new StripeResponse(session.getId());
    return stripeResponse;
}
}
