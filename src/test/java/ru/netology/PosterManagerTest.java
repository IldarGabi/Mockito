package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.neetologyRepository.PosterRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PosterManagerTest {

    @Mock
    private PosterRepository repository;
    private PosterManager manager;
    private UpdatePoster movie1 = new UpdatePoster(1, 1);
    private UpdatePoster movie2 = new UpdatePoster(1, 2);
    private UpdatePoster movie3 = new UpdatePoster(1, 3);
    private UpdatePoster movie4 = new UpdatePoster(1, 4);
    private UpdatePoster movie5 = new UpdatePoster(1, 5);
    private UpdatePoster movie6 = new UpdatePoster(1, 6);
    private UpdatePoster movie7 = new UpdatePoster(1, 7);
    private UpdatePoster movie8 = new UpdatePoster(1, 8);
    private UpdatePoster movie9 = new UpdatePoster(1, 9);
    private UpdatePoster movie10 = new UpdatePoster(1, 10);
    private UpdatePoster movie11 = new UpdatePoster(1, 11);




    @Test
    void show10Movies() {
        UpdatePoster[] setMoc = new UpdatePoster[]{movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10};
        doReturn(setMoc).when(repository).findAll();
        PosterManager manager = new PosterManager(repository, 10);
        UpdatePoster[] expected = new UpdatePoster[]{movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10};
        UpdatePoster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
        System.out.println(Arrays.toString(actual));
    }

    @Test
    void show5Movies() {
        UpdatePoster[] setMoc = new UpdatePoster[]{movie1, movie2, movie3, movie4, movie5};
        doReturn(setMoc).when(repository).findAll();
        PosterManager manager = new PosterManager(repository, 5);
        UpdatePoster[] expected = new UpdatePoster[]{movie1, movie2, movie3, movie4, movie5};
        UpdatePoster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
        System.out.println(Arrays.toString(actual));
    }

    @Test
    void show11Movies() {
        UpdatePoster[] setMoc = new UpdatePoster[]{movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10,movie11};
        doReturn(setMoc).when(repository).findAll();
        PosterManager manager = new PosterManager(repository, 11);
        UpdatePoster[] expected = new UpdatePoster[]{movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10,movie11};
        UpdatePoster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
        System.out.println(Arrays.toString(actual));
    }

}