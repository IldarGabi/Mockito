package ru.neetologyRepository;

import org.junit.jupiter.api.BeforeEach;
import ru.netology.PosterManager;
import ru.netology.UpdatePoster;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class PosterRepositoryTest {
    PosterRepository repository = new PosterRepository();
    UpdatePoster movie1 = new UpdatePoster(1, 1);
    UpdatePoster movie2 = new UpdatePoster(1, 2);
    UpdatePoster movie3 = new UpdatePoster(1, 3);
    UpdatePoster movie4 = new UpdatePoster(1, 4);
    UpdatePoster movie5 = new UpdatePoster(1, 5);
    UpdatePoster movie6 = new UpdatePoster(1, 6);
    UpdatePoster movie7 = new UpdatePoster(1, 7);
    UpdatePoster movie8 = new UpdatePoster(1, 8);
    UpdatePoster movie9 = new UpdatePoster(1, 9);
    UpdatePoster movie10 = new UpdatePoster(1, 10);
    UpdatePoster movie11 = new UpdatePoster(1, 11);

    @BeforeEach
    private void assignValue() {
        repository.save(movie1);
        repository.save(movie2);
        repository.save(movie3);
        repository.save(movie4);
        repository.save(movie5);
        repository.save(movie6);
        repository.save(movie7);
        repository.save(movie8);
        repository.save(movie9);
        repository.save(movie10);
        repository.save(movie11);
    }

    @Test
    void shouldFindAllAndSaveMovie() {
        UpdatePoster[] actual = repository.findAll();
        UpdatePoster[] expected = new UpdatePoster[]{movie1, movie2, movie3, movie4, movie5, movie6, movie7,movie8, movie9, movie10, movie11};
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }

    @Test
    void shouldFindByIdMovie() {
        UpdatePoster actual = repository.findById(11);
        UpdatePoster expected = movie11;
        assertEquals(expected, actual);
        System.out.println(actual);
    }


    @Test
    void shouldNotFindByIdMovie() {
        UpdatePoster actual = repository.findById(333464);
        assertNull(actual);
    }

    @Test
    void removeByIdMovie() {
        repository.removeById(8);
        UpdatePoster[] actual = repository.findAll();
        UpdatePoster[] expected = new UpdatePoster[]{movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie9, movie10, movie11};
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }

    @Test
    void shouldRemoveAllMovie() {
        repository.removeAll();
        UpdatePoster[] actual = repository.findAll();
        UpdatePoster[] expected = new UpdatePoster[0];
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }
}
