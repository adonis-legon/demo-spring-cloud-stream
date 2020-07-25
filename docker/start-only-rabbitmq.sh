docker run --detach --name rabbitmq --publish 5672:5672 --publish 15672:15672 rabbitmq:3.7-management
docker logs rabbitmq --tail 20 --follow