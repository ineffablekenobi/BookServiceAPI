# BookServiceAPI

Microservice design.

## Clients :

* Book Service
* User Service
* OrderSevice


## Servers :

* BookShopService


## Project Architecture 

![Project Architecture][Arch-screenshot]


[Arch-screenshot]: Arch.png

## Possible Improvements
* We should check if the give user is valid or product numbers are valid before creating an order. As this was a practice project, I skipped it.
* Adding caching to the discovery server can greatly improve our performance
* Use cloud gateway instead of manually calling the services
