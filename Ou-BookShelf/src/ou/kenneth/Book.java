package ou.kenneth;

import java.util.ArrayList;
/**
 * A new Object class containing: author name, ISBN number, 
 * average rating, and a empty ArrayList of Review objects 
 * to store reviews and is able to add new Review objects
 * @author Kenneth Ou
 * @date March 23, 2022
 */
public class Book implements Comparable<Book> {
	
	private String name; 
	private int ISBN;
	private String author;
	private ArrayList<Review> reviews;
	private double average = 0;
	/**
	 * Simple Constructor which creates new Book 
	 * Objects using user inputed information
	 * @param title Name/Title of the book
	 * @param ISBNNumber ISBN ID of the book
	 * @param writer Name of the author
	 */
	Book(String title, int ISBNNumber, String writer) {
		name = title;
		ISBN = ISBNNumber;
		author = writer;
		reviews = new ArrayList<>();
	}
	/**
	 * This method adds Review objects to 
	 * the ArrayList of Reviews found in each book
	 * @param review A review object with reviewer name, rating, and comments on the book
	 */
	public void addReview(Review review) {
		reviews.add(review);
	}
	/**
	 * Method which returns the ISBN number of a book
	 * @return ISBN number of the book
	 */
	public int getISBN() {
		return ISBN;
	}
	/**
	 * Method which returns the Name/Title of a book
	 * @return The name of the Book
	 */
	public String getName() {
		return name;
	}
	/**
	 * Method which returns the list of reviews found on a book
	 * @return ArrayList of Reviews in a book
	 */
	public ArrayList<Review> getListOfReviews() {
		return reviews;
	}
	/**
	 * Simple method which displays all of the review present in a book
	 * @param newBookShelf A BookShelf Object which contains all of the books
	 */
	public void displayAllReviews(BookShelf newBookShelf) {
		System.out.println("Displaying reviews for: " + newBookShelf.getBookUsingISBN(ISBN).reviewFormat() + "\nAverage rating: " + newBookShelf.getBookUsingISBN(ISBN).calculateRateAverage() + "\n**********************************");
		for (Review tempReview :newBookShelf.getBookUsingISBN(ISBN).getListOfReviews()) {
			System.out.println(tempReview.toString());
		}
	}
	/**
	 * Simple method to calculate the average rating of a book
	 * @return The average rating of the book
	 */
	public String calculateRateAverage() {
		int total = 0;
		int totalReviews = 0;
		for (Review tempReview : reviews) {
			total += tempReview.getRating();
			totalReviews++;
		}
		average = (double) total/totalReviews;
		return String.format("%.2f", average); //Rounds the average
	}
	/**
	 * Simple method which displays all the information of a book
	 */
	public String reviewFormat() { //Made specifically for when reviews are being displayed
		return String.format("\"" + name + "\" By: " + author );
	}
	
	@Override
	/**
	 * Simple method which overrides toString to print out all information in a book
	 */
	public String toString() { //Displays all the information the book has
		return String.format("ISBN: " + ISBN + " Author: " + author + " Title: " + name);
	}
	/**
	 * This method enables the sorting of Book objects using ISBN number
	 */
	public int compareTo(Book oneBook) { //enables sorting for Book objects
			
		if (getISBN() < oneBook.getISBN()) {
			return -1;
		}
		
		else if (getISBN() > oneBook.getISBN()) {
			return 1;
		}
		
		return 0;
	}
}
