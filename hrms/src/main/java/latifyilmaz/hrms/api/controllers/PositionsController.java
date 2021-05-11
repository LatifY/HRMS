package latifyilmaz.hrms.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import latifyilmaz.hrms.business.abstracts.PositionService;
import latifyilmaz.hrms.entities.concretes.Position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/positions")
public class PositionsController {
    private PositionService positionService;
    ObjectMapper mapObject = new ObjectMapper();

    @Autowired
    public PositionsController(PositionService positionService){
        super();
        this.positionService = positionService;
    }

    //Get All
    @GetMapping("")
    public List<Position> getAll()  {
        return this.positionService.getAll();
    }

    //Get By Id
    @GetMapping("/{id}")
    public Map getById(@PathVariable(value = "id") int id){
        Optional<Position> position = this.positionService.getById(id);
        return mapObject.convertValue(position, Map.class);
    }


    //Save
    @PostMapping("")
    public Map save(@RequestBody Position newPosition){
        this.positionService.save(newPosition);
        return mapObject.convertValue(newPosition, Map.class);
    }

    //Delete
    @DeleteMapping("/{id}")
    public Map delete(@PathVariable(value = "id") int id){
        Optional<Position> optionalPosition = this.positionService.getById(id);
        Position position = optionalPosition.get();
        this.positionService.delete(position);
        return mapObject.convertValue(position, Map.class);
    }


}
