package com.eeplanner.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;


@Service
public class AmazonS3Service {

    private AmazonS3Client s3Client;
    private String bucketName;


    public AmazonS3Service(AmazonS3Client s3Client, String bucketName) {
        this.s3Client = s3Client;
        this.bucketName = bucketName;
    }

    public byte[] getFile(String id) throws IOException {

        S3Object s3Object = s3Client.getObject(bucketName, id);

        return IOUtils.toByteArray(s3Object.getObjectContent());

    }

    public void persistFile(File file) throws IOException {

		byte[] bytes = FileUtils.readFileToByteArray(file);

		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(bytes.length);

        s3Client.putObject(new PutObjectRequest(
                bucketName,
                String.valueOf(new DateTime()) + ".sql.bak",
                byteArrayInputStream,
                metadata)
        );

    }

}
