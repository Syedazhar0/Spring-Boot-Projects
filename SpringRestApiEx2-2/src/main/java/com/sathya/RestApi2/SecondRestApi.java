package com.sathya.RestApi2;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondRestApi {
	
	@GetMapping("/name/{yourname}")
	public String getName(@PathVariable String yourname) {
		return "Good morning "+yourname;
		
	}
	
	List<Book> booksList = List.of(new Book(101,"java","James Gosling ",1500.00),
			                                             new Book(102,"Html","Tim Berners-Lee  ",1200.00),
			                                             new Book(103,"Spring","Rod JohnSon ",1400.00));
	
	@GetMapping("books")
	public List<Book> getBooks(){
		return booksList;
	}
	
	
	Book bokBook = null;
	@GetMapping("bookss/{isbn}")
	public Book getBook(@PathVariable int isbn) {
		for (Book book : booksList) {
			if (book.getIsbn()==isbn) {
				bokBook=book;
			}
			
		}
		return bokBook;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
