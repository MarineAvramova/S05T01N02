package cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.controllers;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.services.FlowerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController // meaning it is ready for use by Spring MVC to handle web requests.
@RequestMapping("/flower")
public class FlowerController {

    @Autowired
    private FlowerService flowerService;


//    @Operation(summary = "This method is creating a new flower.")
//    @GetMapping({"/",""})
//    public String index(){
//        return "Connected.";
//    }
    @Operation(summary = "This method is creating a new flower.")
    @PostMapping("/add")
    public ResponseEntity<FlowerDTO> addFlower(@RequestBody FlowerDTO flowerDTO) {
        FlowerDTO createdFlower = flowerService.createFlower(flowerDTO);
        return new ResponseEntity<>(createdFlower, HttpStatus.CREATED);
    }
    @Operation(summary = "This method is updating existing flower.")
    @PutMapping("/update")
    public ResponseEntity<FlowerDTO> updateFlower(@RequestBody FlowerDTO flowerDTO) {
        FlowerDTO updatedFlower = flowerService.updateFlower(flowerDTO);
        return ResponseEntity.ok(updatedFlower);
    }
    @Operation(summary = "This method is deleting existing flower.")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteFlower(@PathVariable("id") Integer id) {
        flowerService.getFlowerById(id);
        return new ResponseEntity<>("Flower successfully deleted!", HttpStatus.OK);
    }
    @Operation(summary = "This method is showing flower by id")
    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlowerDTO> getFlowerById(@PathVariable Integer id) {
        FlowerDTO flowerDTO = flowerService.getFlowerById(id);
        return ResponseEntity.ok(flowerDTO);
    }
    @Operation(summary = "This method is showing all flower.")
    @GetMapping("/getAll")
    public ResponseEntity<List<FlowerDTO>> getAllFlowers() {
        List<FlowerDTO> flowers = flowerService.getAllFlowers();
        return ResponseEntity.ok(flowers);
    }
}
