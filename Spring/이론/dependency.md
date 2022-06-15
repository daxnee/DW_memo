### Gradle

```java
//build.gradle 의 dependencies에 추가

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2'
	compileOnly 'org.projectlombok:lombok'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'mysql:mysql-connector-java'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	// JSP 다운로드
	implementation "org.apache.tomcat.embed:tomcat-embed-jasper"
	implementation 'javax.servlet:jstl'
	// spring security
	implementation("org.springframework.boot:spring-boot-starter-security")
	//Session
	implementation 'org.springframework.session:spring-session-core'


}
```


### Maven 
```java
//pom.xml의 dependency에 추가

<dependency>
    <groupId>org.springframework.boot</groupId>
	   <artifactId>spring-boot-devtools</artifactId>
	  <scope>runtime</scope>
	  <optional>true</optional>
</dependency>

//devtools
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
</dependency>
```