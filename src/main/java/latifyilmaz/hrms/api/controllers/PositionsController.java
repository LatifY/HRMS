package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.PositionService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Position;

import latifyilmaz.hrms.entities.dtos.position.PositionSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
@CrossOrigin
public class PositionsController {
    private final PositionService positionService;

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

    @GetMapping("/getByPositionName")
    public DataResult<Position> getByPositionName(@RequestParam(value = "positionName") String positionName){
        return this.positionService.getByPositionName(positionName);
    }

    //Save
    @PostMapping("")
    public Result save(@RequestBody PositionSaveDto position){
        return this.positionService.save(position);
    }

    //Delete
    @DeleteMapping("")
    public Result delete(@RequestBody Position position){
        return this.positionService.delete(position);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable(value = "id") int id){
        return this.positionService.deleteById(id);
    }


}
