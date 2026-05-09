package com.insurance.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;

@Service
public class S3FileService {

    private final S3Client s3Client;

    @Value("${aws.s3.bucket-name:insurance-claim-files}")
    private String bucketName;

    public S3FileService(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    /*
     * Placeholder service for AWS S3 file upload.
     * In a real project, this method would upload inbound claim files,
     * supporting documents, or generated reports to the configured S3 bucket.
     */
    public String getBucketName() {
        return bucketName;
    }
}
