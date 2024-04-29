package com.sathya.orm2.bookrepository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sathya.orm2.entity.Book;

import jakarta.transaction.Transactional;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	//@querry denotes that these are custom jpql queries and custom methods  or java syntax query
	// predefiend methods are findall deletebyid deleteall sava saveall etc;
	@Query("SELECT b.author, b.isbn FROM Book b")
                public List<String>getData();

	@Query ("select count(b) from Book b where b.author=:author")
	public int authorNameCount(String author);
	
	@Query ("select distinct b.author from Book b")
	public List<String>authorNameDistinct();
	
	// these are myql or native database query or say normal query 
	
	   @Modifying
	    @Transactional
	    @Query(value = "UPDATE Book b SET b.name = :newname WHERE b.isbn = :isbn")
	    int updateBookNameById(int isbn, String newname);
	   
	   
	   // custom queries are ......

	

}
