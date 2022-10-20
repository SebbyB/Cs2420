//package assign06;
package com.assign05.assign06;



import java.net.URL;
import java.util.NoSuchElementException;

public class WebBrowser {

    private LinkedListStack<URL> forward;

    private LinkedListStack<URL> history;
    private URL current;

    public WebBrowser(){

        forward = new LinkedListStack<URL>();
        history = new LinkedListStack<URL>();
        current = null;

    }

    public WebBrowser(SinglyLinkedList<URL> hist){
        forward = new LinkedListStack<URL>();

        history = new LinkedListStack<>();
        current = hist.deleteFirst();
//        hist.deleteFirst();
        while(!hist.isEmpty()){
        history.push(hist.delete(hist.size() - 1));

        }
//        history.pop();


    }


    public void visit(URL webpage){
        history.push(current);
        forward.clear();
        current = webpage;

    }

    public URL back() throws NoSuchElementException{


        if(history.isEmpty()){throw new NoSuchElementException();}

        forward.push(current);
        current = history.peek();
        history.pop();


        return current;
    }

    public URL forward() throws NoSuchElementException{

        if(forward.isEmpty()){throw new NoSuchElementException();}

        history.push(current);
        current = forward.peek();
        forward.pop();

        return current;
    }

     public SinglyLinkedList<URL> history(){

        SinglyLinkedList<URL> retHistory = new SinglyLinkedList<>();


        LinkedListStack<URL> copyHist = new LinkedListStack<URL>();

        if(history.size() == 0){
            return null;}






        while(!history.isEmpty()){
            copyHist.push(history.peek());
        retHistory.insertFirst(history.pop());}
         history.clear();

         while(!copyHist.isEmpty()){

            history.push(copyHist.pop());
        }
         retHistory.insertFirst(current);

        return retHistory;


     }




}
