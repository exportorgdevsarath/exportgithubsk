package com.vb.csvtoexcel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import org.springframework.stereotype.Service;

@Service
public class CloudStorageService {

    private final Storage storage;

    public CloudStorageService() {
        this.storage = StorageOptions.getDefaultInstance().getService();
    }

    public InputStream readCsvFile(String bucketName, String fileName) {
        System.out.println("reading file");
    	Blob blob = storage.get(bucketName, fileName);
    	System.out.println("end reading file");
//        return new String(blob.getContent());
    	
    	 return Channels.newInputStream(blob.reader());
    }

    public void writeExcelFile(String bucketName, String fileName, byte[] content, String excelContentType) {
        BlobId blobId = BlobId.of(bucketName, fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(excelContentType).build();
        storage.create(blobInfo, content);
    }
    
    public InputStream getCsvInputStream(String bucketName, String csvFileName) throws IOException {
    	System.out.println("start reading file");
    	Blob csvBlob =  storage.get(bucketName, csvFileName);
        System.out.println("end reading file");
        if (csvBlob == null) {
            throw new IOException("CSV file not found in the specified bucket.");
        }
        return Channels.newInputStream(csvBlob.reader());
    }

    public OutputStream getExcelOutputStream(String bucketName, String excelFileName) throws IOException {
        BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, excelFileName)
                .setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
                .build();
        return Channels.newOutputStream(storage.writer(blobInfo));
    }
}
