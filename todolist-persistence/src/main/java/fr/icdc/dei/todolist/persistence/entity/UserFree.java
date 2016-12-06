package fr.icdc.dei.todolist.persistence.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("USER_FREE")
public class UserFree extends User{

}
