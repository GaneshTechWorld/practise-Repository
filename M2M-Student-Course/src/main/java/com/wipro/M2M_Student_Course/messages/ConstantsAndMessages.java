package com.wipro.M2M_Student_Course.messages;

import org.springframework.beans.factory.annotation.Value;

public class ConstantsAndMessages {
    @Value("${messages.serverError}")
    private String  serverError;
}
