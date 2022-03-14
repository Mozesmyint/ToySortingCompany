package mru.tsc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mru.tsc.controller.ToyManager;
import mru.tsc.model.Animals;
import mru.tsc.model.BoardGames;
import mru.tsc.model.Figures;
import mru.tsc.model.Puzzles;
import mru.tsc.model.Toys;

class ToysTest {
	String FILE_PATH = "res/toys.txt";
	ArrayList<Toys> tList = new ArrayList<>();
	Animals a = new Animals(2835360879L, "Cow", "Game Assassin", 19.52, 3, 7, "Plastic", 'M');
	BoardGames bg = new BoardGames(9074383778L, "Blue Max", "Gamearo", 199.37, 11, 2, "1-3", "Rojin Poole");
	Figures f = new Figures(1147205649L, "Ninja Turtles", "Gamezoid", 46.15, 10, 6, 'A');
	Puzzles p = new Puzzles(4731499724L, "Problem solving", "Game Sensor", 93.08, 11, 7, 'C');
	
	@BeforeEach
	void preface() throws IOException {
		ToyManager.loadToys(tList, FILE_PATH);
	}
	
	@Test
	void SNTest() throws IOException {
		for(Toys t : tList) {
			t.setSerialNumber(2804598463L);
			assertEquals(2804598463L, t.getSerialNumber());
		}
	}
	
	@Test
	void NameTest() throws IOException {
		for(Toys t : tList) {
			t.setName("monke");
			assertEquals("monke", t.getName());
		}
	}
	
	@Test
	void NameToSNTest() throws IOException {
		for(Toys t : tList) {
			if(t.getSerialNumber() == 3424511521L)
			assertEquals("Otter", t.getName());
		}
	}
	
	@Test
	void BrandToSNTest() {
		for(Toys t : tList) {
			if(t.getSerialNumber() == 1918096709L)
			assertEquals("Gameara", t.getBrand());
		}
	}
	
	@Test
	void AnimalsTest() {
		assertEquals("Plastic", a.getMaterial());
		assertEquals('M', a.getSize());
	}
	
	@Test
	void BoardGamesTest() {
		assertEquals("1-3", bg.getNumOfPlayers());
		assertEquals("Rojin Poole", bg.getDesigner());
	}
	
	@Test
	void FiguresTest() {
		assertEquals('A', f.getClassification());
	}
	
	@Test
	void PuzzlesTest() {
		assertEquals('C', p.getPuzzleType());
	}
}
