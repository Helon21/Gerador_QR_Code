package com.helonxavier.qrcode.generator.ports;

public interface StoragePorts {

    String upload(byte[] fileData, String fileName, String contentType);
}
