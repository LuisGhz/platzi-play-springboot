package dev.luisghtz.platzi_play;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PlatziPlayAIService {
  @UserMessage("""
      Genera un saludo de bienvenida a la plataforma de Gestión de Películas de PLatziPlay.
      Usa menos de 120 caracteres y hazlo con el estilo de Platzi.
      """)
  String generateGreeting();
}
