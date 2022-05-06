package ou.kenneth;

import java.util.ArrayList;
import java.util.Collections;
/**
 * New object class containing a 
 * ArrayList storing Book Objects (bookShelf)
 * Allowing removal and adding of books
 * @author Kenneth Ou
 * @date March 23, 2022
 */
public class BookShelf {
	
	private ArrayList<Book> bookShelf;
	/**
	 * Constructor which creates a new BookShelf object 
	 * and assigns a empty ArrayList for Book objects
	 */
	BookShelf() {
		bookShelf = new ArrayList<>();
	}
	/**
	 * This method adds Book Objects to the 
	 * ArrayList of books in the BookShelf
	 * @param anotherBook A Book object to be stored
	 */
	public void addBook(Book anotherBook) {
		bookShelf.add(anotherBook);
		Collections.sort(bookShelf); //Sort the books
	}
	/**
	 * This method removes Book objects from 
	 * the list of books in the bookshelf
	 * @param index used to remove the book using index from the ArrayList of books
	 */
	public void removeBook(int index ) { 
		bookShelf.remove(index);
		Collections.sort(bookShelf); //Sort the books
	}
	/**
	 * Simple method which displays all books within the ArrayList of books
	 * @param selection Depending on which selection was made to call this method, the way the book information is printed out is different
	 */
	public void displayAllBooks(int selection) { //Selection changes how the Book information is printed
		int bookNumber = 1; //Used to label each book (local variable)
		if (selection == 3 || selection == 4) {
			for (Book tempBook : getBookList()) { 
			System.out.println(bookNumber +" - " + tempBook.toString());
			bookNumber++;
			}
		}
		else {
			System.out.println("**************Books***************\n\nThere is " + bookShelf.size() + " books in the bookshelf");
			for (Book tempBook : getBookList()) { 
				System.out.println(tempBook.toString());
			}
		}
	}
	/**
	 * Simple method to find a book using the ISBN number of a book
	 * @param ISBNNumber User inputed ISBN number for a book
	 * @return Book with the ISBN number inputed by the user
	 */
	public Book getBookUsingISBN(int ISBNNumber) {
		Book requestedBook = null; //Temporary variable for a book
		for (Book tempBook : bookShelf) {
			if (tempBook.getISBN() == ISBNNumber) { //Looks through the bookShelf for a book with the ISBN number requested by the user
				requestedBook = tempBook;
				break;
			}
		}
		return requestedBook;
	}
	/**
	 * Simple method to grab the total size of the bookshelf
	 * @return Total amount of books in the bookshelf
	 */
	public int numBooks() {
		return bookShelf.size();
	}
	/**
	 * Simple method to grab the ArrayList of books
	 * @return The whole ArrayList of Books in a bookshelf object
	 */
	public ArrayList<Book> getBookList() {
		return bookShelf;
	}
	/**
	 * Verify whether or not a ISBN number is valid
	 * @param ISBN ISBN number inputed by the user
	 * @return True or false depending on what the ISBN is correct or not
	 */
	public boolean ISBNValid(int ISBN) {
		boolean valid = false;
		for (Book book : bookShelf) {
			if (book.getISBN() == ISBN) {
				valid = true;
			}
		}
		return valid;
	}
	
}
