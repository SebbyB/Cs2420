package assign06;
//package com.assign05.assign06;


import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains tests for WebBrowser
 *
 * @author Amelia Nelson and Sebastian Barney
 * @version October 20, 2022
 */
public class WebBrowserTester {


    @Test
	    public void throwsOnEmptyListForward(){
	    WebBrowser browser = new WebBrowser();
	    assertThrows(NoSuchElementException.class, () -> {browser.forward();});
    }
    
    @Test
    public void throwsOnForwardListForwardTwice() throws MalformedURLException{
	    WebBrowser browser = new WebBrowser();
	    browser.visit(new URL("http://www.facebook.com"));
	    browser.visit(new URL("http://www.baidu.com"));
	    browser.visit(new URL("http://www.amazon.com"));
	    browser.back();
	    browser.back();
	    browser.forward();
	    browser.forward();
	    assertThrows(NoSuchElementException.class, () -> {browser.forward();});
    }
    
    
    @Test
    public void throwsOnEmptyListBackward(){
        WebBrowser browser = new WebBrowser();
        assertThrows(NoSuchElementException.class, () -> {browser.back();});
    }

	
	@Test
	public void throwsOnBackwardFullList() throws MalformedURLException{
		WebBrowser browser = new WebBrowser();
		browser.visit(new URL("http://www.facebook.com"));
		browser.visit(new URL("http://www.baidu.com"));
		browser.visit(new URL("http://www.amazon.com"));
		browser.back();
		browser.back();
		assertThrows(NoSuchElementException.class, () -> {browser.back();});
	}
	
	@Test
	public void throwsVisitForward() throws MalformedURLException{
		WebBrowser browser = new WebBrowser();
		browser.visit(new URL("http://www.facebook.com"));
		browser.visit(new URL("http://www.baidu.com"));
		browser.back();
		browser.visit(new URL("http://www.amazon.com"));
		assertThrows(NoSuchElementException.class, () -> {browser.forward();});
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
        //Checking to see that the current webpage is dealt with correctly
        assertEquals(6,browser.history().size());        
        browser.back();
        assertEquals(5,browser.history().size());
        assertEquals(browser.forward().toString(),"http://www.wikipedia.org");
        //Checking that back functions correctly consecutively
        assertEquals(browser.back().toString(),"http://www.amazon.com" );
        assertEquals(5,browser.history().size());
        assertEquals(browser.back().toString(),"http://www.yahoo.com" );
        assertEquals(4,browser.history().size());
        assertEquals(browser.back().toString(),"http://www.baidu.com" );
        assertEquals(3,browser.history().size());
        assertEquals(browser.back().toString(),"http://www.facebook.com" );
        assertEquals(2,browser.history().size());
        assertEquals(browser.back().toString(),"http://www.youtube.com" );
        assertEquals(1,browser.history().size());
        //Checking that forward works correctly consecutively
        assertEquals(browser.forward().toString(),"http://www.facebook.com" );
        assertEquals(2,browser.history().size());
        assertEquals(browser.forward().toString(),"http://www.baidu.com" );
        assertEquals(3,browser.history().size());
        assertEquals(browser.forward().toString(),"http://www.yahoo.com" );
        assertEquals(4,browser.history().size());
        assertEquals(browser.forward().toString(),"http://www.amazon.com" );
        assertEquals(5,browser.history().size());
        assertEquals(browser.forward().toString(),"http://www.wikipedia.org" );
        assertEquals(6,browser.history().size());


    }




    @Test
    public void forwardBackwardRepetitive() throws MalformedURLException, FileNotFoundException {

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
        //Makes sure visit method does not effect the function of the other methods
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

        //Checks history is correct size
        assertEquals(size,browser.history().size());
        
        //Checks history works repetitively corectly
        browser.history();
        browser.history();
        browser.history();
        browser.history();
        assertEquals(size,browser.history().size());
        assertEquals(size,browser.history().size());

        SinglyLinkedList<URL> browserHistory= new SinglyLinkedList<>();
        
        //Checks that contents of created history are correct
        browserHistory =  browser.history();
        while(!testHistory.isEmpty() && !browser.history().isEmpty())
        assertEquals(testHistory.deleteFirst(),browserHistory.deleteFirst());

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
        
        WebBrowser browser = new WebBrowser(testHistory);
        SinglyLinkedList<URL> browserHistory = browser.history();
        

        //Checks the size and contents of history are correct
        for(int i = 0; i < 6; i++) {
        	assertEquals(testHistory.size(),6-i);
        	assertEquals(browserHistory.size(),6-i);
        	String testHistoryFirstDelete = testHistory.deleteFirst().toString();
        	String browserHistoryFirstDelete = browserHistory.deleteFirst().toString();
        	assertEquals(testHistoryFirstDelete,browserHistoryFirstDelete);
        	      
        }
        
        //Checks that repition of the method is correct/internal webrowser history
        testHistory.insertFirst(new URL("http://www.youtube.com"));
        testHistory.insertFirst(new URL("http://www.facebook.com"));
        testHistory.insertFirst(new URL("http://www.baidu.com"));
        testHistory.insertFirst(new URL("http://www.yahoo.com"));
        testHistory.insertFirst(new URL("http://www.amazon.com"));
        testHistory.insertFirst(new URL("http://www.wikipedia.org"));
        
        SinglyLinkedList<URL> browserHistory2 = browser.history();
        
        for(int i = 0; i < 6; i++) {
        	assertEquals(testHistory.size(),6-i);
        	assertEquals(browserHistory2.size(),6-i);
        	String testHistoryFirstDelete = testHistory.deleteFirst().toString();
        	String browserHistoryFirstDelete2 = browserHistory2.deleteFirst().toString();
        	assertEquals(testHistoryFirstDelete,browserHistoryFirstDelete2);
        	      
        }

    }

}


