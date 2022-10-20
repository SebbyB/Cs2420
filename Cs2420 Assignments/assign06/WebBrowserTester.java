package com.assign05.assign06;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


public class WebBrowserTester {









    @Test
    public void throwsOnEmptyListForward(){

    WebBrowser browser = new WebBrowser();

    assertThrows(NoSuchElementException.class, () -> {browser.forward();});
}

    @Test
    public void throwsOnEmptyListBackward(){

        WebBrowser browser = new WebBrowser();

        assertThrows(NoSuchElementException.class, () -> {browser.back();});
    }




    @Test
    public void constructWithHistory() throws MalformedURLException, FileNotFoundException {

         SinglyLinkedList<URL> testHistory = new SinglyLinkedList<>();
        testHistory.insertFirst(new URL("http://www.youtube.com"));
        testHistory.insertFirst(new URL("http://www.facebook.com"));
        testHistory.insertFirst(new URL("http://www.baidu.com"));
        testHistory.insertFirst(new URL("http://www.yahoo.com"));
        testHistory.insertFirst(new URL("http://www.amazon.com"));
        testHistory.insertFirst(new URL("http://www.wikipedia.org"));
        WebBrowser browser = new WebBrowser(testHistory);
        browser.back();
        assertEquals(browser.forward().toString(),"http://www.wikipedia.org");
        assertEquals(browser.back().toString(),"http://www.amazon.com" );
        assertEquals(browser.back().toString(),"http://www.yahoo.com" );
        assertEquals(browser.back().toString(),"http://www.baidu.com" );
        assertEquals(browser.back().toString(),"http://www.facebook.com" );
        assertEquals(browser.back().toString(),"http://www.youtube.com" );
        assertEquals(browser.forward().toString(),"http://www.facebook.com" );
        assertEquals(browser.forward().toString(),"http://www.baidu.com" );
        assertEquals(browser.forward().toString(),"http://www.yahoo.com" );
        assertEquals(browser.forward().toString(),"http://www.amazon.com" );
        assertEquals(browser.forward().toString(),"http://www.wikipedia.org" );


    }




    @Test
    public void forwardBackward() throws MalformedURLException, FileNotFoundException {

        SinglyLinkedList<URL> testHistory = new SinglyLinkedList<>();
        testHistory.insertFirst(new URL("http://www.amazon.com"));
        testHistory.insertFirst(new URL("http://www.wikipedia.org"));
        WebBrowser browser = new WebBrowser(testHistory);
        browser.back();
        assertEquals(browser.forward().toString(), "http://www.wikipedia.org");
        assertEquals(browser.back().toString(), "http://www.amazon.com");
        assertEquals(browser.forward().toString(), "http://www.wikipedia.org");
        assertEquals(browser.back().toString(), "http://www.amazon.com");
        assertEquals(browser.forward().toString(), "http://www.wikipedia.org");
        assertEquals(browser.back().toString(), "http://www.amazon.com");

    }


    @Test
    public void visitAndForwardBackward() throws MalformedURLException, FileNotFoundException {

        SinglyLinkedList<URL> testHistory = new SinglyLinkedList<>();
        testHistory.insertFirst(new URL("http://www.amazon.com"));
        testHistory.insertFirst(new URL("http://www.wikipedia.org"));
        WebBrowser browser = new WebBrowser(testHistory);
        browser.back();
        assertEquals(browser.forward().toString(), "http://www.wikipedia.org");
        assertEquals(browser.back().toString(), "http://www.amazon.com");
        assertEquals(browser.forward().toString(), "http://www.wikipedia.org");
        assertEquals(browser.back().toString(), "http://www.amazon.com");
        assertEquals(browser.forward().toString(), "http://www.wikipedia.org");
        assertEquals(browser.back().toString(), "http://www.amazon.com");

        browser.visit(new URL("http://www.youtube.com"));
        assertEquals(browser.back().toString(), "http://www.amazon.com");
        assertEquals(browser.forward().toString(), "http://www.youtube.com");




    }


    @Test
    public void getHistory() throws MalformedURLException, FileNotFoundException {

        SinglyLinkedList<URL> testHistory = new SinglyLinkedList<>();

        testHistory.insertFirst(new URL("http://www.youtube.com"));
        testHistory.insertFirst(new URL("http://www.facebook.com"));
        testHistory.insertFirst(new URL("http://www.baidu.com"));
        testHistory.insertFirst(new URL("http://www.yahoo.com"));
        testHistory.insertFirst(new URL("http://www.amazon.com"));
        testHistory.insertFirst(new URL("http://www.wikipedia.org"));
        int size = testHistory.size();
        WebBrowser browser = new WebBrowser(testHistory);


        assertEquals(size,browser.history().size());

        browser.history();
        browser.history();
        browser.history();
        browser.history();
        assertEquals(size,browser.history().size());
        assertEquals(size,browser.history().size());

        while(!testHistory.isEmpty() && !browser.history().isEmpty())

        assertEquals(testHistory.deleteFirst(),browser.history().deleteFirst());




    }


    @Test
    public void getHistoryEmpty() throws MalformedURLException, FileNotFoundException {
        WebBrowser browser = new WebBrowser();
        assertNull(browser.history());

    }


    @Test
    public void growHistory() throws MalformedURLException, FileNotFoundException {

        SinglyLinkedList<URL> testHistory = new SinglyLinkedList<>();

        testHistory.insertFirst(new URL("http://www.youtube.com"));
        testHistory.insertFirst(new URL("http://www.facebook.com"));
        testHistory.insertFirst(new URL("http://www.baidu.com"));
        testHistory.insertFirst(new URL("http://www.yahoo.com"));
        testHistory.insertFirst(new URL("http://www.amazon.com"));
        testHistory.insertFirst(new URL("http://www.wikipedia.org"));
        int size = testHistory.size();
        WebBrowser browser = new WebBrowser(testHistory);


        assertEquals(size,browser.history().size());

        SinglyLinkedList<URL> bh = browser.history();
//        browser.visit(new URL("http://www.amazon.com"));

//        assertEquals(size + 1,browser.history().size());
//        assertEquals(size,browser.history().size());
//        browser.history();


        while(!browser.history().isEmpty()){
            assertEquals(testHistory.deleteFirst(),browser.history().deleteFirst());}




    }



    }


