package com.javatask.taskapp.service.serviceImpl;

import com.javatask.taskapp.model.CreditHistory;
import com.javatask.taskapp.repository.CreditHistoryRepository;
import com.javatask.taskapp.service.CreditHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CreditHistoryServiceImpl implements CreditHistoryService {

    List<CreditHistory> creditHistories;

    @Autowired
    private CreditHistoryRepository historyRepository;



    @Override
    public List<CreditHistory> findAll(CreditHistory history) {
        Integer histories = history.getHistoryId();
        List<CreditHistory> historyList = historyRepository.findAll().stream()
                .filter(ch->histories.equals(ch.getHistoryId())).collect(Collectors.toList());
        return historyList;
    }

    @Override
    public CreditHistory getHistory(Integer id) {
        return creditHistories.stream()
                .filter(e -> Objects.equals(e.getHistoryId(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public CreditHistory saveHistory(CreditHistory history) {
         historyRepository.save(history);
        return history;
    }

    @Override
    public void deleteHistory(Integer id) {
        historyRepository.deleteById(id);
    }

    @Override
    public CreditHistory updateHistory(CreditHistory history) {

        CreditHistory fromList = getHistory(history.getHistoryId());

        if (Objects.isNull(fromList))
            return null;

        fromList.setReportPeriod(history.getReportPeriod());

        fromList.setCredits(history.getCredits());
        historyRepository.save(fromList);
        return fromList;
    }
}
