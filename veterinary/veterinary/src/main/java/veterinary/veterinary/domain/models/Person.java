
package veterinary.veterinary.domain.models;
import lombok.Setter;

@Stetter
@Getter
@NoArgsConstructor

public class Person {
    private long cedula;
    private String name;
    private int age;
    private String role;
    public Person(long cedula, String name, int age, String role) {
        super();
        this.cedula = cedula;
        this.name = name; 
        this.age = age; 
        this.role;
    }
    
    public long getCedula() {
        return cedula;
    }
    
    public void setCedula(long cedula) {
        this.cedula = cedula;
    }
    
    public String getName() {
       return name =name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
}
