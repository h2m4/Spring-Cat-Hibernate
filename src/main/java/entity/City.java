package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class City {
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    @Column (name = "id")
    private long id;
    @Basic
    @Column (name = "name")
    private String name;
    @OneToMany (mappedBy = "city")
    private Collection<Cat> catsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Collection<Cat> getCatsById() {
        return catsById;
    }

    public void setCatsById(Collection<Cat> catsById) {
        this.catsById = catsById;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", catsById=" + catsById +
                '}';
    }
}
