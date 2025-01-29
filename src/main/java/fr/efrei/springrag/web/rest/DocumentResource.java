package fr.efrei.springrag.web.rest;

import fr.efrei.springrag.domain.Document;
import fr.efrei.springrag.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class DocumentResource {


    private static final Logger log = LoggerFactory.getLogger(DocumentResource.class);
    private final DocumentService documentService;

    public DocumentResource(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/documents")
    public ResponseEntity<List<Document>> getAllDocuments() {
        log.debug("REST request to get all Documents");

        return ResponseEntity.ok(documentService.findAll());
    }

    @PostMapping("/documents")
    public ResponseEntity<Document> createDocument(@RequestBody Document document) throws URISyntaxException {
        log.debug("REST request to save Document : {}", document);

        Document result = documentService.buildAndSave(document);

        return ResponseEntity
                .created(new URI("/documents/" + result.getId()))
                .body(documentService.buildAndSave(document));
    }

    @GetMapping("/documents/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable Long id) {
        log.debug("REST request to get Document : {}", id);

        Document document = documentService.findById(id);

        if (document == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(document);
    }

    @DeleteMapping("/documents/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
        log.debug("REST request to delete Document : {}", id);

        try {
            documentService.deleteById(id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
