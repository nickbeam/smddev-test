# Spring boot REST with MongoDB - Test Project. [![Build Status](https://travis-ci.org/nickbeam/smddev-test.png?branch=master)](https://travis-ci.org/nickbeam/smddev-test)

## Installation:
`git clone https://github.com/nickbeam/smddev-test.git`

`cd smddev-test`

`docker-compose up -d`

As a result, the service will be located at: `http://localhost:8181/api/product`

## REST API Documentation:

#### Create new product:

```
curl -d '{ "id": "124", "name": "Apple iPhone 7 Plus", "description": "Brand new", "parameters": { "color": "Silver", "price":"16990", "currency": "RUB" } }' -H 'Content-Type: application/json' http://localhost:8181/api/product
```

#### Get products filtered by name:

```
curl 'http://localhost:8181/api/product/filter?field=name&value=iphone'
```

#### Get product names filtered by filed and value:

```
curl 'http://localhost:8181/api/product/filter?field=color&value=silver'

curl 'http://localhost:8181/api/product/filter?field=currency&value=rub'
```

#### Get product by ID:

```
curl 'http://localhost:8181/api/product/124'
```