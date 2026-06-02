package com.devtalles.proyecto.command.solucion;

public class DefendCommand implements Command{
    Player player;

    public DefendCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute(){
        player.defend();
    }

    @Override
    public void undo() {
        System.out.println("Deje de defender");
    }
}
