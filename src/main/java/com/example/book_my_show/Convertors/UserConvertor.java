package com.example.book_my_show.Convertors;

import com.example.book_my_show.EntryDTOs.UserEntryDto;
import com.example.book_my_show.Models.User;

public class UserConvertor {

    //Static  is kept to avoid calling it via objects/instantances
    public static User convertDtoToEntity(UserEntryDto userEntryDto){

        User user = User.builder().age(userEntryDto.getAge()).address(userEntryDto.getAddress()).email(userEntryDto.getEmail())
                .name(userEntryDto.getName()).mobNo(userEntryDto.getMobNo()).build() ;

        return user ;
    }
}
