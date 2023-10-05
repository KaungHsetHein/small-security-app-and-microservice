package com.example.permissiionevaluator.service;

import com.example.permissiionevaluator.ds.Document;
import com.example.permissiionevaluator.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository repository;

    @PostAuthorize("hasPermission(returnObject,'ROLE_ADMIN')")
    public Document getDocument(String code){
        return repository.findDocument(code);
    }
}
