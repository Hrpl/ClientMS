package com.webapi.firstapi.models;

import jakarta.validation.constraints.NotEmpty;

public record User(

                   int id,
                   @NotEmpty
                   String name,
                   int age,
                   String Email,
                   String password){}
