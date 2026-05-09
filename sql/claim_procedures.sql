CREATE DATABASE IF NOT EXISTS insurance_db;

USE insurance_db;

CREATE TABLE IF NOT EXISTS claims (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    member_id VARCHAR(50),
    diagnosis_code VARCHAR(50),
    amount DECIMAL(10,2),
    status VARCHAR(50),
    rejection_reason VARCHAR(255),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DELIMITER //

CREATE PROCEDURE validate_claim (
    IN p_member_id VARCHAR(50),
    IN p_diagnosis_code VARCHAR(50),
    IN p_amount DECIMAL(10,2)
)
BEGIN
    IF p_member_id IS NULL OR p_member_id = '' THEN
        SELECT 'REJECTED - Member ID is missing' AS validation_status;
    ELSEIF p_diagnosis_code IS NULL OR p_diagnosis_code = '' THEN
        SELECT 'REJECTED - Diagnosis code is missing' AS validation_status;
    ELSEIF p_amount IS NULL OR p_amount <= 0 THEN
        SELECT 'REJECTED - Claim amount must be greater than zero' AS validation_status;
    ELSE
        SELECT 'VALID' AS validation_status;
    END IF;
END //

DELIMITER ;
