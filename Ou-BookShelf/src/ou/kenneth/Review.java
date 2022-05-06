package ou.kenneth;

/**
 * New object class containing user's name 
 * and feedback on a Book
 * @author Kenneth Ou
 * @date March 23, 2022
 */
public class Review {
	
	private String nameOfReviewer;//Name of reviewer
	private String comment;//User comments
	private int rating;//Book rating
	/**
	 * Simple constructor which takes user input and creates a new Review 
	 * @param criticism User written feedback
	 * @param starRating User rating of the book
	 * @param reviewerName Name of the User
	 */
	Review(String  criticism, int starRating, String reviewerName) {
		rating = starRating;
		comment = criticism;
		nameOfReviewer = reviewerName;
	}
	/**
	 * Simple method to return the rating of a book
	 * @return The rating of a book
	 */
	public int getRating() {
		return rating;
	}
	@Override 
	/**
	 * This overrides the built in .toString method found in String 
	 * allowing the system to print out the information a review has
	 */
	public String toString() {
		return String.format("[" + nameOfReviewer + "]"+ "\nRating: " + rating + "\n" + comment);
	}
	
}
