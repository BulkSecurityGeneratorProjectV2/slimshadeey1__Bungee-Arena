package mc.alk.bungeearena.CommandExec;

import mc.alk.bungeearena.*;
import mc.alk.bungeearena.Communication.*;
import net.md_5.bungee.api.*;
import net.md_5.bungee.api.config.*;
import net.md_5.bungee.api.connection.*;

import java.util.*;

/**
 * Created by Ben Byers on 7/16/2014.
 */
public class TeamExecutor {
    public TeamExecutor(CommandSender sender, String command, String[] args) {
        String option = args[0];
        String servername = Receiver.getGameMap().get(command.toLowerCase());
        ServerInfo server = Main.getPlugin().getProxy().getServerInfo(servername);
        String playername = sender.getName();
        ProxiedPlayer player = Main.getPlugin().getProxy().getPlayer(playername);
        ArrayList<String> arg = new ArrayList<>();
        for(String s:args){
            arg.add(s);
        }
        switch (option.toLowerCase()) { //TODO Change this to fit the needs of the team command
            case "join":
                try {
                    wait(3);
                    player.connect(server);
                }catch (Exception e){}
                new PlayerTransmitter(player, "BungeeCord", "BattleArenaCommand", command + ":" + args);
                break;
            case "leave":
                new Transmitter("BattleArenaCommand", command, playername,arg,server.getName());
                break;
            case "info":
                new Transmitter("BattleArenaCommand", command, playername,arg,server.getName());
                break;
            case "option":
                new Transmitter("BattleArenaCommand", command, playername,arg,server.getName());
                break;
            case "status":
                new Transmitter("BattleArenaCommand", command, playername,arg,server.getName());
                break;
            case "check":
                new Transmitter("BattleArenaCommand", command, playername,arg,server.getName());
                break;
        }
    }
}
