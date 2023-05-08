package com.capr.examenlunes.repository;

import com.capr.examenlunes.model.Chanel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChanelRepository extends MongoRepository<Chanel, String> {
}
