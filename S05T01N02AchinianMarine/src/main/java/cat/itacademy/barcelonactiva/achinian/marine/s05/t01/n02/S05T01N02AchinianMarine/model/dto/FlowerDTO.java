package cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.dto;

public class FlowerDTO {

    private Integer pk_FlowerId;
    private String nameFlower;
    private String countryFlower;
    private String flowerType;

    public FlowerDTO() {
    }

    public FlowerDTO(Integer pk_FlowerId, String nameFlower, String countryFlower, String flowerType) {
        this.pk_FlowerId = pk_FlowerId;
        this.nameFlower = nameFlower;
        this.countryFlower = countryFlower;
        this.flowerType = checkCountry();
    }

    public Integer getPk_FlowerId() {
        return pk_FlowerId;
    }

    public void setPk_FlowerId(Integer pk_FlowerId) {
        this.pk_FlowerId = pk_FlowerId;
    }

    public String getNameFlower() {
        return nameFlower;
    }

    public void setNameFlower(String nameFlower) {
        this.nameFlower = nameFlower;
    }

    public String getCountryFlower() {
        return countryFlower;
    }

    public void setCountryFlower(String countryFlower) {
        this.countryFlower = countryFlower;
        this.flowerType = checkCountry();
    }

    public String getFlowerType() {
        return flowerType;
    }

    private String checkCountry() {
        if (EUCountries.isEUCountry(this.countryFlower)) {
            return "EU";
        } else {
            return "Non-EU";
        }
    }
}
