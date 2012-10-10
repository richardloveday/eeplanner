package com.eeplanner.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;

public class AmazonS3Service {

    private AmazonS3Client s3Client;
    private String bucketName;

	public AmazonS3Service() {
	}

	public AmazonS3Service(AmazonS3Client s3Client, String bucketName) {
        this.s3Client = s3Client;
        this.bucketName = bucketName;
    }

    public void persistFile(InputStream inputStream, long length) throws IOException {

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(length);

        s3Client.putObject(new PutObjectRequest(
                bucketName,
                String.valueOf(new DateTime()) + ".sql.bak",
                inputStream,
                metadata)
        );

    }

}
