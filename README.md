# zuul-gateway
this repo contains two zuul gateway one configured for load balancing and one without ribbon.

---------------------------------------------------------------------------------------------

# WIKI !

  - Start the eureka-discovery first which runs of port 8761.
    we can see all clients registered with eureka on its dashboard.
  - Then start info-management which is a simple microservice.
  - start zuul-gateway-with-ribbon and zuul-gateway-with-no-ribbon.

zuul-gateway-with-ribbon endpoint:
```sh
http://localhost:8000/api/info/
```

zuul-gateway-no-ribbon endpoint:
```sh
http://localhost:9000/api/info/
```


> to see ribbon in action, start one more instance of info-management service.
> invoke http://localhost:8000/api/info/ (from gateway) 
> check the console log. it will print from what instance the request is received 
> with its server port.
> http://localhost:{port}/api/info/{id} will fetch record by id
> http://localhost:{port}/api/info/  returns all records.
