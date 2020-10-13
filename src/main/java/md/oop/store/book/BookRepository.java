package md.oop.store.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Book> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM book",
                (response, rowNumber) ->
                        new Book(response.getLong("id"),
                                response.getString("name"),
                                response.getString("author"),
                                response.getInt("nrPage")));
    }

    public Book findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM book WHERE id = ?",
                new Object[]{id},
                (response, rowNumber) ->
                        new Book(response.getLong("id"),
                                response.getString("name"),
                                response.getString("author"),
                                response.getInt("nrPage")));
    }

    public void save(Book book) {
        jdbcTemplate.update(
                "INSERT INTO book(name, author, nrPage) VALUES (?, ?, ?)",
                book.getName(), book.getAuthor(), book.getNrPage());
    }

    public void delete(String name) {
        jdbcTemplate.update("DELETE FROM book Where name = ?", name);
    }

    public void update(Long id, Book book) {
        jdbcTemplate.update("UPDATE book SET name = ? , author = ?, nrPage = ? WHERE id = ?",
                book.getName(), book.getAuthor(), book.getNrPage(), id);
    }
}
