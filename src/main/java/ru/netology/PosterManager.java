package ru.netology;

public class PosterManager {
    private UpdatePoster[] movies = new UpdatePoster[0];
    int countMovie = 10;

    public PosterManager() {
    }

    public PosterManager(int countMovie) {
        if (countMovie >= 0) {
            this.countMovie = countMovie;
        }
    }

    public void add(UpdatePoster movie) {
        int length = movies.length + 1;
        UpdatePoster[] tmp = new UpdatePoster[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public void removeById(int id) {
        UpdatePoster[] tmp = new UpdatePoster[movies.length - 1];
        int index = 0;
        for (UpdatePoster movie : movies) {
            if (movie.getMovieId() != id) {
                tmp[index] = movie;
                index++;
            }
            movies = tmp;
        }
    }

    public void removeByNoId(int id) {
        for (UpdatePoster movie : movies) {
            if (id != movie.getMovieId()) {
                return;
            }
        }
    }

    public UpdatePoster[] getAll() {
        UpdatePoster[] result = new UpdatePoster[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
