package cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.controllers;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.exception.ResourceNotFoundException;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.domain.Flower;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.services.FlowerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // meaning it is ready for use by Spring MVC to handle web requests.
@RequestMapping("/flower")
public class FlowerController {

    @Autowired
    private FlowerService flowerService;

    @Operation(summary = "This method is creating a new flower.")
    @PostMapping("/add")
    public ResponseEntity<FlowerDTO> addFlower(@RequestBody FlowerDTO flowerDTO) {
        FlowerDTO newFlower = flowerService.createFlower(flowerDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(newFlower);
    }

    @Operation(summary = "This method is updating an existing flower.")
    @PutMapping("/update")
    public ResponseEntity<FlowerDTO> updateFlower(@RequestBody FlowerDTO flower) throws ResourceNotFoundException{

        FlowerDTO updatedFlower = flowerService.updateFlower(flower);
        return ResponseEntity.ok(updatedFlower);
    }

    @Operation(summary = "This method is deleting an existing flower.")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteFlower(@PathVariable("id") Integer id) {
        FlowerDTO flower = flowerService.getFlowerById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flower not found with id: " + id));

        flowerService.deleteFlower(id);
        return new ResponseEntity<>("Flower successfully deleted!", HttpStatus.OK);
    }

    @Operation(summary = "This method is showing flower by id")
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Optional<FlowerDTO>> getFlowerById(@PathVariable Integer id) {
        Optional<FlowerDTO> flower= flowerService.getFlowerById(id);
        return ResponseEntity.ok(flower);
    }

    @Operation(summary = "This method is showing all flowers.")
    @GetMapping("/getAll")
    public ResponseEntity<List<FlowerDTO>> getAllFlowers() {
        List<FlowerDTO> flowers = flowerService.getAllFlowers();
        return ResponseEntity.ok(flowers);
    }
}
