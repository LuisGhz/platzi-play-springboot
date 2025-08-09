package dev.luisghtz.platzi_play.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.luisghtz.platzi_play.domain.services.PlatziPlayAIService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class HelloController {
  private final PlatziPlayAIService platziPlayAIService;

  @GetMapping()
  public String getMethodName() {
    return platziPlayAIService.generateGreeting();
  }

}
