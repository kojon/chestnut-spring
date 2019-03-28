#!/bin/bash
echo "" > spring-peer1.log
java -jar target/eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1 & >spring-peer1.log