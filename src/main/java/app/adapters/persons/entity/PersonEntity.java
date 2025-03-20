
package app.adapters.persons.entity;

import app.domain.models.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name ="person")
@Setter
@Getter
@NoArgsConstructor
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name="document")
    private long document;
    @Column (name= "name")
    private String name;
    @Column(name = "role")
    private String role;
    @Column(name = "age")
    private int age;
    public long getPersonDocument() {
        return getDocument();
    }

/* 
    public long getDocument() {
        return document;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getAge() {
        return age;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    */
}
