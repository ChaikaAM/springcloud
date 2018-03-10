# springcloud

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

