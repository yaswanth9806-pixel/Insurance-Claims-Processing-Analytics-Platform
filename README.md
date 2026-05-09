Insurance Claims Processing API
Overview
This project is a sample Spring Boot application for an insurance claims processing module. It supports claim submission, basic validation, duplicate claim checks, database persistence, and reporting-ready claim status tracking.
This code aligns with the weekly work completed for the Insurance Claims Processing & Analytics Platform.
Features
Claim submission REST API
Spring Boot backend service layer
MySQL database integration
Duplicate claim validation
Missing data validation
SQL stored procedure sample
AWS S3 service placeholder for claim file upload
Ready for GitHub upload
Tech Stack
Java 17
Spring Boot
Spring Data JPA
MySQL
Maven
AWS S3 SDK
API Endpoint
Submit Claim
POST `/api/claims`
Sample Request:
```json
{
  "memberId": "M12345",
  "diagnosisCode": "E119",
  "amount": 425.75
}
```
Sample Response:
```json
{
  "id": 1,
  "memberId": "M12345",
  "diagnosisCode": "E119",
  "amount": 425.75,
  "status": "APPROVED",
  "rejectionReason": null
}
```
How to Run Locally
Create MySQL database:
```sql
CREATE DATABASE insurance_db;
```
Update database credentials in:
```text
src/main/resources/application.properties
```
Run the application:
```bash
mvn spring-boot:run
```
Test using Postman:
```text
POST http://localhost:8080/api/claims
```
Weekly Work Covered
Developed claim validation API
Added missing field and duplicate claim validation logic
Integrated Spring Boot backend with MySQL
Added SQL stored procedure sample
Added AWS S3 service class for cloud file handling
