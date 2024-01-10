# LAMBKIN_Backend_Server 

+-------------------------+        +---------------------------+        +-----------------------+
|          User           |        |       SwipeAction         |        |        Profile        |
+-------------------------+        +---------------------------+        +-----------------------+
| userId (PK)             |        | swipeId (PK)              |        | profileId (PK)        |
| username                |        | userId (FK - User)        |        | userId (FK - User)    |
| email                   |        | targetUserId (FK - User)  |        | name                  |
| password                |        | actionType                |        | age                   |
| dateOfBirth             |        | timestamp                 |        | gender                |
| gender                  |        +---------------------------+        | bio                   |
| bio                     |                                             | interests             | 
|                         |                                             +-----------------------+
| registrationTimestamp   |
|                         |
+-------------------------+




## __________  API Endpoints ______________ 

## Users related
root: "/users"


## GET : " "        
----> fetch all the users from the database
## GET : "/{id}"      
----> fetch the respected user with userId from the data base
## POST : " "     
---> Sign up request to the server
## POST : "/login"    
----> Sign in request to the server
## PATCH : " "      
----> update user details request