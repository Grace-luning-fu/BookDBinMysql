package com.grace.nakelia.bookdb.controllers;

import com.grace.nakelia.bookdb.models.Book;
import com.grace.nakelia.bookdb.repositories.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class MainController {
    @Autowired
    BookRepo bookRepo;


    @GetMapping("/")
    public String defaultRequest(Model model){
        String myMessage = "welcome to the Book Database";
        model.addAttribute("message", myMessage);
        return "welcome";
    }


    @GetMapping("/addbook")
    public String addBook(Model model) {
        model.addAttribute("newBook", new Book());
        return "addbook";
    }

    @PostMapping("/addbook")
    public String postBook(@Valid @ModelAttribute("newBook") Book book, BindingResult bindingResult)
    {

        if(bindingResult.hasErrors()){
            return "addbook";
        }
        bookRepo.save(book);
        return "result";
    }

    @GetMapping("/showdatabase")
    public BookRepo initDatabase(){
        Iterable<Book> booklist;
        ArrayList<Book> toadd = new ArrayList<>();

        Book newBook1 = new Book();
        newBook1.set("Java1001", "Head First Java", "Kathy Sierra and Bert Bates", "Easy to read Java workbook", 47.50);

        Book newBook2 = new Book();
        newBook2.set("Java1002", "Thinking in Java", "Bruce Eckel", "Details about Java under the hood", 20.00);

        Book newBook3 = new Book();
        newBook3.set("Orcl1003", "OCP: Oracle Certified Professional Java SE", "Jeanne Boyarsky",
                "Everything you need to know in one place", 45.00);

        Book newBook4 = new Book();
        newBook4.set("Python1004", "Automate the Boring Stuff with Python", "Al Sweigart", "Fun with Python", 10.50);

        Book newBook5 = new Book();
        newBook5.set("Zombie1005", "The Maker's Guide to the Zombie Apocalypse", "Simon Monk",
                "Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi", 16.50);

        Book newBook6 = new Book();
        newBook6.set("Rasp1006", "Raspberry Pi Projects for the Evil Genius", "Donald Norris",
                "A dozen fiendishly fun projects for the Raspberry Pi!", 14.75);

        toadd.add(newBook1);
        toadd.add(newBook3);
        toadd.add(newBook4);
        toadd.add(newBook5);
        toadd.add(newBook6);

        booklist=toadd;

        bookRepo.save(booklist);

        return bookRepo;


    }

    @GetMapping("/showbook")
    public String showAllBooks() {

        Iterable<Book> booklist = bookRepo.findAll();
        return booklist.toString();
    }

}
