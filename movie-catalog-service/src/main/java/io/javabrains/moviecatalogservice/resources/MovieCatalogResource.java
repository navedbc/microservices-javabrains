package io.javabrains.moviecatalogservice.resources;


import com.netflix.appinfo.InstanceInfo;
import io.javabrains.moviecatalogservice.model.CatalogItem;
import io.javabrains.moviecatalogservice.model.Movie;
import io.javabrains.moviecatalogservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import io.javabrains.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryService;




    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog (@PathVariable("userId") String userId) {




        List<Rating> ratings= Arrays.asList(new Rating("Transformer",7),
                new Rating("ddlj",9));

        UserRating userRating = restTemplate.getForObject("http://localhost:8083/ratingsdata/" + userId, UserRating.class);





        return userRating.getRatings().stream()
                .map(rating -> {

                    System.out.println("------->"+"http://movie-info-service/movies/" + rating.getMovieId());
                    Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
                })
                .collect(Collectors.toList());


    }


}
