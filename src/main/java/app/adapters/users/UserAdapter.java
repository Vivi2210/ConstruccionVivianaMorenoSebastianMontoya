 package app.adapters.users;

 import org.springframework.stereotype.Service;
 import org.springframework.beans.factory.annotation.Autowired;

 import app.adapters.persons.entity.PersonEntity;
 import app.adapters.users.entity.UserEntity;
 import app.adapters.users.repository.UserRepository;
 import app.domain.models.Person;
 import app.domain.models.User;
 import app.ports.UserPort;
 import lombok.Getter;
 import lombok.Setter;
 import lombok.NoArgsConstructor;

 @Setter
 @Getter
 @NoArgsConstructor
 @Service


 public class UserAdapter implements UserPort {
     @Autowired
     private UserRepository userRepository;

     @Override
     public boolean existUserName(String userName) {
         return userRepository.existsByUserName(userName);
     }

     @Override
     public void saveUser(User user) {
         UserEntity userEntity = userAdapter(user);
         userRepository.save(userEntity);
         user.setUserName(userEntity.getUserName());
     }

     @Override
     public User findByUserName(String username) {
         UserEntity userEntity = userRepository.findByUserName(username);
         if (userEntity == null) {
             return null;
            
         }
         return userAdapter(userEntity);
     }

     @Override
     public User findByPersonDocument(Person person) {
         
         UserEntity userEntity = userRepository.findByPersonDocument(person);
    
         if (userEntity == null) {
             return null;
         }
         return userAdapter(userEntity);
     }

     private User userAdapter(UserEntity userEntity) {
         if (userEntity == null ) {
             return null;
            
         }
         User user = new User();
        
         user.setDocument(userEntity.getPerson().getDocument());
         user.setName(userEntity.getPerson().getName());
         user.setRole(userEntity.getPerson().getRole());
         user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        return user;
    }
    
 }