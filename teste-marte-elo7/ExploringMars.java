import java.util.Scanner;
import exploration.*;

public class ExploringMars {

  public static void main(String[] args) {
    int field_x, field_y;

    try (Scanner reader = new Scanner(System.in)) {
      
      System.out.print("Insira a coordenada do canto direito superior do campo: ");
      field_x = reader.nextInt();
      field_y = reader.nextInt();
      reader.nextLine();

      /* Cria a instancia das coordenadas */
      Field field = new Field(field_x, field_y);

      /* implantação de sondas até que o usuário decida parar*/
      while (true) {
        
        System.out.println("Insira a coordenada e direção da sonda ou insira 'exit' para sair: ");
        String input = reader.nextLine();

        if (input.equals("exit")) {
          break;
        }
        

        /* Variaveis da sonda */
        int probe_x = Integer.parseInt(input.split(" ")[0]);
        int probe_y = Integer.parseInt(input.split(" ")[1]);
        char dir = input.split(" ")[2].charAt(0);

        /* Cria a instancia das sondas*/
        Direction direction = Direction.getDirection(dir);
        Position position = new Position(probe_x, probe_y);

        /* inserir sondas*/
        if (field.isAvailableSpace(probe_x, probe_y)) {
          Probe probe = new Probe(position, direction, field);
          Instructions instructions = new Instructions(reader.nextLine(), probe);

          /* instrucoes*/
          instructions.processInstructions();

          /* posição das sondas e alertas de erro*/
          System.out.println(probe.getFinalPosition());
        } else {
          System.out.println("Erro: espaço já ocupado ou fora dos limites do campo.");
        }
      }
    }

  }
}