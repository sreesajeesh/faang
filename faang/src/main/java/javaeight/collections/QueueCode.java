package javaeight.collections;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueCode {

    public static void main(String[] args) {
        //linkedListQueue();
        //arrayDeque();
        //priorityQueueNaturalOrdering();
        priorityQueueDifferentOrdering();
    }

    public static void linkedListQueue(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.offer(2);
        queue.add(3);
        queue.offer(4);

        System.out.println(queue.element()); // if queue is null it throws exception
        System.out.println(queue.peek()); // if queue is null it returns empty queue
        System.out.println(queue);
    }

    public static void arrayDeque(){
        Deque<Integer> numbers = new ArrayDeque<>();
        numbers.add(1);
        numbers.addFirst(2);
        numbers.offerFirst(3);
        numbers.addLast(4);
        numbers.offerLast(5);
        System.out.println(numbers);

        numbers.removeFirst();
        numbers.pollFirst();
        System.out.println(numbers);
        numbers.removeLast();
        numbers.pollLast();
        System.out.println(numbers);
    }

    public static void priorityQueueNaturalOrdering(){
        Queue<String> names = new PriorityQueue<>();
        names.add("V");
        names.offer("P");
        names.add("A");
        Iterator<String> itNames = names.iterator();
        while (itNames.hasNext()){
            System.out.println(names.poll() + " ");
        }
    }

    public static void priorityQueueDifferentOrdering(){
        Comparator<Book> titleComparator = Comparator.comparing(Book::getTitle);
        Queue<Book> bookByTitle = new PriorityQueue<>(titleComparator);

        bookByTitle.add(new Book("Java", 55.00));
        bookByTitle.add(new Book("Python", 45.00));
        bookByTitle.add(new Book("C++", 65.00));

        System.out.println("Ordering by Title");
        Iterator<Book> itBooks = bookByTitle.iterator();
        while (itBooks.hasNext()){
            Book book = itBooks.next();
            System.out.println(book);
        }

        Comparator<Book> priceComparator = Comparator.comparing(Book::getPrice);
        Queue<Book> bookByPrice = new PriorityQueue<>(priceComparator);
        bookByPrice.add(new Book("Java", 55.00));
        bookByPrice.add(new Book("Python", 45.00));
        bookByPrice.add(new Book("C++", 65.00));
        System.out.println("Ordering by Price");
        itBooks = bookByPrice.iterator();
        while (itBooks.hasNext()){
            Book book = itBooks.next();
            System.out.println(book);
        }
    }
}

class Book {
    private String title;
    private Double price;

    public Book(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
