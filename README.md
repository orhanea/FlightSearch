# FlightSearchAPI
This project provides a Backend API with using RESTful API for searching flights.
# Technologies and Tools
- Java - Spring Boot
- MySQL
- JWT 
- Swagger
# The data model for the database
- **Flights**
  - ID
  - Departure Airport
  - Arrival Airport
  - Departure Date/Time
  - Return Date/Time
  - Price
- **Airports** 
  - ID
  - City
- **NOTE**: For the one-to-many relationship, I considered *Departure Airport*, *Arrival Airport* in the **Flights** table to the *city* columns in **Airports** table, but I removed it because I could not reflect this in the code.

# Knokwn issues 
I had a lot of problems with versions. That's why the swagger documentation doesn't work. At the same time, some get, post methods that worked in the beginning stopped working. I couldn't figure this out. So the project is not completed but I would be very happy to explain this and other issues in the technical interview if I selected. I added all the classes I wanted to create and designed.
