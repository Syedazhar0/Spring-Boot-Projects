package com.sathya.orm2.bookClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sathya.orm2.bookrepository.BookRepository;

@Component
public class BookClient implements CommandLineRunner {

	@Autowired
	BookRepository bookRepository;
	@Override
	public void run(String... args) throws Exception {
		List<String> authorNmaeList= bookRepository.getData();
	   authorNmaeList.forEach(author->System.out.println(author));
	   
	   System.out.println("###########");
	   
	   int namecount=   bookRepository.authorNameCount("azhar");
	   System.out.println("count is "+namecount);
	   
	   System.out.println("###########");
	   
	   List<String> distinctList =bookRepository.authorNameDistinct();
	   distinctList.forEach(dis->System.out.println(dis));
	   
	   int update =bookRepository.updateBookNameById(111, "core_java");
	   System.out.println("name updated......"+update);
		
	}
	

}
