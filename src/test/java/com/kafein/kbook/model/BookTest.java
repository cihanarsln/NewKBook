package com.kafein.kbook.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BookTest {

    private Book book;

    private BookType type;

    private Author author;

    private Publisher publisher;

    @Before
    public void setup(){
        type = Mockito.mock(BookType.class);
        author = Mockito.mock(Author.class);
        publisher = Mockito.mock(Publisher.class);
        book = new Book();
        book.setId(1);
        book.setName("BookName");
        book.setType(type);
        book.setEditionYear(2000);
        book.setIsbn("isbn");
        book.setHardcover(true);
        book.setNop(1);
        book.setAuthor(author);
        book.setStatus(true);
        book.setPublisher(publisher);
    }

    @Test
    public void hashCodeTest(){
        assertNotNull(book.hashCode());
    }

    @Test
    public void toStringTest(){
        assertNotNull(book.toString());
    }

    @Test
    public void equalsTest(){
        Book docToComp = createBook();
        Book nullRequest = null;
        Object nullObject = null;
        assertTrue(docToComp.equals(book) && book.equals(docToComp));
        assertFalse(book.equals(nullRequest));
        assertFalse(book.equals(nullObject));
    }

    private Book createBook(){
        Book theBook = new Book();
        theBook.setId(1);
        theBook.setName("BookName");
        theBook.setType(type);
        theBook.setEditionYear(2000);
        theBook.setIsbn("isbn");
        theBook.setHardcover(true);
        theBook.setNop(1);
        theBook.setAuthor(author);
        theBook.setStatus(true);
        theBook.setPublisher(publisher);
        return theBook;
    }

}
