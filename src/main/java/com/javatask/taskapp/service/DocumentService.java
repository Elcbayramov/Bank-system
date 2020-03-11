package com.javatask.taskapp.service;

import com.javatask.taskapp.model.PersonDocuments;

import java.util.List;

public interface DocumentService {

    List<PersonDocuments> getDocuments();

    PersonDocuments getDocument(Integer id);

    PersonDocuments saveDocument(PersonDocuments documents);

    void deleteDocument(Integer id);

    PersonDocuments updateDocument(PersonDocuments documents);
}
