package com.example.springdataintro.services;

import com.example.springdataintro.models.*;
import com.example.springdataintro.repositories.AuthorRepository;
import com.example.springdataintro.repositories.BookRepository;

import com.example.springintro.model.entity.Book;
import com.example.springintro.repository.AuthorRepository;
import com.example.springintro.repository.BookRepository;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private static final BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
    private static final String BOOK_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedBooks() throws IOException {
        Files.readAllLines(Path.of(BOOK_PATH)).stream().filter(row->!row.isBlank()).forEach(bookData -> {
            try {
                bookRepository.save(createBook(bookData));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }


    @Override
    public List<Book> findBooksAfterGivenYear(LocalDate releaseDate) {
        return bookRepository.findByReleaseDateAfter(releaseDate);
    }

    @Override
    public List<String> findAllAuthorsWithAtLeastOneBookAfterGivenYear(LocalDate of) {
        return bookRepository.findDistinctByReleaseDateBefore(of).stream().map(b->String.format("%s %s",b.getAuthor().getFirstName(),b.getAuthor().getLastName()))
                .distinct().collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksWithGivenAuthor(String firstName, String lastName) {
        return  bookRepository.findAllByAuthor_firstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName,lastName).stream().map(b->
                String.format("%s %s %d",b.getTitle(),String.valueOf(b.getReleaseDate()),b.getCopies())).collect(Collectors.toList());
    }

    @Override
    public List<String> findBooksByAgeRestriction() throws IOException {
        System.out.println("Enter age restriction:");
        String ageRest = reader.readLine();

        return  bookRepository.findAllByAgeRestriction(ageRest.toUpperCase(Locale.ROOT).equals("MINOR") ? AgeRestriction.MINOR
                        : ageRest.toUpperCase(Locale.ROOT).equals("ADULT") ? AgeRestriction.ADULT : AgeRestriction.TEEN).stream().
                map(s->String.format("%s",s.getTitle())).collect(Collectors.toList());
    }

    @Override
    public List<String> findBooksByEditionType() throws IOException {
        System.out.println("Enter edition type:");
        String editionType = reader.readLine();
//  NORMAL, PROMO, GOLD
        return  bookRepository.findAllByEditionTypeAndCopiesLessThan(editionType.toUpperCase(Locale.ROOT).equals("NORMAL") ? EditionType.NORMAL
                        : editionType.toUpperCase(Locale.ROOT).equals("GOLD") ? EditionType.GOLD : EditionType.PROMO,5000).stream().
                map(s->String.format("%s",s.getTitle())).collect(Collectors.toList());
    }

    @Override
    public List<String> findBooksByPrice() {
        return bookRepository.findByPriceLessThanAndGreaterThan().stream().map(b->String.format("%s %.2f",b.getTitle(),b.getPrice())).collect(Collectors.toList());
    }


    public Book  createBook(String bookData) throws IOException {

        String title = Arrays.stream(bookData.split("\\s+")).skip(5).collect(Collectors.joining(" ")).trim();
        String[] data = bookData.split("\\s+");
        Author author = authorService.getRandomAuthor();
        EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
        LocalDate releaseDate = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        int copies = Integer.parseInt(data[2]);
        BigDecimal price = new BigDecimal(data[3]);
        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];

        Set<Category> randomCategories = categoryService.getRandomCategories();
        Book book = new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, randomCategories);

        return book;
    }
}
