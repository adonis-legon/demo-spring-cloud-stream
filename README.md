# Demo Project for using Spring Cloud Stream

## Start producer and consumer services with RabbitMQ

`$ sh start-all.sh`

## Stop producer and consumer services with RabbitMQ

`$ sh stop-all.sh`

## Send sample message request

`$ curl -X POST localhost:8080/api/v1/messages --header "Content-Type:plain/text" --data test`
