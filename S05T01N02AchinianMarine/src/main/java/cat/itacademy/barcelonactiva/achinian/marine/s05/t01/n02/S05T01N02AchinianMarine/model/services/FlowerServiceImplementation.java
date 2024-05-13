package cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.services;

import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.mapper.FlowerMapper;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.domain.Flower;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class FlowerServiceImplementation implements FlowerService{
    @Autowired
    private FlowerRepository flowerRepository;
    @Autowired
    private FlowerMapper flowerMapper;

    @Override
    public FlowerDTO createFlower(FlowerDTO flowerDTO) {
        Flower flower = flowerMapper.flowerDTOToFlower(flowerDTO);
        Flower savedFlower = flowerRepository.save(flower);
        return flowerMapper.flowerToFlowerDTO(savedFlower);
    }

    @Override
    public FlowerDTO getFlowerById(Integer pk_FlowerId) {
        Flower flower = flowerRepository.findById(pk_FlowerId).get();
        return flowerMapper.flowerToFlowerDTO(flower);
    }

    @Override
    public List<FlowerDTO> getAllFlowers() {
        List<Flower>flowers = flowerRepository.findAll();
        return flowers.stream().map(flowerMapper::flowerToFlowerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FlowerDTO updateFlower(FlowerDTO flowerDTO) {
        Flower existingFlower = flowerRepository.findById(flowerDTO.getPk_FlowerId()).get();
        existingFlower.setNameFlower(flowerDTO.getNameFlower());
        existingFlower.setCountryFlower(flowerDTO.getCountryFlower());
        Flower updatedFlower = flowerRepository.save(existingFlower);
        return flowerMapper.flowerToFlowerDTO(updatedFlower);
    }

    @Override
    public void deleteFlower(Integer pk_FlowerId) {
        flowerRepository.deleteById(pk_FlowerId);
    }
}
