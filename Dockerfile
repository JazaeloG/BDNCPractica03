FROM tomcat:9.0.87-jdk11

COPY target/BDNCPractica03-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/miapp.war

EXPOSE 8080

CMD ["catalina.sh", "run"]