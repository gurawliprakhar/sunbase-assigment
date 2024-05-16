package com.velamdir.backend.pdfassistent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.parser.apache.pdfbox.ApachePdfBoxDocumentParser;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;

import javax.annotation.PostConstruct;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import static dev.langchain4j.data.document.loader.FileSystemDocumentLoader.loadDocument;

@SpringBootApplication
public class PdfAssistentApplication {
    private final EmbeddingStoreIngestor embeddingStoreIngestor;

    public PdfAssistentApplication(EmbeddingStoreIngestor embeddingStoreIngestor) {
        this.embeddingStoreIngestor = embeddingStoreIngestor;
    }

    @PostConstruct
    public void init() {
        Document document = loadDocument(toPath("cassandra.pdf"), new ApachePdfBoxDocumentParser());
        embeddingStoreIngestor.ingest(document);
    }

    private static Path toPath(String fileName) {
        try {
            URL fileUrl = PdfAssistentApplication.class.getClassLoader().getResource(fileName);
            if (fileUrl != null) {
                return Paths.get(fileUrl.toURI());
            } else {
                throw new RuntimeException("File not found: " + fileName);
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(PdfAssistentApplication.class, args);
    }
}
