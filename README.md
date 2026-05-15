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

### Build and Deploy :
- Build the project using Maven.

~~~ bash
mvn clean install
~~~
- Once Build Success.
- Yuu could see the deployment jar available in the target folder `/app-base-path/target/peer-prog-0.0.1-dev.jar`.
- Run the jar file, this is the deployment file and also called the `production ready` file.
- This is a Spring Boot application, so you can run the jar file using the below command.

~~~ bash
java -jar peer-prog-0.0.1-dev.jar
~~~
- It runs with the default port provided by the application (inside the `application.yaml`).
- incase you need to change the port, then **EITHER** you can change it inside the `application.yaml` file **OR** 
   provide the port number as a command line argument while running the jar file.
- For example, to run the application on port 8082, you can use the following command:

~~~ bash
java -jar peer-prog-0.0.1-dev.jar server.port=8082
~~~
- This is going to override the default port provided in the `application.yaml` file and run the application on port 8082.

### Get metrics with prometheous.
- All the Metrics available in the application can be accessed using `actuator` endpoints.
- Actuator is a Spring Boot module that provides production-ready features to help you monitor and manage your application. 
- It includes various endpoints that expose information about the application's health, metrics, and other useful data.

~~~ xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
~~~
- Once you added this dependency and enabled it through the `application.yml` file 

~~~ yaml
management:
  endpoints:
    web:
      exposure:
        include: "*"
~~~
- Now all the default actuator endpoints will be available on the base path `http://localhost:8081/actuator`.

- For Prometheus metrics, we need to add the `micrometer` dependency.
- Micrometer is a metrics collection library that provides a simple facade over the instrumentation clients for various monitoring systems, including Prometheus.
- To add the Micrometer Prometheus registry to your Spring Boot application, you can include the following dependency in your `pom.xml` file:
~~~ xml
<dependency>
	<groupId>io.micrometer</groupId>
	<artifactId>micrometer-registry-prometheus</artifactId>
</dependency>
~~~

- Once the application is running, you can access the metrics endpoint to see the application metrics in Prometheus format.
- You can access the metrics endpoint at `http://localhost:8081/actuator/prometheus` to see the application metrics in Prometheus format.
- The metrics endpoint will provide various metrics about the application, such as memory usage, CPU usage and other performance-related metrics that can be used for monitoring and troubleshooting the application.
- You can also integrate this metrics endpoint with a monitoring tool like Prometheus to visualize and analyze the metrics over time.
- To integrate with Prometheus, you can add the following configuration to your `application.yaml` file:
~~~ yaml
management:
  endpoints:
    web:
      exposure:
        include: prometheus
  endpoint:
    prometheus:
      enabled: true
~~~
- This configuration will enable the Prometheus endpoint and make it available at `http://localhost:8081/actuator/prometheus`.
- You can then configure Prometheus to scrape this endpoint at regular intervals to collect the metrics data for monitoring and analysis.
- For example, you can add the following configuration to your Prometheus configuration file (`prometheus.yml`): - **WILL TALK LATER** 

~~~ yaml
scrape_configs:
  - job_name: 'spring-boot-app'
    static_configs:
      - targets: ['localhost:8081']
~~~
- This configuration tells Prometheus to scrape the metrics from the Spring Boot application running on `localhost:8081` at regular intervals, allowing you to monitor the application's performance and health over time.
- You can then use Prometheus's query language (PromQL) to create custom queries and visualizations based on the collected metrics data, helping you gain insights into the application's behavior and performance.
- Overall, integrating Prometheus with your Spring Boot application using Micrometer allows you to effectively monitor and analyze the application's performance and health, enabling you to proactively identify and address any issues that may arise.
- In summary, to get metrics with Prometheus in a Spring Boot application, you need to add the `spring-boot-starter-actuator` and `micrometer-registry-prometheus` dependencies, enable the actuator endpoints, and configure Prometheus to scrape the metrics endpoint. This setup allows you to monitor and analyze your application's performance effectively.
- You can also create custom metrics using Micrometer by defining your own `MeterRegistry` and registering custom metrics with it. This allows you to track specific application metrics that are relevant to your use case, providing deeper insights into the application's behavior and performance.

