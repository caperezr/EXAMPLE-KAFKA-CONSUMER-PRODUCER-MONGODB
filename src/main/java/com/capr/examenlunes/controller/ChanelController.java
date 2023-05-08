package com.capr.examenlunes.controller;

import com.capr.examenlunes.dto.ChanelDTO;
import com.capr.examenlunes.dto.UserDTO;
import com.capr.examenlunes.model.Chanel;
import com.capr.examenlunes.model.User;
import com.capr.examenlunes.service.ChanelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/chanels")
@RequiredArgsConstructor
public class ChanelController {
    @Autowired
    private ChanelService chanelService;

    @GetMapping
    public ResponseEntity<List<Chanel>> finfAllChanels() {
        try {
            List<Chanel> chanels = chanelService.getChanels();
            return ResponseEntity.status(HttpStatus.OK).body(chanels);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<Chanel> createdUser(@RequestBody ChanelDTO chanelDTO) {
        try {
            Chanel chanel = chanelService.createdChanel(chanelDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(chanel);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chanel> getChanelById(@PathVariable String id){
        try {
            Chanel chanel = chanelService.getChanelById(id);
            return ResponseEntity.status(HttpStatus.OK).body(chanel);
        }
        catch(Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }


}
