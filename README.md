# springcloud

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

