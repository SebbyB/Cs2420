package assign06;
//package com.assign05.assign06;





import java.net.URL;
import java.util.NoSuchElementException;
/**
 * WebBrowser that uses a LinkedList Stack for storage.
 * @author Sebastian Barney, Amelia Neilson.
 * @version October 20th, 2022
 *
 */

public class WebBrowser {

    private LinkedListStack<URL> forward;

    private LinkedListStack<URL> history;
    private URL current;

    /**
     * Constructor that initializes forward History and BackwardHistory to empty linked List stack.
     *
     */
    public WebBrowser(){

        forward = new LinkedListStack<URL>();
        history = new LinkedListStack<URL>();
        current = null;

    }

    /**
     * Constructs new WebBrowser with a preloaded history.
     * @param hist Takes in a singlyLinked List as a preloaded history.
     */
    public WebBrowser(SinglyLinkedList<URL> hist){
        forward = new LinkedListStack<URL>();
        history = new LinkedListStack<>();
        current = hist.getFirst();

        /**
         * Copies list over to Stack
         */
        for(int i = 1; i < hist.size();i++){
            history.push(hist.get(hist.size()-i));
        }
    }


    /**
     * Visits a webpage and adds it to the history.
     * @param webpage - URL of webpage.
     */
    public void visit(URL webpage){
        /**
         * if you're not visiting a webpage currently there should not be a forward history.
         * if you're visiting a webpage the current webpage should go back to history.
         * sets current webpage to parameter.
         */
    	if(current != null) {
        history.push(current);
        }
        forward.clear();
        current = webpage;

    }

    /**
     * Goes back one page through history.
     * @return new current webpage.
     * @throws NoSuchElementException if there isn't anything to go back to how are you going to go back?
     */
    public URL back() throws NoSuchElementException{
        /**
         * Checks if you can go back.
         * If you can, add current to forward history and reassign current to the first item on backward history and pop it.
         */
        if(history.isEmpty()){throw new NoSuchElementException();}
        forward.push(current);
        current = history.peek();
        history.pop();
        return current;
    }

    /**
     * Goes forward one page through forward history.
     * @return new current webpage.
     * @throws NoSuchElementException if there isn't anything to look forward to why try?
     */
    public URL forward() throws NoSuchElementException{

        /**
         * If there's nothing to look forward to throw exception.
         * otherwise push the current page to history and move forward in forwardhistory, then pop it off.
         */
        if(forward.isEmpty()){throw new NoSuchElementException();}
        history.push(current);
        current = forward.peek();
        forward.pop();
        return current;
    }

    /**
     * gets history
     * @return SinglyLinkedList of history.
     */
     public SinglyLinkedList<URL> history(){

        SinglyLinkedList<URL> retHistory = new SinglyLinkedList<URL>();
        LinkedListStack<URL> copyHist = new LinkedListStack<URL>();

         /**
          * if there is nothing to get don't try to get it.
          */
        if(history.size() == 0 && current == null){
            return null;}


         /**
          * copy data and add it to linked list in correct order.
          * Return correct ordered data.
          * Ensure history doesn't get changed.
          */
         while(!history.isEmpty()){
        copyHist.push(history.pop());
        }
         while(!copyHist.isEmpty()){
          URL correctURL = copyHist.pop();
          history.push(correctURL);
          retHistory.insertFirst(correctURL);
        }
        retHistory.insertFirst(current);
        return retHistory;


     }




}
