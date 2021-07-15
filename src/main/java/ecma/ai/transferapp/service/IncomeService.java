package ecma.ai.transferapp.service;

import ecma.ai.transferapp.entity.Card;
import ecma.ai.transferapp.entity.Income;
import ecma.ai.transferapp.entity.Outcome;
import ecma.ai.transferapp.payload.ApiResponse;
import ecma.ai.transferapp.payload.IncomeDto;
import ecma.ai.transferapp.payload.OutcomeDto;
import ecma.ai.transferapp.repository.CardRepository;
import ecma.ai.transferapp.repository.IncomeRepository;
import ecma.ai.transferapp.repository.OutcomeRepository;
import ecma.ai.transferapp.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    @Autowired
    IncomeRepository incomeRepository;


    public List<Income> getAll(){
        return incomeRepository.findAll();

    }


    public Income getById(Integer id){

        Optional<Income> optionalIncome = incomeRepository.findById(id);
        return optionalIncome.orElse(null);
    }

    public ApiResponse delete(Integer id){
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if (optionalIncome.isPresent()){
            incomeRepository.deleteById(id);
            return new ApiResponse("deleted income", true);

        }
        return new ApiResponse("not found ", false);
    }
}
