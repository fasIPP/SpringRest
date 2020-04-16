package estg.ipp.restarticles;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    private final ArticleRepository repository;

    public ArticleController(ArticleRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/articles")
    List<Article> all() {
        return repository.findAll();
    }

    @PostMapping("/articles")
    Article newEmployee(@RequestBody Article newEmployee) {
        return repository.save(newEmployee);
    }

    // Single item
    @GetMapping("/articles/{id}")
    Article one(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PutMapping("/articles/{id}")
    Article replaceArticle(@RequestBody Article newArticle, @PathVariable Long id) {

        Article a = repository.findById(id).get();
        if (a!=null) {
            a.setTitle(newArticle.getTitle());
            a.setDescription(newArticle.getDescription());
        }
        else {

            a = repository.save(newArticle);
        }
        return a;
    }

    @DeleteMapping("/articles/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }




}
