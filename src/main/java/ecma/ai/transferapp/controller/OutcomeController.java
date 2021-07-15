package ecma.ai.transferapp.controller;

import ecma.ai.transferapp.payload.ApiResponse;
import ecma.ai.transferapp.payload.OutcomeDto;
import ecma.ai.transferapp.service.OutcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/outcome")
public class OutcomeController {

    @Autowired
    OutcomeService outcomeService;

    @GetMapping
    public HttpEntity<?> get() {
        return ResponseEntity.ok(outcomeService.getAll());
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(outcomeService.getById(id));
    }

    @PostMapping
    public HttpEntity<?> add(@RequestBody OutcomeDto outcomeDto, HttpServletRequest httpServletRequest) {

        ApiResponse response = outcomeService.add(outcomeDto, httpServletRequest);
        return ResponseEntity.status(response.isSuccess() ? 200 : 409).body(response);

    }
//    @PutMapping("/{id}")
//    public HttpEntity<?> edited(@PathVariable Integer id, @RequestBody OutcomeDto outcomeDto, HttpServletRequest httpServletRequest){
//        ApiResponse apiResponse = outcomeService.edit(id, outcomeDto, httpServletRequest);
//        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
//    }


    @DeleteMapping("/{id}")
    public HttpEntity<?> deleted(@PathVariable Integer id){
        ApiResponse apiResponse = outcomeService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
