package com.example.springintro.service;

import com.example.springintro.model.entity.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;
    List<Book> findBooksAfterGivenYear(LocalDate of);

    List<String> findAllAuthorsWithAtLeastOneBookAfterGivenYear(LocalDate of);

    List<String> findAllBooksWithGivenAuthor(String firstName,String lastName);

    List<String> findBooksByAgeRestriction() throws IOException;

    List<String> findBooksByEditionType() throws IOException;

    List<String> findBooksByPrice();

    List<String> findBooksWithGivenRestriction(String miNor);

    Iterable<Object> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    Iterable<Object> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    Arrays findAllBooksAfterYear(int year);
}
