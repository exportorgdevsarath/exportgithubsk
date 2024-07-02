package com.vb.csvtoexcel;

import java.util.Collections;

import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Severity;
import com.google.cloud.logging.Payload.StringPayload;

public class CloudLogger {
	
	private static final Logging logging = LoggingOptions.getDefaultInstance().getService();
	private static final String LOG_NAME = "csv-to-excel-log";

	public static void logInfo(String message) {
        LogEntry entry = LogEntry.newBuilder(StringPayload.of(message))
                .setSeverity(Severity.INFO)
                .setLogName(LOG_NAME)
                .build();
        logging.write(Collections.singleton(entry));
    }

	public static void logError(String message) {
        LogEntry entry = LogEntry.newBuilder(StringPayload.of(message))
                .setSeverity(Severity.ERROR)
                .setLogName(LOG_NAME)
                .build();
        logging.write(Collections.singleton(entry));
    }
}
