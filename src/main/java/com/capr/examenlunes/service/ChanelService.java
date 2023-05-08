package com.capr.examenlunes.service;

import com.capr.examenlunes.dto.ChanelDTO;
import com.capr.examenlunes.model.Chanel;

import java.util.List;

public interface ChanelService {
    List<Chanel> getChanels();
    Chanel getChanelById(String id);
    Chanel createdChanel(ChanelDTO chanelDTO);
}
