package cat.itacademy.barcelonactiva.achinian.marine.s05.t01.n02.S05T01N02AchinianMarine.model.domain;

import jakarta.persistence.*;

@Entity //This tells Hibernate to make a table out of this class
@Table(name = "flowers")
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk_FlowerId;

    @Column(name= "nameFlower")
    private String nameFlower;

    @Column(name= "countryFlower")
    private String countryFlower;

    public Flower() {
    }

    public Flower(Integer pk_FlowerId, String nameFlower, String countryFlower) {
        this.nameFlower = nameFlower;
        this.countryFlower = countryFlower;
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
    }
}
