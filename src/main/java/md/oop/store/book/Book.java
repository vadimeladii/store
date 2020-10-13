package md.oop.store.book;

public class Book {

    private Long id;
    private String name;
    private String author;
    private Integer nrPage;

    public Book(Long id, String name, String author, Integer nrPage) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.nrPage = nrPage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNrPage() {
        return nrPage;
    }

    public void setNrPage(Integer nrPage) {
        this.nrPage = nrPage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", nrPage=" + nrPage +
                '}';
    }
}
