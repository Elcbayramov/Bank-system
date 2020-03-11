package com.javatask.taskapp.service.serviceImpl;

import com.javatask.taskapp.model.Credits;
import com.javatask.taskapp.repository.CreditRepository;
import com.javatask.taskapp.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CreditServiceImpl implements CreditService {

    List<Credits> credits;

    @Autowired
    private CreditRepository creditRepository;


    @Override
    public List<Credits> getCredits(Credits credits) {
        Integer personName = credits.getCreditId();
        List<Credits> creditsList = creditRepository.findAll().stream()
                .filter(cr -> personName.equals(cr.getPerson().getId()))
                .collect(Collectors.toList());

        return creditsList;
    }

    @Override
    public Credits getCredit(Integer id) {
        return credits.stream()
                .filter(e -> Objects.equals(e.getCreditId(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Credits saveCredit(Credits credit) {
        creditRepository.save(credit);
        return credit;
    }

    @Override
    public void deleteCredit(Integer id) {

       creditRepository.deleteById(id);
    }

    @Override
    public Credits updateCredit(Credits credit ) {

        Credits fromList = getCredit(credit.getCreditId());

        if (Objects.isNull(fromList))
            return null;

        fromList.setCreditType(credit.getCreditType());
        fromList.setAccountNumber(credit.getAccountNumber());
        fromList.setCreatedOn(credit.getCreatedOn());
        fromList.setContractStart(credit.getContractStart());
        fromList.setContractDue(credit.getContractDue());
        fromList.setInitialAmount(credit.getInitialAmount());
        fromList.setLastPayment(credit.getLastPayment());
        fromList.setOutstandingDebt(credit.getOutstandingDebt());
        fromList.setCreditType(credit.getCreditType());


        fromList.setCreditHistories(credit.getCreditHistories());
        creditRepository.save(fromList);
        return fromList;
    }
}
