#VehiclesCRUD

////IMPORTANT: This is a prototype version of the Vehicles Crud, the filtering will be added in the evening 24.05.2018 GMT+1
and the code will be cleaned up. This is because due to the low amount of time related to work (I am at a business trip right now
and have limited time to complete this task).////

HOW TO RUN:

Step #1: Open cmd, and from the project folder run the maven project using the command mvn spring-boot:run
Step #2: Open the database which was formed automatically using hibernate, and verify whether the entries from the .sql file have 
automatically appeared in the table. To open it, in your browser type localhost:8080/h2 and login using the standard (already
typed in) credentials.
Step #3: Open Postman API (recommended) or your browser window in order to send the GET, PULL, PUT and DELETE REST requests.
Step #4: Send GET Requests:
        - to get all vehicles send GET request using postman to localhost:8080/vehicles
        - to get all cars send GET request using postman to localhost:8080/cars
        - to get all motorcycles send GET request using postman to localhost:8080/motorcycles
        
        If you want to get a car/motorcycle or vehicle by ID. Then use the same as above, just add the id after the
        localhost:8080/vehicles/{specified-id} for example: "localhost:8080/vehicles/2" or "localhost:8080/car/1. 
Step #5: Send DELETE requests:
        - use the same as above i.e. localhost:8080/vehicles/{specified-id} where vehicles can be either "vehicles", "cars" or 
        "motorcycles".
        With one exception, it needs to be specified during the send request that it is a DELETE request.

Step #6: Send POST requests:
        - Specify in the body of the request in the given JSON format under, what object needs to be added to the database.
        
        {
        "id": "...." // insert an Integer number in the dots
        "make": "...." // insert String in the dots
        "model": "...." // insert String in the dots
        "color": "...." // insert String in the dots
        "mileage": "...." // insert double in the dots
        "motor" : "...." // insert double in the dots
        }
        
        Where the .... inside the " " have to be replaced with the data of the type that the comment next to them specifies.
        
Step #7: Edit the assembler, the model or the whole vehicle itself.

One method for vehicles is enough to satisy the needs since all vehicles of both types, motorcycle and car can be edited. 

In order to edit the entries for model send a PUT request to the following directory: "localhost:8080/vehicles/model/{id}" in the case
where model needs to be changed, please specify the new model name in the Body section of the request. (Just specify the new model,
do not use the JSON format, i.e. insert Passat into blank body and the model will change to Passat). 

In order to edit the entries for the make send a PUT request to the following directory: "localhost:8080/vehicles/assembler/{id}" 
and use the same instructions as above for the model edit. 

In order to edit the whole vehicle, follow the same instructions as in Step#6 to edit the entry, just change the path to
"localhost:8080/vehicles/{id}" and in the place of {id} insert the id number of the vehicle you want to edit. // IMPORTANT:
This still needs to be completed, a method which changes only the id has been implemented, but its just a simple matter of
adding more setters in the method.
