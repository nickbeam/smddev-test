# Spring boot REST with MongoDB - Test Project. [![Codacy Badge](https://api.codacy.com/project/badge/Grade/13b8a8595aed46bdad946620267d65d4)](https://www.codacy.com/manual/nickbeam/smddev-test?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=nickbeam/smddev-test&amp;utm_campaign=Badge_Grade) [![Build Status](https://travis-ci.org/nickbeam/smddev-test.png?branch=master)](https://travis-ci.org/nickbeam/smddev-test)

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