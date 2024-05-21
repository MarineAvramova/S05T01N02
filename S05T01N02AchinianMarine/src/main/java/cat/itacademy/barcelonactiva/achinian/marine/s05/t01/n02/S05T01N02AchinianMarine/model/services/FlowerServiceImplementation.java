package cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.services;

import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.mapper.FlowerMapper;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.domain.Flower;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class FlowerServiceImplementation implements FlowerService{
    @Autowired
    private FlowerRepository flowerRepository;
    @Autowired
    private FlowerMapper flowerMapper;

    @Override
    public FlowerDTO createFlower(FlowerDTO flowerDTO) {
        Flower flower = flowerMapper.mapToFlower(flowerDTO);
        Flower savedFlower = flowerRepository.save(flower);
        return flowerMapper.mapToFlowerDTO(savedFlower);
    }

    @Override
    public Optional<FlowerDTO> getFlowerById(Integer pk_FlowerId) {
        return flowerRepository.findById(pk_FlowerId)
                .map(flowerMapper::mapToFlowerDTO);
    }

    @Override
    public List<FlowerDTO> getAllFlowers() {
        List<Flower>flowers = flowerRepository.findAll();
        return flowers.stream().map(flowerMapper::mapToFlowerDTO)
                .collect(Collectors.toList());
    }
    @Override
    public FlowerDTO updateFlower(FlowerDTO flower) {
        Flower optionalFlower = flowerRepository.findById(flower.getPk_FlowerId()).orElseThrow();
        optionalFlower.setNameFlower(flower.getNameFlower());
        optionalFlower.setCountryFlower(flower.getCountryFlower());
        flowerRepository.save(optionalFlower);
        return flowerMapper.mapToFlowerDTO(optionalFlower);
    }

    @Override
    public void deleteFlower(Integer pk_FlowerId) {
        flowerRepository.deleteById(pk_FlowerId);
    }
}
