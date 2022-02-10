# food-truck-locator-service

<h3>Food Truck Locator</h3>
<br>
This backend REST service is used to find the nearest food trucks in San Francisco based on the latitude and longitude provided as input. <br><br>
<h3>How to Build/Install/Run: </h3>
This is a Java / Maven / Spring Boot application packaged as a war with an embedded servlet container (Tomcat). You run it using the java -jar command.
<ul>
  <li>	Clone this repository </li>
  <li>	Make sure you are using JDK 1.8 or higher and Maven 3.x </li>
  </li>	You can build the project and run the tests by running mvn clean install</li>
  <li>	Once successfully built, you can run the service by one of these two methods:
        java -jar .\food-truck-locator-1.0.0.jar </li>
  <li>	Check the stdout to make sure no exceptions are thrown </li>
  </ul>
Rest Endpoint should be accessible at: http://<host_name>:8081/foodtrucks/closest <br>
QueryParameters expected:
<ul>
  <li>latitude (double)</li>
  <li>	longitude (double) </li>
  <li>	foodTruckCount (int) </li> <br>
Example: To get the list of 5 closest food trucks to the Geo location [37.70657602452924, -122.46086099504667] :<br>

http://<host_name>:8081/foodtrucks/closest?latitude=37.70657602452924&longitude=-122.46086099504667&foodTruckCount=5



