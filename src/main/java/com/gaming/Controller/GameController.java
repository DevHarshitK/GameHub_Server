package com.gaming.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.gaming.Repository.GameRepository;
import com.gaming.Model.Game;

@RestController
@RequestMapping("/api/games")
@CrossOrigin(origins = "http://localhost:5173") // Allow frontend to connect
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @PostMapping
    public Game createGame(@RequestBody Game game) {
        return gameRepository.save(game);
    }

    @GetMapping("/{id}")
    public Optional<Game> getGameById(@PathVariable String id) {
        return gameRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Game updateGame(@PathVariable String id, @RequestBody Game game) {
        game.setId(id);
        return gameRepository.save(game);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable String id) {
        gameRepository.deleteById(id);
    }

    @GetMapping("/name/{name}")
    public Game getGameByName(@PathVariable String name) {
        return gameRepository.findByName(name);
    }
}