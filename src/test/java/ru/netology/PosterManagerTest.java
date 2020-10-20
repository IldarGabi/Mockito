package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {
    PosterManager manager = new PosterManager();
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


    private void assignValue() {
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);
        manager.add(movie8);
        manager.add(movie9);
        manager.add(movie10);
        manager.add(movie11);
    }

    @Test
    void showAllMovies() {
        assignValue();
        UpdatePoster[] expected = new UpdatePoster[]{movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        UpdatePoster[] actual = manager.getLimit();
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }


    @Test
    void show10Movies() {
        manager = new PosterManager(10);
        assignValue();
        UpdatePoster[] expected = new UpdatePoster[]{movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        UpdatePoster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }

    @Test
    void show5Movies() {
        manager = new PosterManager(5);
        assignValue();
        UpdatePoster[] expected = new UpdatePoster[]{movie5, movie4, movie3, movie2, movie1};
        UpdatePoster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }


    @Test
    void removeByIdMovies() {
        assignValue();
        manager.removeById(5);
        UpdatePoster[] expected = new UpdatePoster[]{movie11, movie10, movie9, movie8, movie7, movie6, movie4, movie3, movie2, movie1};
        UpdatePoster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }


    @Test
    void removeByNoIdMovies() {
        assignValue();
        manager.removeByNoId(-9999);
        UpdatePoster[] expected = new UpdatePoster[]{movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        UpdatePoster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }


    @Test
    void show0Movies() {
        manager = new PosterManager(0);
        UpdatePoster[] expected = new UpdatePoster[]{};
        UpdatePoster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }

    @Test
    void showUnder0Movies() {
        manager = new PosterManager(-5);
        assignValue();
        UpdatePoster[] expected = new UpdatePoster[]{movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        UpdatePoster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }

    @Test
    void showOverLimitMovies() {
        manager = new PosterManager(33);
        assignValue();
        UpdatePoster[] expected = new UpdatePoster[]{movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        UpdatePoster[] actual = manager.getLimit();
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }

}