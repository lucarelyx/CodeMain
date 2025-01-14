# Price Service API

This is a Spring Boot application that provides an API for retrieving product prices based on the given brand and product ID.

## Requirements

- Java 17 or higher
- Maven

## Installation

Clone the repository:
```bash
git clone https://github.com/lucarelyx/CodeMain.git
cd codeMain
```

## Running the application

To run the application, execute the following command:

```bash
mvn spring-boot:run
```

## Testing the API
You can test the API using Postman or directly through Swagger UI.

### Swagger UI
Access it at: `http://localhost:8080/swagger-ui.html`

### Example Request
Using Postman, make a GET request to:
`http://localhost:8080/api/prices?brandId=1&productId=35455&applicationDate=2020-06-14T10:00:00`

Expected response:
```json
{
    "productId": 35455,
    "brandId": 1,
    "priceList": 1,
    "startDate": "2020-06-14T00:00:00",
    "endDate": "2020-12-31T23:59:59",
    "price": 35.50
}
```

