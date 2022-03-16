package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQuery(name="Cat.byCity", query = "select c from Cat c where c.city.name=?1")
public class Cat {
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    @Column (name = "id")
    private long id;
    @Basic
    @Column (name = "name")
    private String name;
    @Basic
    @Column (name = "gender")
    private String gender;
    @Basic
    @Column (name = "fur")
    private String fur;
    @Basic
    @Column (name = "cityId")
    private Long cityId;
    @ManyToOne
    @JoinColumn (name = "cityId", referencedColumnName = "id", insertable = false, updatable = false)
    private City city;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFur() {
        return fur;
    }

    public void setFur(String fur) {
        this.fur = fur;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return id == cat.id && Objects.equals(name, cat.name) && Objects.equals(gender, cat.gender) && Objects.equals(fur, cat.fur) && Objects.equals(cityId, cat.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, fur, cityId);
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", fur='" + fur + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
