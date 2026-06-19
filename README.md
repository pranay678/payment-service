# payment-service

A Spring Boot payment-processing service.

## Intentional Failure

`pom.xml` pins `jackson-databind` to **2.13.0** and `hibernate-validator` to
**6.2.5.Final**.  Spring Boot 3.3.x requires Jackson ≥ 2.15 and Hibernate
Validator ≥ 8.  This version conflict causes a **dependency-resolution /
compilation failure** so the diagnosis copilot can identify the root cause and
recommend upgrading those overrides.

## Local build

```bash
mvn clean verify
```

Expected failure output:
```
[ERROR] COMPILATION ERROR
...
incompatible class versions / NoSuchMethodError
```
