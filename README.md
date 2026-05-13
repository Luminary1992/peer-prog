## Spring Boot App

### Spring Boot Flow Diagram

> MyFirstController → MyFirstService → MyFirstRepository(Not Used Yet) → Database(Not Used Yet)

- The real data has been stored inside the MyConstant class.

### GET Endpoint

- http://localhost:8081/app/v1/get-name

~~~ curl
curl --location 'localhost:8081/app/v1/get-name'
~~~
- Response:
~~~ json
{
  "data": {
    "808b34b4-23e3-4a09-a1e7-207c194346ad": "Sima",
    "82548a06-eb93-4671-95a4-e1fa2309667e": "Pratik"
  },
  "message": "Names retrieved successfully"
}
~~~

![img_1.png](images/img_1.png)

### POST Endpoint
- http://localhost:8081/app/v1/add-name
- Body:

~~~ json
{
    "name": "Sima"
}
~~~

~~~ curl
curl --location 'http://localhost:8081/app/v1/add-name' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Sima"
}'
~~~

![img.png](images/img.png)
