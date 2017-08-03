package com.grace.nakelia.bookdb.repositories;
import com.grace.nakelia.bookdb.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book,Long> {
}
