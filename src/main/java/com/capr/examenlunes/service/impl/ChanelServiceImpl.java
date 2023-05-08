package com.capr.examenlunes.service.impl;

import com.capr.examenlunes.dto.ChanelDTO;
import com.capr.examenlunes.model.Chanel;
import com.capr.examenlunes.repository.ChanelRepository;
import com.capr.examenlunes.service.ChanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ChanelServiceImpl implements ChanelService {
    @Autowired
    private ChanelRepository chanelRepository;

    @Override
    public List<Chanel> getChanels() {
        List<Chanel> chanels = chanelRepository.findAll();
        return chanels;
    }

    @Override
    public Chanel getChanelById(String id) {
        Optional<Chanel> chanelOptional = chanelRepository.findById(id);
        Chanel chanel = chanelOptional.get();
        return chanel;
    }

    @Override
    public Chanel createdChanel(ChanelDTO chanelDTO) {
        Chanel chanel = new Chanel(chanelDTO);
        return chanelRepository.save(chanel);
    }
}
