package ecma.ai.transferapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeDto {

    private Integer fromCardId;
    private Integer toCardId;
    private double amount;

}
