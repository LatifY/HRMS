package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.PositionService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.entities.concretes.Position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
@CrossOrigin
public class PositionsController {
    private PositionService positionService;

    @Autowired
    public PositionsController(PositionService positionService){
        super();
        this.positionService = positionService;
    }

    //Get
    @GetMapping("")
    public DataResult<List<Position>> getAll()  {
        return this.positionService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<Position> getById(@PathVariable(value = "id") int id){
        return this.positionService.getById(id);
    }

    //Save
    @PostMapping("")
    public DataResult<Position> save(@RequestParam String positionName){
        return this.positionService.save(new Position(positionName));
    }

    //Delete
    @DeleteMapping("")
    public DataResult<Position> delete(@RequestBody Position position){
        return this.positionService.delete(position);
    }

    @DeleteMapping("/{id}")
    public DataResult<Integer> deleteById(@PathVariable(value = "id") int id){
        return this.positionService.deleteById(id);
    }


}
