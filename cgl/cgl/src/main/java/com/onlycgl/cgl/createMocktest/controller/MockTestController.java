package com.onlycgl.cgl.createMocktest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.onlycgl.cgl.createMocktest.dto.MockTestFormDTO;
import com.onlycgl.cgl.createMocktest.service.ExcelServiceTest;

@RestController
@RequestMapping("/api/mocktests")
public class MockTestController {

    @Autowired
    private ExcelServiceTest excelService;
   
  
    

    
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
         if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please upload a valid Excel file.");
        }
        try {
            int savedCount = excelService.saveDataFromExcel(file);
            return ResponseEntity.ok("File processed successfully. Total questions saved: " + savedCount);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing file: " + e.getMessage());
        }
    }
    
}
