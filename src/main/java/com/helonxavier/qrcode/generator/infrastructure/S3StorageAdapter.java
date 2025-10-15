package com.helonxavier.qrcode.generator.infrastructure;

import com.helonxavier.qrcode.generator.ports.StoragePorts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Component
@RequiredArgsConstructor
public class S3StorageAdapter implements StoragePorts {

    @Value("${aws.region}")
    private String bucketName;

    @Value("${aws.bucketname}")
    private String region;

    private final S3Client s3Client = S3Client.builder().region(Region.of(region)).build();

    @Override
    public String upload(byte[] fileData, String fileName, String contentType) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .contentType(contentType)
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(fileData));
        return String.format("https://%s.s3.%s.amazonaws.com/%s", bucketName, region, fileName);
    }
}
