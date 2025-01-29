package fr.efrei.springrag.web.dto;

public record Document(Long id, String title, String description, String author, String publisher, String publishedDate, String contentType, String content) {
}
