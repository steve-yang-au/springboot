# API Document


<a name="overview"></a>
## Overview
Java restful style API document


### Version information
*Version* : 1.0


### License information
*Terms of service* : https://www.steve.com


### URI scheme
*Host* : localhost:8888  
*BasePath* : /


### Tags

* article-controller : Article Controller




<a name="paths"></a>
## Resources

<a name="article-controller_resource"></a>
### Article-controller
Article Controller


<a name="addarticleusingpost"></a>
#### addArticle
```
POST /restful/articles
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**article**  <br>*required*|article|[Article](#article)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[AjaxReponse](#ajaxreponse)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/restful/articles
```


###### Request body
```
json :
{
  "auther" : "string",
  "content" : "string",
  "createTime" : "string",
  "readers" : [ {
    "age" : 0,
    "name" : "string"
  } ],
  "title" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "message" : "string",
  "ok" : true
}
```


<a name="getarticleusingget"></a>
#### getArticle
```
GET /restful/articles/{id}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int64)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[AjaxReponse](#ajaxreponse)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/restful/articles/0
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "message" : "string",
  "ok" : true
}
```


<a name="updatearticleusingput"></a>
#### updateArticle
```
PUT /restful/articles/{id}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**article**  <br>*required*|article|[Article](#article)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[AjaxReponse](#ajaxreponse)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/restful/articles/{id}
```


###### Request body
```
json :
{
  "auther" : "string",
  "content" : "string",
  "createTime" : "string",
  "readers" : [ {
    "age" : 0,
    "name" : "string"
  } ],
  "title" : "string"
}
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "message" : "string",
  "ok" : true
}
```


<a name="deletearticleusingdelete"></a>
#### deleteArticle
```
DELETE /restful/articles/{id}
```


##### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int64)|


##### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[AjaxReponse](#ajaxreponse)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


##### Consumes

* `application/json`


##### Produces

* `*/*`


##### Example HTTP request

###### Request path
```
/restful/articles/0
```


##### Example HTTP response

###### Response 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "message" : "string",
  "ok" : true
}
```




<a name="definitions"></a>
## Definitions

<a name="ajaxreponse"></a>
### AjaxReponse

|Name|Description|Schema|
|---|---|---|
|**code**  <br>*optional*|**Example** : `0`|integer (int32)|
|**data**  <br>*optional*|**Example** : `"object"`|object|
|**message**  <br>*optional*|**Example** : `"string"`|string|
|**ok**  <br>*optional*|**Example** : `true`|boolean|


<a name="article"></a>
### Article

|Name|Description|Schema|
|---|---|---|
|**auther**  <br>*optional*|**Example** : `"string"`|string|
|**content**  <br>*optional*|**Example** : `"string"`|string|
|**createTime**  <br>*optional*|**Example** : `"string"`|string (date-time)|
|**readers**  <br>*optional*|**Example** : `[ "[reader](#reader)" ]`|< [Reader](#reader) > array|
|**title**  <br>*optional*|**Example** : `"string"`|string|


<a name="reader"></a>
### Reader

|Name|Description|Schema|
|---|---|---|
|**age**  <br>*optional*|**Example** : `0`|integer (int32)|
|**name**  <br>*optional*|**Example** : `"string"`|string|





