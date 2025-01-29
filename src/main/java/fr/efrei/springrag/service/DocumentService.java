package fr.efrei.springrag.service;

import fr.efrei.springrag.domain.Document;
import fr.efrei.springrag.repository.DocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    private static final Logger log = LoggerFactory.getLogger(DocumentService.class);
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<Document> findAll() {
        log.debug("Request to find all Documents");
        return documentRepository.findAll();
    }

    public Document buildAndSave(Document document) {
        log.debug("Request to buildAndSave Document : {}", document);
        return documentRepository.save(document);
    }

    public Document findById(Long id) {
        log.debug("Request to find Document by id : {}", id);
        return documentRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        log.debug("Request to delete Document by id : {}", id);

        if (documentRepository.existsById(id)) {
            documentRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Document with id " + id + " does not exist");
        }
    }

}
