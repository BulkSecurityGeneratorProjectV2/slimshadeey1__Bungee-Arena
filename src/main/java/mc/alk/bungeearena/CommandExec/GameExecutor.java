package mc.alk.bungeearena.CommandExec;

import mc.alk.bungeearena.Communication.*;
import mc.alk.bungeearena.*;
import net.md_5.bungee.api.*;
import net.md_5.bungee.api.config.*;
import net.md_5.bungee.api.connection.*;

/**
 * Version 1.0
 * Created by Ben Byers on 7/16/2014.
 */
public class GameExecutor {
    public static boolean Execute(CommandSender sender, String command, String[] args) {
        String option = args[0];
        String servername = Receiver.getGameMap().get(command.toLowerCase());
        ServerInfo server = Main.getPlugin().getProxy().getServerInfo(servername);
        String playername = sender.getName();
        ProxiedPlayer player = Main.getPlugin().getProxy().getPlayer(playername);

        if (option.equalsIgnoreCase("join")) {
            player.connect(server);
            new PlayerTransmitter(player, "BungeeCord", "BattleArenaCommand", command + ":" + args);
            return true;
        } else if (option.equalsIgnoreCase("leave") | option.equalsIgnoreCase("info") | option.equalsIgnoreCase("result")) {
            new PlayerTransmitter(player, "BungeeCord", "BattleArenaCommand", command + ":" + args);
            return true;
        } else if (option.equalsIgnoreCase("options")) {
            new PlayerTransmitter(player, "BungeeCord", "BattleArenaCommand", command + ":" + args);
        }
        return false;
    }
}