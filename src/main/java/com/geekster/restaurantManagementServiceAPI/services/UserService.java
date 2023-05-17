package com.geekster.restaurantManagementServiceAPI.services;

import com.geekster.restaurantManagementServiceAPI.dto.SignInInput;
import com.geekster.restaurantManagementServiceAPI.dto.SignInOutput;
import com.geekster.restaurantManagementServiceAPI.dto.SignUpOutput;
import com.geekster.restaurantManagementServiceAPI.models.AuthenticationToken;
import com.geekster.restaurantManagementServiceAPI.models.Food;
import com.geekster.restaurantManagementServiceAPI.models.Order;
import com.geekster.restaurantManagementServiceAPI.models.User;
import com.geekster.restaurantManagementServiceAPI.repositories.IUserRepo;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;

    @Autowired
    TokenService tokenService;

    @Autowired
    FoodService foodService;

    @Autowired
    OrderService orderService;


    public SignUpOutput signUp(User signUpDto) {


        //check if user exists or not based on email
        User user = userRepo.findFirstByUserEmail(signUpDto.getUserEmail());

        if(user != null)
        {
            throw new IllegalStateException("Instagram user already exists!!!!...sign in instead");
        }

//      encryption
        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signUpDto.getUserPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        signUpDto.setUserPassword(encryptedPassword);
        userRepo.save(signUpDto);

        return new SignUpOutput("Restaurant user registered","Restaurant account created successfully");

    }
    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digested = md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);
        return hash;
    }

    public SignInOutput signIn(SignInInput signInDto) {
        //check if user exists or not based on email
        User user = userRepo.findFirstByUserEmail(signInDto.getEmail());

        if(user == null)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signInDto.getPassword());
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }

        //match it with database encrypted password

        boolean isPasswordValid = encryptedPassword.equals(user.getUserPassword());

        if(!isPasswordValid)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        AuthenticationToken token = new AuthenticationToken(user);

        tokenService.saveToken(token);

        //set up output response

        return new SignInOutput("Authentication Successfull !!!", token.getToken());

    }


    public List<Food> getMenu() {
        return foodService.getMenu();
    }

    public void postOrder(Order order) {
        orderService.postOrder(order);

    }

    public List<Order> getOrderByUserId(Long userId) {
        return orderService.getUserAllOrder(userId);
    }

    public void cancelOrder(Long orderId) {
        orderService.deleteOrder(orderId);

    }
}
