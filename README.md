# turvo
Shipment tracking application repo

# Database [mysql]
shipmenttracking

#Server configuration
port 8099
context /shipmenttracking

# Rest Apis

# Customer

http://localhost:8099/shipmenttracking/customer/create [POST]

Content-Type: application/json

Request Payload: 

{"id":"001",
 "name":"Sandy",
 "chanelPreferenceList":["Web"],
 "subscribeList":["CREATED","PACKAGED"],
 "email":"mndsandeep@gmail.com",
 "contactNumber":9963738597}


http://localhost:8099/shipmenttracking/customer/update [PUT]

Request Payload:

{"id":"001",
 "chanelPreferenceList":["Web","Email"]
 }

# Shipment

http://localhost:8099/shipmenttracking/shipment/create  [POST]

Request Payload:

 {"shipmentId":"002",
 "carrierName":"USPS",
 "created":"2017-08-23",
 "status":"CREATED",
 "customer":
 {"id":"001"}
  }

http://localhost:8099/shipmenttracking/shipment/update [PUT]

Request Payload:

{"shipmentId":"001",
 
 "status":"SHIPPED",
 "customer":
 {"id":"001"}
  }
