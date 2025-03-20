package app.domain.models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class User extends Person {
    private long userDocument;
    private String role;
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String userName, String password, long document, String name, String role, int age) {
        super(document, name, role, age);
        this.userName = userName;
        this.password = password;
    }

    public void setUserDocument(Object userDocument) {
        
        
    }


  

  
}
