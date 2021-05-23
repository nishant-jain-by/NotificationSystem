# NotificationSystem
Generic Notification System

Spring boot application to handle Notifications with support of
1. eventType (type of event)
2. from (sender identity)
3. to (destination)
4. message (wrapped under message->body)
5. prevState (TBD for state checks)
6. newState (TBD for state checks)
7. Source (source system)

**Features**

A. It can send notification to any type of destination. Currently mocked for email service but it can be extended for any type things. Refer- Enum class for supported source system.

B. It can handle multiple event types in the system and support of event type per source system. E.g. - If we have event types like ORDER_PLACED, ORDER_CANCEL, ORDER_RECEIVED, ORDER_DELIVERED and source systems like CUSTOMER_PHONE, ORDER_PLACE_MICROSERVICE etc. So we can allow event like ORDER_CANCEL from source system CUSTOMER_PHONE and NOT allow it for source ORDER_PLACE_MICROSERVICE.It give us the control of events from the sources.

C. Sync and Async support of such notifications via RESTful api as well as Kafka consumer.

D. TBD- maintaining the state of such message in database


To run the application, build it using 
mvn clean install

then run the application in Intellij application-> run the Application class as springboot application.


