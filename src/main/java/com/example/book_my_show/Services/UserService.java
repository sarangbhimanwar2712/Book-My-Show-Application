package com.example.book_my_show.Services;

import com.example.book_my_show.Convertors.UserConvertor;
import com.example.book_my_show.EntryDTOs.UserEntryDto;
import com.example.book_my_show.Models.User;
import com.example.book_my_show.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository ;

    public String createUser(UserEntryDto userEntryDto) throws Exception{

        User user = UserConvertor.convertDtoToEntity(userEntryDto) ; //Calling method
        userRepository.save(user) ;
        return "User added successfully" ;

        //PURANE JAMANE KI METHOD

        //create a user object to store to db
//        User user = new User() ;
//
//        //Converting userEntryDto to user
//
//        user.setName(userEntryDto.getName());
//        user.setAge(userEntryDto.getAge());
//        user.setEmail(userEntryDto.getEmail());
//        user.setMobNo(userEntryDto.getMobNo());
//        user.setAddress(userEntryDto.getAddress());
//        //saving user to DB
//        userRepository.save(user) ;


        /*
        @BuilderAnnotation ---> help us to create object faster and have to write in entity/model layer
        1. write on top of that class whose obj has to be created
        2. always requires AllArgsConstructor(mandatory)

            //NAYE JAMANE KI METHOD
        */
        //This is to set all attributes in 1 go ---> CONVERTOR
//        User user = User.builder().age(userEntryDto.getAge()).name(userEntryDto.getName()).address(userEntryDto.getAddress())
//                .mobNo(userEntryDto.getMobNo()).email(userEntryDto.getEmail()).build() ;
//
//        userRepository.save(user) ;
//        return "User added successfully" ;
    }

}
