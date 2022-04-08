package md.oop.store.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    @CrossOrigin
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public Book findById(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    @PostMapping
    @CrossOrigin
    public void save(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public void update(@PathVariable Long id, @RequestBody Book book) {
        bookRepository.update(id, book);
    }

    @DeleteMapping("/{name}")
    @CrossOrigin
    public void delete(@PathVariable String name) {
        bookRepository.delete(name);
    }
}
