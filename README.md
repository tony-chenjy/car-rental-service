# car-rental-service
system design and implement project for prudential interview

## requirement
You are working for a new car rental company, and your task is to design and implement a simple rental car booking API service for customers (using the mobile app, or web client) to reserve a car for a period of time.

Your job is to provide the following:
1) Solution design document with your assumptions.
2) API spec
3) Source code in the GIT repository. You could use github or other similar service
4) Test cases
5) Deployed and run in the cloud environment of your choice. Prefer Azure, you could
get a FREE Azure account here: https://azure.microsoft.com/en-us/free/
6) Optional, extra points if you could provide the following:
a. A working customer facing web client online that could be used to quickly test the service
7) Note:
a. You could use the programming language that you are most familiar. Prefer
Java as it is the company standard.
b. Keep it simple.

The company is new so it only has the following car.
```
Car Model  In stock
Toyota Camry    2 
BMW 650 2
```

## api design
In order to keep it simple, I design only service api CarBookingServiceApi with five method implementing the basic rental car booking functions.
```
CarBookingServiceApi
1. query the car available between the time client wants to rent
2. rent a car in specific model
3. query the order in specific status between specific time
4. cancel a specific order
5. update the order when client return the car
```

## database design
I design two tables.

Table car_info is used to record the information of each car.
```
CREATE TABLE `car_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `model` varchar(255) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
```

Table order_info is used to record each order.
```
CREATE TABLE `order_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `car_id` bigint(20) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
```

## implementation
I use SpringBoot to build a micro service application, use mysql to store data, use swagger to describe and test the api.

You can browse the api document with the following url after running the application.

`http://localhost:8080/swagger-ui.html#/car-booking-service-api`
