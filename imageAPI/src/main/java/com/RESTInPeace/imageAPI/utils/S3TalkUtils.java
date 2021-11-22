package com.RESTInPeace.imageAPI.utils;

import com.RESTInPeace.imageAPI.constants.S3Constants;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import lombok.NonNull;

import java.io.ByteArrayInputStream;

public class S3TalkUtils {
    /**
     * This method saves the picture to the s3 bucket. It uses multipart upload.
     *
     * @param file
     * @param fileName
     * @throws Exception
     */
    public static void saveImageToServer(@NonNull final byte[] file,
                                         @NonNull final String fileName) throws Exception {
        final AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(S3Constants.S3_CREDENTIALS))
                .withRegion(S3Constants.REGION)
                .build();

        final TransferManager transferManager = TransferManagerBuilder.standard()
                .withS3Client(s3client)
                .withMultipartUploadThreshold((long) (5 * 1024 * 1024))
                .build();

        transferManager.upload(
                S3Constants.BUCKET_NAME,
                fileName,
                new ByteArrayInputStream(file),
                new ObjectMetadata()
        ).waitForUploadResult();
    }
}
