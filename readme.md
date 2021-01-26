# Twittr clone with secure admin and superadmin setup

## ER Diagram
Please find in ER Diagram.PNG

## APIs

User APIs-

POST - user/             -- to create user

GET - user/{user_id}     -- get the user data

POST - user/{user_id}/tweet         -- to tweet for user

DELETE - user/{user_id}/tweet/{tweet_id}  -- to deleter tweet for user

GET - user/{user_id}/tweets -- get all tweets for user

----

Admin Apis -

Admin can create request to CREATE_TWEET , READ_ALL_USER_TWEETS or DELETE_TWEET on behalf of user

POST - admin/{admin_id}/request -- create a request for access user tweet data

GET - admin/{admin_id}/requests  -- view all requests for admin

----

Super Admin APIs

Super admin will respond to the requests of admin.
 If Super admin approves the requests , Based on the request type tweets data would be modified through executable commands and requests would be updated with response data.
 
 POST - superadmin/admin -- create admin
 
 GET - superadmin/activities  -- get all te requests from admins
 
 PATCH - superadmin/activity/{activity_id} --  approve or reject admin requests
 
 ----
 
For more api details please refer [api documentation](https://documenter.getpostman.com/view/5597536/TW6uqpoJ#5b503f1c-a112-4979-b4c2-44d700416cd2)

