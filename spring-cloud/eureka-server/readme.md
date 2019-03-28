运行server
cd spring-cloud/eureka-server/target
java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2


cd spring-cloud/ribbon-consumer/target 
java -jar ribbon-consumer-0.0.1-SNAPSHOT.jar 

运行client
cd spring-cloud/eureka-client/target
java -jar eureka-client-0.0.1-SNAPSHOT.jar --server.port=8181
java -jar eureka-client-0.0.1-SNAPSHOT.jar --server.port=8282
