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
    public User findByUserName(User user) {
        UserEntity userEntity = userRepository.findByUserName(user.getUserName());
        if (userEntity == null) {
            return null;
        }
        return userAdapter(userEntity);
    }
    

     @Override
     public boolean existUserName(String userName) {
         return userRepository.existsByUserName(userName);
     }

     @Override
     public void saveUser(User user) {
         UserEntity userEntity = userEntityAdapter(user);
                  userRepository.save(userEntity);
                  user.setUserDocument(userEntity.getUserDocument());
              }
         
            
         
   

     @Override
     public User findByPersonDocument(Person person) {
         
         PersonEntity personEntity = personAdapter(person);
         UserEntity userEntity = userRepository.findByPersonDocument(personEntity);
        User user = userAdapter(userEntity);
    
         return user;
     }

     private User userAdapter(UserEntity userEntity) {
         if (userEntity == null ) {
             return null;
            
         }
         User user = new User();
         user.setPersonId(userEntity.getPersonId().getPersonId());
         user.setDocument(userEntity.getPersonId().getDocument());
         user.setName(userEntity.getPersonId().getName());
         user.setRole(userEntity.getPerson().getRole());
         user.setUserName(userEntity.getUserName());
         user.setPassword(userEntity.getPassword());
         user.setUserId(userEntity.getUserId());
        return user;
    }

    private UserEntity userEntityAdapter(User user) {
        PersonEntity personEntity =  personAdapter(user);
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUserName());
        userEntity.setPassword(user.getPassword());
        userEntity.setPerson(personAdapter(user));
        return userEntity;
    } 
    
 }