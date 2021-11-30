package dropHere.searchengine.pagerepository;


import dropHere.searchengine.util.Date;

public class Document {

    /*-documentId: int


+toString(): String
Document: Den Titel und das Veröffentlichungsdatum sowie eine kurze Beschreibung des Autors
+toPrintText(): String*/

    private static int count = 0;

    private final int documentId;

    private String title;
    private String description;
    private String content;
    private final Date releaseDate;
    private Date lastUpdateDate;
    private Author author;

    public Document(String title, String description, String content, Date releaseDate, Author author) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.releaseDate = releaseDate;
        this.lastUpdateDate = releaseDate;
        this.author = author;

        documentId = Document.count;
        Document.count++;
    }

    public void setTitle(String title) {
        this.title = title;
        this.setLastUpdateDate(Date.today());
    }

    public void setDescription(String description) {
        this.description = description;
        this.setLastUpdateDate(Date.today());
    }

    public void setContent(String content) {
        this.content = content;
        this.setLastUpdateDate(Date.today());
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public void setAuthor(Author author) {
        this.author = author; // maybe the document was copied by another author
        this.setLastUpdateDate(Date.today());
    }

    public int getDocumentId() {
        return documentId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return String.format("%s %s %s", title, releaseDate,author);
    }

    public String getContent() {
        return content;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public Author getAuthor() {
        return author;
    }

    public int yearsSinceRelease() {
        return this.releaseDate.yearsUntil(Date.today());
    }

    public int daysSinceLastUpdate() {
        return lastUpdateDate.daysUntil(Date.today());
    }

    public boolean equals(Document other) {
        if (this == other) return true;
        if (other == null) return false;

        return documentId == other.documentId;
    }

    @Override
    public String toString() {
        return String.format("title: %s, release Date: %s, author: %s", title, releaseDate, author);
    }

    public String toPrintText() {
        return String.format("title: %s\nauthor: %s\ndescription: %s\nlast updated: %s", title, author, description, lastUpdateDate);
    }

    public static int numberOfCreatedDocuments() {
        return count;
    }
}
