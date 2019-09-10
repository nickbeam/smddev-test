# Spring boot REST with MongoDB - Test Project.

## Installation:
```bash
- docker pull mongo
- docker pull dvininnick/spring-boot-mongo
- docker run -p 27017:27017 -d mongo
- docker run -p 8181:8181 -d dvininnick/spring-boot-mongo
```


## REST API Documentation:

### Create new product:

- POST http://localhost:8181/api/product

```json
{
	"id": "124",
	"name": "Apple iPhone 7 Plus",
	"description": "Brand new",
	"parameters": 
	{
		"color": "Silver",
		"price": "16990",
		"currency": "RUB"
	}
}
```

### Get product by ID:

- GET	http://localhost:8181/api/product/124


### Get all product names:

- GET http://localhost:8181/api/product/


### Get filtered by filed and value product names:

- GET http://localhost:8181/api/product/filter?field=color&value=silver

- GET http://localhost:8181/api/product/filter?field=currency&value=rub


### Get filtered by name product names:

- GET http://localhost:8181/api/product/filter?field=name&value=iphone


### Update product by ID:

- PUT http://localhost:8181/api/product/124

```json
{
	"name": "Apple iPhone XR",
	"description": "Refurbished",
	"parameters": 
	{
		"color": "Space gray",
		"price": "57990",
		"currency": "RUB"
	}
}
```


### Delete product by ID:

- DELETE http://localhost:8181/api/product/124
