package dev.luisghtz.platzi_play.domain.services;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PlatziPlayAIService {
  @UserMessage("""
      Genera un saludo de bienvenida a la plataforma de Gestión de Películas de PLatziPlay.
      Usa menos de 120 caracteres y hazlo con el estilo de Platzi.
      """)
  String generateGreeting();

  @SystemMessage("""
          Eres un experto en cine que recomienda películas personalizadas según los gustos del usuario.
          Debes recomendar máximo 3 películas.
          No incluyas pe´luculas que estén por fuera de la plataforma PlatziPlay.|
          """)
  String generateMoviesSuggestions(@UserMessage String userMessage);
}
