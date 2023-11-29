package bookAnalyzer;

import java.io.*;
import java.util.Scanner;

public class BookAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the book title: ");
        String bookName = scanner.nextLine();

        Book book = new Book(bookName);

        if ( !book.exists() ) {
            System.out.println("Book not found in the src/ directory.");
            return;
        }

        try {
            String content = book.getContent();
            BookStatistics bookStatistics = new BookStatistics(book, content);
            bookStatistics.analyzeAndPrint();
        } catch ( IOException e ) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
