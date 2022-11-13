package com.example.contentDelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content
{
    @Id

    private int newsid;
    private String headline;
    private String main;
    private String keyword;

}
