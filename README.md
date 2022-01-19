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
* Couldn't use Eureka Sevice Discovery. So we used raw url's to call the api. We should use application name as reference and @LoadBlannce Bean for webclients/restclients. Because the url of the api can be dynamic.
* We should check if the give user is valid or product numbers are valid before creating an order. As this was a practice project, I skipped it.
* Adding caching to the discovery server can greatly improve our performance
