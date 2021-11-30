package dropHere.searchengine.pagerepository;


import dropHere.searchengine.util.Date;

public class Review {

/*
+equals(Review): boolean
+toString(): String
+toPrintText(): String*/

    private static int count;

    private final int postId;
    private String title;
    private String content;
    private int rating;

    private Document reviewedDocument;
    private Author reviewer;
    private Date postDate;

    public Review(String title, String content, Date postDate, Author reviewer, Document reviewedDocument, int rating) {
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.reviewedDocument = reviewedDocument;
        this.reviewer = reviewer;
        this.postDate = postDate;

        postId = count;
        Review.count++;
    }

    public Review(String title, String content, Date postDate, Author reviewer, Document reviewedDocument) {
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.reviewedDocument = reviewedDocument;
        this.reviewer = reviewer;
        this.postDate = postDate;

        postId = count;
        Review.count++;
    }

    //region getters & setters:

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getRating() {
        return rating;
    }

    public Document getReviewedDocument() {
        return reviewedDocument;
    }

    public Author getReviewer() {
        return reviewer;
    }

    public Date getPostDate() {
        return postDate;
    }

    //endregion


    public boolean equals(Review other) {
        if (this == other) return true;
        if (other == null) return false;

        return postId == other.postId;
    }

    public String getAgeText() {
        return "Vor " + postDate.daysUntil(Date.today()) +" Tagen gepostet";
    }

    @Override
    public String toString() {
        return String.format("title: %s, rating: %s, description of reviewed document: %s", title, rating,
                reviewedDocument.getDescription());
    }

    public String toPrintText() {
        return String.format("%s\n%s\n%s\n%s\n%s\n%s", reviewedDocument.getDescription(), rating, title,
                content, postDate.toString(), reviewer.toString());
    }

    public static int numberOfCreatedReviews() {
        return count;
    }
}
