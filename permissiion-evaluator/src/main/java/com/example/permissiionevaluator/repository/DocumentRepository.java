package com.example.permissiionevaluator.repository;

import com.example.permissiionevaluator.ds.Document;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.Map;

@Repository
public class DocumentRepository {
    private Map<String, Document> documents = Map.of("abc123",new Document("john"),
            "qwe123",new Document("mary"),
            "zxc123",new Document("doe"));

    public Document findDocument(String code){
      return   documents.get(code);
    }
}
