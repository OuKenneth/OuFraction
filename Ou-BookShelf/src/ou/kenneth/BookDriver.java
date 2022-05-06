package ou.kenneth;

import java.util.Scanner;
/**
 * This is a virtual library 
 * Which allows users to add books
 * to a bookshelf
 * along with adding reviews to 
 * the books in the bookshelf
 * @author Kenneth Ou
 * @date March 23, 2022
 */
public class BookDriver {
	/**
	 * Main Driver of the program, calls out the other methods in BookDriver
	 * @param args Unused.
	 * @return Nothing.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);//Declare a input variable for user input
		BookShelf newBookShelf = new BookShelf();//New Bookshelf object
		
		//Some HardCoded books within the Bookshelf
		//Book newBook = new Book("The man on the bridge", 1232, "Addison Du");
		//Book newBook2 = new Book("How To Heal Osteoporosis",1231, "Amy Cordaile");
		//newBookShelf.addBook(newBook2);
		//newBookShelf.addBook(newBook);
		//*******************************
		
		boolean quit = false;
		
		while (!quit) {
			//Menu System
			displayMenu();
			//Asks what the user wants to do
			int selection = robustInt(input, "Select an action", 6, "Selection out of range", newBookShelf);
			
			if (selection == 1) { //Display everything in the bookshelf
				if (newBookShelf.numBooks() != 0) {
					newBookShelf.displayAllBooks(selection);//Display all books in the bookshelf as of now and displays differently depending on which selection is inputed
					}
					else {
						System.out.println("There are no books in the bookshelf right now");
					}
				System.out.println();
			}
			
			else if (selection == 2) { //Create a new book object and add it to the bookshelf
				addBook(newBookShelf, input);//Takes care of book information and book creation
			}
			
			else if (selection == 3) { //Create a new review for a book and add it to a book 
				addBookReview(selection, newBookShelf, input);//Takes care of adding a review to a book chosen in the bookshelf		
			}
			
			else if (selection == 4) { //Remove a book from the bookshelf
				removeBook(input, newBookShelf, selection);//Takes care of removing a book
			}
			
			else if (selection == 5) { //Display reviews of a book in the bookshelf if there is any present
				if (newBookShelf.numBooks() != 0) {
				reviewDisplay(input, newBookShelf);
				}
				else {
					System.out.println("There are no books in the bookshelf right now");
				}
			}
			else if (selection == 6) {
				quit = true;
				System.out.println("Thank you for using this digital BookShelf\nBookShelf Closed");
			}
		}
	}
	
	/**
	 * Simple method that displays the menu
	 */
	private static void displayMenu() {
		System.out.println("***************Menu***************");
		System.out.println("Welcome To Your Digital Bookshelf!");
		System.out.println("1 - Display contents of the BookShelf");
		System.out.println("2 - Add a book");
		System.out.println("3 - Review a book");
		System.out.println("4 - Remove a book");
		System.out.println("5 - Display the reviews for a book");
		System.out.println("6 - Quit");
	}
	/**
	 * Method that asks the user for information for a book, creates a book, and adds it to a bookshelf
	 * @param newBookShelf BookShelf object that holds books
	 * @param input Scanner used for user input
	 */
	private static void addBook(BookShelf newBookShelf, Scanner input) { 
		String name = robustInput(input, "Please enter the title for Book");
		//Ask for author name
		String authorName = robustInput(input, "Please enter the name for author");
		//Ask for ISBN
		int ISBNNumber = robustInt(input, "Please enter a ISBN number", 21398239, "ISBN is invalid", newBookShelf);
		//Create new book and add it to the bookShelf
		newBookShelf.addBook(new Book(name, ISBNNumber, authorName));
		System.out.println("Your book as been added to the bookshelf");
	}
	/**
	 * This method is in charge of asking the user for information 
	 * in a review, creates a review, and adds review to the book chosen
	 * @param selection Option selected in menu
	 * @param newBookShelf BookShelf object that holds books
	 * @param input Scanner used for user input
	 */
	private static void addBookReview(int selection, BookShelf newBookShelf, Scanner input) {
		int indexInList = 0; //Declares a local variable to determine which book to add the review to
		String textReview = "[No comments]";//Default comment for reviews 
		
		newBookShelf.displayAllBooks(selection); //Calls a method in BookShelf to print out Book information
		indexInList = robustInt(input, "Pick a book from the list to review using number inputs", newBookShelf.numBooks(), "Invalid selection", newBookShelf);
		String reviewerName = robustInput(input, "Enter your name");//Ask for reviewer name
		int rating = robustInt(input, "Give the book a rating 1-5", 5, "Invalid rating", newBookShelf);//Ask for the rating
		int needReview = robustInt(input, "Would you like comment on the review?\n1 - Yes\n2 - No", 2, "Invalid selection", newBookShelf);
		
		if ((needReview == 1 )) {//Ask for the rating)
			textReview = robustInput(input, "Now write below your thoughts on this book (Leave blank if none)"); //Ask for user feedback on the book
			(newBookShelf.getBookList().get(indexInList - 1)).addReview(new Review(textReview, rating, reviewerName));//Create and add a new review
		}
		
		else {
			(newBookShelf.getBookList().get(indexInList - 1)).addReview(new Review(textReview, rating, reviewerName));//Create and add a new review
		}
		System.out.println("Your review has been recorded\n");
	}
	
	/**
	 * Simple method to prompt user for a book to remove and removes it from the bookshelf
	 * @param input Scanner used for user input
	 * @param newBookShelf BookShelf object that holds books
	 * @param selection Option selected in menu
	 */
	private static void removeBook(Scanner input, BookShelf newBookShelf, int selection) {
		boolean finished = false;
		int indexInList = 0; //Declares a local variable to determine which book to add the review to
		int confirm = 0; //Declares a local variable to store user feedback
		while(!finished) {
			newBookShelf.displayAllBooks(selection);
			indexInList = robustInt(input, "Pick a book to remove using number inputs", newBookShelf.numBooks(), "Selection out of range", newBookShelf);
			confirm = robustInt(input, "Are you sure you want to remove this book?\n" + newBookShelf.getBookList().get(indexInList - 1).toString() + "\n1 - Yes\n2 - No", 2, "Pick 1 or 2", newBookShelf);
			
			if (confirm == 1) {
				newBookShelf.removeBook(indexInList - 1);
				System.out.println("The book has been removed");
				finished = true;
			}
			
			else {
				break;
			}
		}
	}
	/**
	 * Simple method that asks the user for a specific book's ISBN to display it's list of reviews
	 * @param input Scanner object used for user input
	 * @param newBookShelf BookShelf Object
	 */
	private static void reviewDisplay(Scanner input, BookShelf newBookShelf) {
		boolean done = false;
		while (!done ) {
			int ISBN = robustInt(input, "**********************************\nPlease enter the ISBN for the book you wish to display reviews", 00, "ISBN is invalid", newBookShelf);
			
			if (newBookShelf.ISBNValid(ISBN)) {
				if (newBookShelf.getBookUsingISBN(ISBN).getListOfReviews().size() > 0) {
					newBookShelf.getBookUsingISBN(ISBN).displayAllReviews(newBookShelf);
				done = true;
				}
				else {
					System.out.println("This book does not have any reviews as of now");
					done = true;
				}
			}
			else {
				int option = robustInt(input, "ISBN not found, do you want to try again?\n1 - Yes\n2 - No", 2, "Invalid selection", newBookShelf);
				if (option == 2) {
					done = true;
				}
				else {
				}
			}
		}
		
	} 
	/**
	 * Simple method for user input (String) for names, titles, and other text based feedback
	 * @param input Scanner used for user input
	 * @param prompt Text which is used to prompt the user
	 * @return User input
	 */
	private static String robustInput(Scanner input, String prompt) {
		String newInput = "";
		System.out.println(prompt);
		
		if (input.hasNextLine()) {
			newInput = input.nextLine();
			
		}
		return newInput;		
	}
	/**
	 * Simple method which takes user input namely menu selections, book selections, and ISBN ID's for books
	 * @param input input Scanner used for user input
	 * @param prompt Text which is used to prompt the user
	 * @param max range of options allowed
	 * @param errorMessage Message that is displayed when user enters a option that is out of range of the "max"
	 * @return User's selected option or inputed ISBN number
	 */
	private static int robustInt(Scanner input, String prompt, int max, String errorMessage, BookShelf newBookShelf) {
		// Ask the user for initial amount to deposit
		boolean valid = false;
		int selection = 0;
		if (max == 00 | max == 21398239) {//Special cases for ISBN One for finding a book and the other is for adding a book
			while (!valid) {
				System.out.println(prompt);
				
				if (input.hasNextInt()) {
					selection = input.nextInt();
					
					if (selection > 9999999*1000000 || selection < 0) {//Checks if the ISBN is in range of 13 digits
						System.out.println(errorMessage);
					}
					else if (max == 21398239 && newBookShelf.ISBNValid(selection)){//Checks if the ISBN entered already exists #Special case made for when creating a book
						System.out.println("ISBN already exists");
					}
					else {
						valid = true;
					}
				}
				else {
					System.out.println(errorMessage);
				}
				input.nextLine(); // clear the buffer
			}
		}
		else {
			while (!valid) {
				System.out.println(prompt);
				if (input.hasNextInt()) {
					selection = input.nextInt();
					if (selection < 1 || selection > max) {
						System.out.println(errorMessage);
					} 
					else {
						valid = true;
					}
				} 
				else {
					System.out.println("Invalid input");
				}
				input.nextLine(); // clear the buffer
			}	
		}
		return selection;
	}
	
}


