package cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.services;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.domain.Flower;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.dto.FlowerDTO;
import java.util.List;
import java.util.Optional;

public interface FlowerService {
    FlowerDTO createFlower(FlowerDTO flowerDTO);
    Optional<FlowerDTO> getFlowerById(Integer pk_FlowerId);
    List<FlowerDTO> getAllFlowers();
    FlowerDTO updateFlower(FlowerDTO flower);
    void deleteFlower(Integer pk_FlowerId);
}
