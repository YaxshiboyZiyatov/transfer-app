package ecma.ai.transferapp.controller;

import ecma.ai.transferapp.payload.ApiResponse;
import ecma.ai.transferapp.service.IncomeService;
import ecma.ai.transferapp.service.OutcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/income")
public class IncomeController {
    @Autowired
    IncomeService incomeService;

    @GetMapping
    public HttpEntity<?> get() {
        return ResponseEntity.ok(incomeService.getAll());
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(incomeService.getById(id));
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleted(@PathVariable Integer id){
        ApiResponse apiResponse = incomeService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }



}
