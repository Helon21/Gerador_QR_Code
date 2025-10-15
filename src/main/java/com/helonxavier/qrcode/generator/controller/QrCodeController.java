package com.helonxavier.qrcode.generator.controller;

import com.helonxavier.qrcode.generator.dto.QrCodeGenerateRequest;
import com.helonxavier.qrcode.generator.dto.QrCodeGenerateResponse;
import com.helonxavier.qrcode.generator.service.QrCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
@RequiredArgsConstructor
@Slf4j
public class QrCodeController {

    private final QrCodeService qrCodeService;

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generate(@RequestBody QrCodeGenerateRequest request) {
        try {
            QrCodeGenerateResponse qrCodeGenerateResponse = this.qrCodeService.generate(request.text());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            log.error("Error generating qr code", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
