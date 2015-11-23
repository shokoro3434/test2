package com.eitax.cloud.aws.kinesis;

import java.nio.ByteBuffer;
import java.util.Calendar;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.kinesis.AmazonKinesis;
import com.amazonaws.services.kinesis.AmazonKinesisClient;
import com.amazonaws.services.kinesis.model.PutRecordRequest;
import com.amazonaws.services.kinesis.model.PutRecordResult;

public class Client{
	public static void main (String [] args) throws Exception{
        // アプリケーション名
        final String streamName = "test";

        // kinesis クライアントを初期化
        // ClasspathPropertiesFileCredentialsProvider()
        AWSCredentialsProvider credentialsProvider = null;
        try {
            credentialsProvider = new InstanceProfileCredentialsProvider();
            credentialsProvider.getCredentials();
        } catch (AmazonClientException e) {
            credentialsProvider = new ClasspathPropertiesFileCredentialsProvider();
            credentialsProvider.getCredentials();
        }
        final AmazonKinesis kinesis = new AmazonKinesisClient(
                credentialsProvider);

        // ランダムな文字列を生成してPutRecordRequestオブジェクトにput
        final String partitionKey = "sample-key";
        final String data = "shutdown";

        final PutRecordRequest request = new PutRecordRequest();
        request.setStreamName(streamName);
        request.setData(ByteBuffer.wrap(data.getBytes("UTF-8")));
        request.setPartitionKey(partitionKey);
        final PutRecordResult result = kinesis.putRecord(request);
        System.out.println(result);

//            LOG.info("key:{} ,record:{}", key, data, putRecord);
//            LOG.info("--------");

	}
}