package ru.netology;

import ru.neetologyRepository.PosterRepository;

public class PosterManager {
   PosterRepository repository;
    int countMovie = 10;

//    public PosterManager(PosterRepository repository) {
//        this.repository = repository;
//    }

    public PosterManager(PosterRepository repository, int countMovie) {
        this.repository = repository;
        if (countMovie != 10) {
            this.countMovie = countMovie;
        }
    }

    public void add(UpdatePoster movie) {
        repository.save(movie);
    }

    public UpdatePoster[] getAll() {
        return repository.findAll();
    }
}
