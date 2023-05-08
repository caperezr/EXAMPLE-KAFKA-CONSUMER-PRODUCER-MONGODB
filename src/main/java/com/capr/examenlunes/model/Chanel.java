package com.capr.examenlunes.model;

import com.capr.examenlunes.dto.ChanelDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Chanel {
    @Id
    private String id;
    private String name;
    private int subscribers;
    private List<User> subscribersList;
    public Chanel(ChanelDTO chanelDTO) {
        this.name = chanelDTO.getName();
        this.subscribers = chanelDTO.getSubscribers();
    }
}
