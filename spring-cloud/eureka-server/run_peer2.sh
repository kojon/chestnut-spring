#!/bin/bash
echo "" > spring-peer2.log
java -jar target/eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2 & >spring-peer2.log