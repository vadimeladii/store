package md.oop.store.book;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookRepository {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    List<Book> books = new ArrayList<>(List.of(
            new Book(1L, "book1", "author1", 235),
            new Book(2L, "book2", "author2", 500),
            new Book(3L, "book3", "author3", 350)));

    public List<Book> findAll() {
        return books;
    }

    public Book findById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    public void save(Book book) {
        books.add(book);
    }

    public void delete(String name) {
        List<Book> toRemove = books.stream().filter(book -> book.getName().equals(name)).collect(Collectors.toList());
        books.removeAll(toRemove);
    }

    public void update(Long id, Book book) {
        books.stream().filter(b -> b.getId().equals(id)).findFirst().ifPresent(b -> {
            b.setAuthor(book.getAuthor());
            b.setName(book.getName());
            b.setNrPage(book.getNrPage());
        });
    }

//    public List<Book> findAll() {
//        return jdbcTemplate.query(
//                "SELECT * FROM book",
//                (response, rowNumber) ->
//                        new Book(response.getLong("id"),
//                                response.getString("name"),
//                                response.getString("author"),
//                                response.getInt("nrPage")));
//    }
//
//    public Book findById(Long id) {
//        return jdbcTemplate.queryForObject(
//                "SELECT * FROM book WHERE id = ?",
//                new Object[]{id},
//                (response, rowNumber) ->
//                        new Book(response.getLong("id"),
//                                response.getString("name"),
//                                response.getString("author"),
//                                response.getInt("nrPage")));
//    }
//
//    public void save(Book book) {
//        jdbcTemplate.update(
//                "INSERT INTO book(name, author, nrPage) VALUES (?, ?, ?)",
//                book.getName(), book.getAuthor(), book.getNrPage());
//    }
//
//    public void delete(String name) {
//        jdbcTemplate.update("DELETE FROM book Where name = ?", name);
//    }
//
//    public void update(Long id, Book book) {
//        jdbcTemplate.update("UPDATE book SET name = ? , author = ?, nrPage = ? WHERE id = ?",
//                book.getName(), book.getAuthor(), book.getNrPage(), id);
//    }
}
