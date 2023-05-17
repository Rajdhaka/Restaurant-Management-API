# Restaurant Management Service API Application


## Built With
* `Java 17`
* `Maven 4.0.0`
* `MySql Ver 8.0.32`
* `Spring Boot 3.0.5`
* `IntelliJ IDEA 2023.1 (Community Edition)`

## Data Flow

### 1. Model:
* It consists of Admin ,User, Viewer ,Food ,Order and AuthToken entity classes along with their data members and member functions
* Used *@Table* and *@Entity* annotations inside the entity class.
* Used Lombok to reduce boilerplate code for pojo class.By using Lombok annotations like *@Data,* *@NoArgsConstructor*, *@AllArgsConstructor* getters and setters for those object generate automatically.
* Used @ManyToOne annotation to perform mapping between User and Order ,Order and Food classes.

### 2. Controller:
* It consists of  AdminController, UserController, ViewerController, FoodController and OrderController classes in which used the annotations like *@RestController* to annotate the class as Controller.
* Used annotation *@GetMapping* , *@PostMapping* , *@PutMapping* , *@DeleteMapping* to map the HTTP web requests to the specific handler methods.

<br>

### API Reference:
<br>

>Admin's API References


* Add Admin:
```*.sh-session
 http://localhost:8080/admin
```
* Add Food:
```*.sh-session
 http://localhost:8080/admin/food/adminEmail/{adminEmail}
```

* Delete Food:
```*.sh-session
  http://localhost:8080/admin/foodId/{foodId}/adminEmail/{adminEmail}
```

<br>

>User API References

* Signup User:
```*.sh-session
  http://localhost:8080/user/signup
```

* Signin User:
```*.sh-session
  http://localhost:8080/user/signin
```

* Signout User:
```*.sh-session
  http://localhost:8080/user/signout?email={email}&token={token}
```

* Get Menu:
```*.sh-session
  http://localhost:8080/user/menu
```
* Add Order:
```*.sh-session
  http://localhost:8080/user/order/userEmail/{userEmail}/token/{token}
```
* Get Order by UserId:
```*.sh-session
  http://localhost:8080/user/order/userId/{userId}?userEmail={userEmail}&token={token}
```
* Delete Order by OrderId:
```*.sh-session
 http://localhost:8080/user/order/{orderId}?userEmail={userEmail}&token={token}
```
 <br>

>Viewer API References


* Get Menu:
```*.sh-session
 http://localhost:8080/viewer/menu
```


### 3. Service:
* It consists of AdminService, UserService, FoodService, ViewerService, OrderService and  AuthTokenService classes in which provide some business logic of every handler methods.
* Used *@Service* annotation to indicate that a class belongs to the service layer.
* Used *@Transactional* annotation to separate transaction management code from the code for business logic on the update and delete methods.

### 4. Repository:
* It consists of *AdminDao* ,*UserDao, *ViewerDao*, *FoodDao*, *OrderDao* and *AuthTokenDao* interface classes that extends JpaRepository which is interface for generic inbuilt CRUD operations on a repository for a specific type. Usually represent the database access layer in an application.
* Used *@Repository* annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
* Used *@Modifying* annotation wrote named parameters query using @Query annotation to insert, update, or delete an entity.


## Project Summary
* In this project I performed CRUD operation like add,get,delete and update.<br/>
* The aim of this project to perform one to one, **one-to-many**, and *many-to-one* relationships mapping between entity classes.
* Used interface JpaRepository  for generic CRUD inbuilt operations like save,saveAll,updateById, etc.
* Used our own custom finder methods and wrote operations using custom queries.
* In this project I am creating API's for Restaurant Management.