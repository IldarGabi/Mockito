package ru.neetologyRepository;

import ru.netology.UpdatePoster;

public class PosterRepository {
    private UpdatePoster[] movies = new UpdatePoster[0];

//    возвращает массив всех хранящихся в массиве объектов
    public UpdatePoster[] findAll() {
        return movies;
    }

//    добавляет объект в массив
    public void save(UpdatePoster movie) {
        int length = movies.length + 1;
        UpdatePoster[] tmp = new UpdatePoster[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

//    возвращает объект по идентификатору (либо null, если такого объекта нет)
    public UpdatePoster findById(int id) {
        for (UpdatePoster movie : movies) {
            if (movie.getMovieId() == id) {
                return movie;
            }
        }
        return null;
    }
//    удаляет объект по идентификатору (если объекта нет, то пусть будет исключение, как на лекции)
    public void removeById(int id) {
        int length = movies.length - 1;
        UpdatePoster[] tmp = new UpdatePoster[length];
        int index = 0;
        for (UpdatePoster movie : movies) {
            if (movie.getMovieId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }
//    полностью вычищает репозиторий
    public void removeAll() {
        movies = new UpdatePoster[0];
    }
}
