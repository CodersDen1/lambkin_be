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
| location                |                                             | profileImageUrl       |
| profileImageUrl         |                                             +-----------------------+
| registrationTimestamp   |
|                         |
+-------------------------+
