package fr.efrei.springrag.service;

import fr.efrei.springrag.domain.Document;
import fr.efrei.springrag.repository.DocumentRepository;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(DocumentService.class);

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
