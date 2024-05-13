package cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.services;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.dto.FlowerDTO;
import java.util.List;

public interface FlowerService {
    FlowerDTO createFlower(FlowerDTO flowerDTO);
    FlowerDTO getFlowerById(Integer pk_FlowerId);
    List<FlowerDTO> getAllFlowers();
    FlowerDTO updateFlower(FlowerDTO flowerDTO);
    void deleteFlower(Integer pk_FlowerId);
}
