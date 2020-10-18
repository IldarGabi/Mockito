package ru.netology;

public class PosterManager {
    private UpdatePoster[] movies = new UpdatePoster[0];
    int countMovie = 10;

    public PosterManager() {

    }

    public PosterManager(int countMovie) {
        if (countMovie != 10) {
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

    public UpdatePoster[] getAll() {
        UpdatePoster[] result = new UpdatePoster[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

}
