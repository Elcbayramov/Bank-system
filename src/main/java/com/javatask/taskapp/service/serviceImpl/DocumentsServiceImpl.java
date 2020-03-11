package com.javatask.taskapp.service.serviceImpl;

import com.javatask.taskapp.model.PersonDocuments;
import com.javatask.taskapp.service.DocumentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DocumentsServiceImpl implements DocumentService {

    List<PersonDocuments> documents;


    @Override
    public List<PersonDocuments> getDocuments() {
        return documents;
    }

    @Override
    public PersonDocuments getDocument(Integer id) {
        return documents.stream()
                .filter(e -> Objects.equals(e.getId(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public PersonDocuments saveDocument(PersonDocuments document) {
        document.setId(document.getId());
        documents.add(document);
        return document;
    }

    @Override
    public void deleteDocument(Integer id) {

        documents.removeIf(e -> Objects.equals(e.getId(), id));
    }

    @Override
    public PersonDocuments updateDocument(PersonDocuments document) {

        PersonDocuments fromList = getDocument(document.getId());

        if (Objects.isNull(fromList))
            return null;

        fromList.setPersonDocumentType(document.getPersonDocumentType());
        fromList.setDocumentExpiredOn(document.getDocumentExpiredOn());

        fromList.setDocumentNumber(document.getDocumentNumber());
        return fromList;
    }


}
