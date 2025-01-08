package fr.efrei.springrag.repository;

import fr.efrei.springrag.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
