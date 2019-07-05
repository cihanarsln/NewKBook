package com.kafein.kbook.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BookTypeTest {

    private BookType bookType;

    @Before
    public void setup(){
        bookType = new BookType();
        bookType.setId(1);
        bookType.setName("BookTypeName");
    }

    @Test
    public void hashCodeTest(){
        assertNotNull(bookType.hashCode());
    }

    @Test
    public void toStringTest(){
        assertNotNull(bookType.toString());
    }

    @Test
    public void equalsTest(){
        BookType docToComp = createBookType();
        BookType nullRequest = null;
        Object nullObject = null;
        assertTrue(docToComp.equals(bookType) && bookType.equals(docToComp));
        assertFalse(bookType.equals(nullRequest));
        assertFalse(bookType.equals(nullObject));
    }


    private BookType createBookType(){
        BookType theBookType = new BookType();
        theBookType.setId(1);
        theBookType.setName("BookTypeName");
        return theBookType;
    }

}
