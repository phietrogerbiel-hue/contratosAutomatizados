package model.services;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public void processContract(Contract contract, int months){
        for (int i = 1; i <=  months; i++) {
            Double value = contract.getTotalValue() / months;
            Double valueInterest = onlinePaymentService.interest(value, i);
            Double valueAll = onlinePaymentService.paymentFee(valueInterest);

            Installment installment = new Installment(contract.getDate().plusMonths(i), valueAll);


        }
    }
}
