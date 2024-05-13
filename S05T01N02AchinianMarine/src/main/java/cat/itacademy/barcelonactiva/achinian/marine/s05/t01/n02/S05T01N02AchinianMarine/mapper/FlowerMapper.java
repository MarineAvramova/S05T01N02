package cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.mapper;

import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.domain.Flower;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.dto.FlowerDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlowerMapper {
    FlowerDTO flowerToFlowerDTO(Flower flower);
    Flower flowerDTOToFlower(FlowerDTO flowerDTO);
}
