package com.sohaib.documentweb.repos;

import com.sohaib.documentweb.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document,Long> {

}
