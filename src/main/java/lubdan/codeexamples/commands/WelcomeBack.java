package lubdan.codeexamples.commands;

import lubdan.codeexamples.CodeExamples;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WelcomeBack implements CommandExecutor {

   private CodeExamples CE; // variable to hold our main class instance we passed over



    public WelcomeBack(CodeExamples CE){ // the landing spot (constructor) for generating a new instance of this class, the variable sent along was the "this"

        this.CE = CE; // sets this variable to the class's private variable.

    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){ // checks if a player is typing the command
            if(CE.lastplayer != null){ // ensures a player has joined

                String format = ChatColor.translateAlternateColorCodes('&', CE.getConfig().getString("Format")).replace("{NAME}", CE.lastplayer);// Provides support for & color coding, then pulls the string from our config file. Once that is done, it replaces "{NAME} with the player's IGN who joined.
                Player player = (Player) sender; // declares a player variable, because the CommandSender does not have a chat method.
                player.chat(format); // forces who ever sent the command to say the message
                return true; // command worked, so we return true
            }
            else{
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', CE.getConfig().getString("NoLastPlayer"))); // Grabs the message from the config (while supporting & color coding) if there is no latest player join
                return false; // command did not go as planned, so we returned false.
            }
            }
        else{
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', CE.getConfig().getString("Permission-Denied")));// Grabs the message from the config (while supporting & color coding) if the sender does not have permission.
            return false; // command did not go as planned, so we returned false.
        }



    }
}
