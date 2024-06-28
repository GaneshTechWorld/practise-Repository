package com.demo.M2M_Actor_Movie.mapping;

import com.demo.M2M_Actor_Movie.dto.ActorRequest;
import com.demo.M2M_Actor_Movie.dto.MovieRequest;
import com.demo.M2M_Actor_Movie.dto.MovieResponse;
import com.demo.M2M_Actor_Movie.entity.Actor;
import com.demo.M2M_Actor_Movie.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
    @Mapping(source = "movieTitle",target = "movieTitle")
    @Mapping(source = "movieDescription",target = "movieDescription")
    @Mapping(source = "movieBudget",target = "movieBudget")
    @Mapping(source = "movieProducer",target = "movieProducer")
    @Mapping(source = "movieDirector",target = "movieDirector")
    @Mapping(source = "movieReleaseDate",target = "movieReleaseDate")
    Movie movieRequestToMovieEntityMapping(MovieRequest movieRequest);

    @Mapping(source = "movieTitle",target = "movieTitle")
    @Mapping(source = "movieDescription",target = "movieDescription")
    @Mapping(source = "movieBudget",target = "movieBudget")
    @Mapping(source = "movieProducer",target = "movieProducer")
    @Mapping(source = "movieDirector",target = "movieDirector")
    @Mapping(source = "movieReleaseDate",target = "movieReleaseDate")
    MovieResponse movieEntityTOMovieResponseMapping(Movie movie);

}
