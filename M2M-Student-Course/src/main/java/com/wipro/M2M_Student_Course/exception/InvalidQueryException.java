package com.wipro.M2M_Student_Course.exception;
public class InvalidQueryException extends RuntimeException{
    InvalidQueryException(){
    }
    InvalidQueryException(String message){
        super(message);
    }
    //here problem is that we use @COmponenet so jvm will try to create Object of CustomException
    //but we have param constructor then it is problematic so we write CustomException.
}
