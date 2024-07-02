package com.vb.csvtoexcel;

import java.io.Serializable;

public class FileConversionException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int errorCode;
    
    public FileConversionException(int errorCode) {
        this.errorCode = errorCode;
    }

    public FileConversionException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public FileConversionException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}