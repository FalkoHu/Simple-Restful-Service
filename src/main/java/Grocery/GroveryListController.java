package Grocery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroveryListController {

    @Autowired
    GroceryListRepository groceryListRepository;

    @CrossOrigin("http://localhost:3000")
    @GetMapping(path = "/items")
    public @ResponseBody Iterable<Item> getAllItems(){
        return groceryListRepository.findAll();
    }

    @CrossOrigin("http://localhost:3000")
    @PostMapping(path = "/items")
    public void addItem(@RequestBody Item item){
        groceryListRepository.save(item);
    }

    @CrossOrigin("http://localhost:3000")
    @DeleteMapping(path = "/item{id}")
    public void deleteItem(@PathVariable("id") int id){
        groceryListRepository.deleteById(id);
    }
}