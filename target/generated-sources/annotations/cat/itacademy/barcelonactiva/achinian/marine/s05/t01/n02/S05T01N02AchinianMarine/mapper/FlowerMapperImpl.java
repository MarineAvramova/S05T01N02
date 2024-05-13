package cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.mapper;

import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.domain.Flower;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.dto.FlowerDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-11T20:41:03+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class FlowerMapperImpl implements FlowerMapper {

    @Override
    public FlowerDTO flowerToFlowerDTO(Flower flower) {
        if ( flower == null ) {
            return null;
        }

        FlowerDTO flowerDTO = new FlowerDTO();

        flowerDTO.setPk_FlowerId( flower.getPk_FlowerId() );
        flowerDTO.setNameFlower( flower.getNameFlower() );
        flowerDTO.setCountryFlower( flower.getCountryFlower() );

        return flowerDTO;
    }

    @Override
    public Flower flowerDTOToFlower(FlowerDTO flowerDTO) {
        if ( flowerDTO == null ) {
            return null;
        }

        Flower flower = new Flower();

        flower.setPk_FlowerId( flowerDTO.getPk_FlowerId() );
        flower.setNameFlower( flowerDTO.getNameFlower() );
        flower.setCountryFlower( flowerDTO.getCountryFlower() );

        return flower;
    }
}
