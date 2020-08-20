# orderSystem
simple order system

# module
eureka：registration center  
common：common util and class    
parent：parent pom   
order：order service 
product: product service    
user: user service    

# run step
run EurekaApplication   
run UserApplication     
run OrderApplication    
run ProductApplication  

# url
eureka: http://localhost:8000/  
order swagger: http://localhost:8001/swagger-ui.html    
product swagger: http://localhost:8002/swagger-ui.html  
user swagger: http://localhost:8003/swagger-ui.html 

# invoke step
(1) add user:

`curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"email": "yun820047889@163.com", "nickName": "dy", "phone": "18390940098", "userId": 1, "userRealName": "daiyun" }' 'http://localhost:8003/user/addUser'`

(2) add user address:

`curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"address": "company", "addressId": 1, "city": "sz", "district": "nanshan", "phone": "18390940098", "postCode": "415300", "province": "guangdong", "userId": 1}' 'http://localhost:8003/userAddress/addUserAddress'`

(3) add product classify:

`curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"productClassifyName": "daily"}' 'http://localhost:8002/productClassify/addProductClassify'`

(4) add product:

`curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"productAddress": "sz", "productClassifyId": 1, "productCode": "123", "productDesc": "daily supplies", "productName": "toothpaste", "productPrice": 2, "productStock": 20, "userId": 1, "userName": "dy"}' 'http://localhost:8002/product/addProduct'`

(5) get a product:

 `curl -X GET --header 'Accept: application/json' 'http://localhost:8002/product/getProduct?productId=1'`

(6) buy product :
1、success:
`curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"buyNum": 2, "productId": 1, "userId": 30 }' 'http://localhost:8002/product/buyProduct'`
   
return:

`{
       "retCode": 200,
       "retMsg": "success",
       "data": true
}`
   
2、fail userId does not exist:

`curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"buyNum": 30, "productId": 1, "userId": 30 }' 'http://localhost:8002/product/buyProduct'
`
return:

`{
      "retCode": 3000,
      "retMsg": "user not exists",
      "data": null
}`   
   
3、fail buy num overt stock: 
   
`curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"buyNum": 21, "productId": 1, "userId": 1}' 'http://localhost:8002/product/buyProduct'`
     
return:

`{
      "retCode": 3000,
      "retMsg": "user not exists",
      "data": null
}`
   
