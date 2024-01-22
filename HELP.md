# Read Me First

## Getting Started

Build & Run Maven Project

REST API Endpoint is http://127.0.0.1:8080

The application creates two accounts on start, see the application log for details. 

## API 

(see Postman collection: Accounting API.postman_collection.json)

### Create Account

POST http://127.0.0.1:8080/create-account

Example Request Data

{"balance":7484.0}

### Get Balance

GET http://127.0.0.1:8080/get-balance/{ID}

### Transfer

POST http://127.0.0.1:8080/transfer

Example Request Data

{ "input" : 2, "output" : 1, "amount": 500.0 }

### List Transactions

GET http://127.0.0.1:8080/list-transactions/{ID}



