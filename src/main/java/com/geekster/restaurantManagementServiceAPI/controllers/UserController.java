package com.geekster.restaurantManagementServiceAPI.controllers;

import com.geekster.restaurantManagementServiceAPI.dto.SignInInput;
import com.geekster.restaurantManagementServiceAPI.dto.SignInOutput;
import com.geekster.restaurantManagementServiceAPI.dto.SignUpOutput;
import com.geekster.restaurantManagementServiceAPI.models.Food;
import com.geekster.restaurantManagementServiceAPI.models.Order;
import com.geekster.restaurantManagementServiceAPI.models.Status;
import com.geekster.restaurantManagementServiceAPI.models.User;
import com.geekster.restaurantManagementServiceAPI.services.OrderService;
import com.geekster.restaurantManagementServiceAPI.services.TokenService;
import com.geekster.restaurantManagementServiceAPI.services.UserService;
import jakarta.validation.Valid;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @Autowired
    TokenService authService;

    @Autowired
    OrderService orderService;


    @PostMapping("/signup")
    public SignUpOutput signUp(@Valid @RequestBody User signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signin")
    public SignInOutput signIn(@Valid @RequestBody SignInInput signInDto){
        return userService.signIn(signInDto);
    }

    @DeleteMapping("/signout")
    public ResponseEntity<String> signOut(@RequestParam String email , @RequestParam String token){
        HttpStatus status;
        String msg=null;

        if(authService.authenticate(email,token))
        {
            authService.deleteToken(token);
            msg = "Signout Successful";
            status = HttpStatus.OK;

        }
        else
        {
            msg = "Invalid User";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg , status);
    }
    @GetMapping("/menu")
    public List<Food> getMenu(){
        return userService.getMenu();
    }

    @PostMapping("/order/userEmail/{userEmail}/token/{token}")
    public ResponseEntity<Status>postOrder(@PathVariable String userEmail, @PathVariable String token,@RequestBody Order order){
        HttpStatus status;
        Status message;
        if(authService.authenticate(userEmail,token)){
            status = HttpStatus.CREATED;
            message = Status.ORDERED;
            userService.postOrder(order);

        }
        else{
            message = Status.FAILED;
            status =HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<Status>(message,status);

    }

    @GetMapping("/order/userId/{userId}")
    public ResponseEntity<List<Order>> getOrderByUserId(@PathVariable Long userId,@RequestParam String userEmail,@RequestParam String token){
        HttpStatus status;
        List<Order>allOrder = null;
        if(authService.authenticate(userEmail,token)){
            status = HttpStatus.CREATED;
            allOrder=userService.getOrderByUserId(userId);

        }
        else{
            status =HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<List<Order>>(allOrder,status);
    }
    @DeleteMapping("order/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable Long orderId,@RequestParam String userEmail,@RequestParam String token){
        String message = null;
        HttpStatus status;
        List<Order>allOrder = null;
        if(authService.authenticate(userEmail,token)){
            userService.cancelOrder(orderId);
            status = HttpStatus.CREATED;
            message = "Order is cancelled successfully";

        }
        else{
            status =HttpStatus.FORBIDDEN;
            message = "Order is not not cancelled";
        }
        return new ResponseEntity<String>(message,status);
    }

}
