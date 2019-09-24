package DesignPatterns.BehaviouralDesignPattern;

import java.util.ArrayList;
import java.util.Arrays;

public class InterpreterPattern {

    private InterpreterContext context;

    public InterpreterPattern(InterpreterContext context) {
        this.context = context;
    }

    public static void main(String[] args) {
        String DSL = "books by author 'author name'";
        InterpreterContext context = new InterpreterContext();
        InterpreterPattern client = new InterpreterPattern(context);
        //run a query
        String book_result = client.interpret("books by author 'Stephen Hawkins'");
        System.out.println(book_result);
        String movie_result = client.interpret("movies by author 'christopher nolan'");
        System.out.println(movie_result );

    }

    public String interpret(String expression) {
        AbstractExpression exp = null;
        String[] stringParts = expression.split(" ");
        String main = stringParts[0];
        String sub = stringParts[2];
        //get the query part
        String result = null;
        String query = expression.substring(expression.indexOf("'")+1, expression.lastIndexOf("'"));
        System.out.println("the query parsed now is "+query );
        if (main.equals("books")) {
            if (sub.equals("title")){
                exp = new BookTitleExpression(query);
            }
            if (sub.equals("year")){
                 exp = new BookYearExpression(query);
            }
            if (sub.equals("author")){
                exp = new BookAuthorExpression(query);
            }
        }
        else if(main.equals("movies"))
        {
            if (sub.equals("title")){
                exp = new MovieTitleExpression(query);
            }
            if (sub.equals("year")){
                exp = new MovieYearExpression(query);
            }
            if (sub.equals("author")){
                exp = new MovieAuthorExpression(query);
            }

        }
        if (exp != null) {
            result = exp.interpret(context);
        }
        return result;
    }
}

class InterpreterContext {

    public ArrayList<Movie> getAllMovies() {
            return new ArrayList<>(Arrays.asList(new Movie[]{new Movie("Inception","christopher nolan","2013"),new Movie("Memento","christopher nolan","1998")}));
    }

    public ArrayList<Book> getAllBooks() {
        return new ArrayList<>(Arrays.asList(new Book[]{new Book("Time Machine","Stephen Hawkins","2012"), new Book("The Lost Symbol", "Dan Brown","2008")}));
    }
}

class Movie {
    String title;
    String author;
    String year;

    public Movie(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}

class Book {
    String title;
    String author;
    String year;

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}

//Abstract Expression, takes the interpreter context
abstract class AbstractExpression {
    public abstract String interpret(InterpreterContext context);
}

//Concrete Expression, makes use of interpreter context to get itself interpreted. getting itself interpreted means,
// the data hold by the expression is evaluated by the help of interpreter.
class BookAuthorExpression extends AbstractExpression {
    private String searchString;

    public BookAuthorExpression(String searchString) {
        this.searchString = searchString;
    }

    public String interpret(InterpreterContext context) {
        ArrayList<Book> books = context.getAllBooks( );
        StringBuffer result = new StringBuffer( );
        for (Book book : books) {
            if (book.getAuthor( ).equalsIgnoreCase(searchString)) {
                result.append(book.toString( ));
            }
        }
        return result.toString( );
    }
}

class BookTitleExpression extends AbstractExpression {
    private String searchString;

    public BookTitleExpression(String searchString) {
        this.searchString = searchString;
    }

    public String interpret(InterpreterContext context) {
        ArrayList<Book> books = context.getAllBooks( );
        StringBuffer result = new StringBuffer( );
        for (Book book : books) {
            if (book.getTitle( ).equalsIgnoreCase(searchString)) {
                result.append(book.toString( ));
            }
        }
        return result.toString( );
    }

}

class BookYearExpression extends AbstractExpression {
    private String searchString;

    public BookYearExpression(String searchString) {
        this.searchString = searchString;
    }

    public String interpret(InterpreterContext context) {
        ArrayList<Book> books = context.getAllBooks( );
        StringBuffer result = new StringBuffer( );
        for (Book book : books) {
            if (book.getYear( ).equalsIgnoreCase(searchString)) {
                result.append(book.toString( ));
            }
        }
        return result.toString( );
    }
}

class MovieYearExpression extends AbstractExpression {
    private String searchString;

    public MovieYearExpression(String searchString) {
        this.searchString = searchString;
    }

    public String interpret(InterpreterContext context) {
        ArrayList<Movie> movies = context.getAllMovies();
        StringBuffer result = new StringBuffer( );
        for (Movie movie : movies) {
            if (movie.getYear( ).equalsIgnoreCase(searchString)) {
                result.append(movie.toString( ));
            }
        }
        return result.toString( );
    }
}

class MovieTitleExpression extends AbstractExpression {
    private String searchString;

    public MovieTitleExpression(String searchString) {
        this.searchString = searchString;
    }

    public String interpret(InterpreterContext context) {
        ArrayList<Movie> movies = context.getAllMovies();
        StringBuffer result = new StringBuffer( );
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(searchString)) {
                result.append(movie.toString( ));
            }
        }
        return result.toString( );
    }
}

class MovieAuthorExpression extends AbstractExpression {
    private String searchString;

    public MovieAuthorExpression(String searchString) {
        this.searchString = searchString;
    }

    public String interpret(InterpreterContext context) {
        ArrayList<Movie> movies = context.getAllMovies();
        StringBuffer result = new StringBuffer( );
        for (Movie movie : movies) {
            if (movie.getAuthor().equalsIgnoreCase(searchString)) {
                result.append(movie.toString( ));
            }
        }
        return result.toString( );
    }
}
