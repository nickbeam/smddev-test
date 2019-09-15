# Spring boot REST with MongoDB - Test Project.

## Installation:
```bash
git clone https://github.com/nickbeam/smddev-test.git
cd smddev-test
docker-compose up -d
```


## REST API Documentation:

### Create new product:

```
curl -d '{ "id": "124", "name": "Apple iPhone 7 Plus", "description": "Brand new", "parameters": { "color": "Silver", "price":"16990", "currency": "RUB" } }' -H 'Content-Type: application/json' http://localhost:8181/api/product
```

### Get products filtered by name:

```
curl 'http://localhost:8181/api/product/filter?field=name&value=iphone'
```

### Get filtered by filed and value product names:

```
curl 'http://localhost:8181/api/product/filter?field=color&value=silver'

curl 'http://localhost:8181/api/product/filter?field=currency&value=rub'
```

### Get product by ID:

```
curl 'http://localhost:8181/api/product/124'
```