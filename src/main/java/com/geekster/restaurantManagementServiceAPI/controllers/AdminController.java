package com.geekster.restaurantManagementServiceAPI.controllers;

import com.geekster.restaurantManagementServiceAPI.models.Admin;
import com.geekster.restaurantManagementServiceAPI.models.Food;
import com.geekster.restaurantManagementServiceAPI.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
     @PostMapping()
     public void addAdmin(@RequestBody Admin admin){
         adminService.addAdmin(admin);
     }

     @PostMapping("food/adminEmail/{adminEmail}")
    public ResponseEntity<Void>AddFood(@PathVariable String adminEmail , @RequestBody Food food){

         HttpStatus status;
         try{
             adminService.addFood(adminEmail,food);
             status = HttpStatus.OK;
         }
         catch (Exception ex){
             status = HttpStatus.FORBIDDEN;
             ex.printStackTrace();
         }
         return new ResponseEntity<Void>(status);

     }

     @DeleteMapping("foodId/{foodId}/adminEmail/{adminEmail}")
     public ResponseEntity<String>removeFoodById(@PathVariable String adminEmail , @PathVariable Long foodId){
         HttpStatus status;
         String message;
         try{
             adminService.removeFoodById(adminEmail,foodId);
             status = HttpStatus.OK;
             message = "Delete foodItem successfully!!!";
         }
         catch (Exception ex){
             status = HttpStatus.FORBIDDEN;
             message = "foodItem does not Deleted!!!";
             ex.printStackTrace();
         }
         return new ResponseEntity<String>(message,status);

     }


}
