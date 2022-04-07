package md.oop.store.book;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    List<Book> books = List.of(
            new Book(1L, "book1", "author1", 235),
            new Book(1L, "book2", "author2", 500)
    );

    public List<Book> findAll() {
        return books;
    }

    public Book findById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
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
