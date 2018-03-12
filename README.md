# springcloud

## Part 7
API Gateway is provided.
Intelligent routing microservice based on Zuul (Netflix OSS) is added to project.
Launch config server at first, discovery server and some instances of highloaded_microservice and then execute:

``mvn -pl routing clean spring-boot:run``

You can easily assume that reverse-proxy works fine just by simple check (all routes could be checked by `GET host:9999/routes`):

`GET host:9999/highloaded-microservice/about` automapped service route
 
`GET host:9999/service/about` described in properties file route to service

All request via routes to services are automatically load-balanced by Ribbon (you can see different ports in responses from request to request).
Circuit breaker is also works and in case of any circuit openings requests to this instance will be delegated to other instances until it became closed again
``http://127.0.0.1:9999/hystrix/monitor?stream=127.0.0.1%3A9999%2Fhystrix.stream`` 


## Part 6
Hystrix dashboard is provided and now it is possible to monitor state of circuits on microservice with Hystrix Dashboard inside of the browser.
Just repeat steps described in Part 4 and gi to the next link:

``http://host:5003/hystrix``

If you have any problems with displaying streams at your browser just go directly to `http://127.0.0.1:5003/hystrix/monitor?stream=127.0.0.1%3A5003%2Fhystrix.stream&delay=5000&title=Spring%20Cloud%20Hystrix%20Dashboard`

## Part 5
Hystrix circuit breaker implementation is provided. Just launch config server, discovery server and finally:

``mvn -pl circuit_breaker clean spring-boot:run``

There are two ways to observer this pattern behavior:
* do `GET host/task/hard` several times and you will see that fallback method would be executed in order to prevent cascading failures and make service more fault-tolerant
* do `GET host/task/long` and you will see observe fallback method again because request handling became too long
* play with `timeoutInMilliseconds` hystrix parameter and see what happens to `GET host/task/long`  

## Part 4.2
Feign based load balancing microservice is provided. Launch config server, discovery server, some instances of highloaded_microservice module and finally:

``mvn -pl loadbalancing_feign clean spring-boot:run``

Ensure that load balancing works by `GET host/delegate` and you will see answers from different highloaded_microservice module instances


## Part 4.1
Ribbon based load balancing microservice is provided. Launch config server, discovery server, some instances of highloaded_microservice module and finally:

``mvn -pl loadbalancing_ribbon clean spring-boot:run``

Ensure that load balancing works by `GET host/delegate` and you will see answers from different highloaded_microservice module instances

## Part 3
Microservice is provided.
Start configuration server and discovery server and only after that launch microservice by

``mvn -pl highloaded_microservice clean spring-boot:run``

You can scale it just by running some more instances at different ports and you can see that all of them would be connected to eureka.
Try to shutdown one of them by `GET host/kill` (to imitate highloading case) and see that eureka evicts in some time


## Part 2

Configuration server management is implemented (with local config files, could be switched to remote configs repository). 
To run config server enter in the root:

``mvn -pl config_server clean spring-boot:run``

Then just start discovery server and make sure that configurations would be fetched from configuration server.

``mvn -pl discovery_server clean spring-boot:run
``

To refresh configs change em in config server and `POST host/refresh` on client of config server

## Part 1

Discovery server is provided (Netflix OSS Eureka).
To run application enter in the root:

``mvn -pl discovery_server clean spring-boot:run
``

