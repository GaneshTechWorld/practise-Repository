package com.demo.M2M_Actor_Movie.mapping;

import com.demo.M2M_Actor_Movie.dto.ActorRequest;
import com.demo.M2M_Actor_Movie.dto.ActorResponse;
import com.demo.M2M_Actor_Movie.entity.Actor;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActorMapper {
      ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);
      Actor actorRequestToActorEntityMapping(ActorRequest actorRequest);
      ActorResponse actorEntityToActorResponseMapping(Actor actor);
}

