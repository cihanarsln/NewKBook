package com.kafein.kbook.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AuthorTest {

    private Author author;

    @Before
    public void setup() {
        author = new Author();
        author.setId(1);
        author.setFname("TestFname");
        author.setLname("TestLname");
    }

    @Test
    public void hashCodeTest(){
        assertNotNull(author.hashCode());
    }

    @Test
    public void toStringTest(){
        assertNotNull(author.toString());
    }

    @Test
    public void equalsTest(){
        Author docToComp = createAuthor();
        Author nullRequest = null;
        Object nullObject = null;
        assertTrue(docToComp.equals(author) && author.equals(docToComp));
        assertFalse(author.equals(nullRequest));
        assertFalse(author.equals(nullObject));
    }

    private Author createAuthor() {
        Author theAuthor = new Author();
        theAuthor.setId(1);
        theAuthor.setFname("TestFname");
        theAuthor.setLname("TestLname");
        return theAuthor;
    }


}
