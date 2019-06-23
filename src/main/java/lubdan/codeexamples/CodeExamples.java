package lubdan.codeexamples;

import lubdan.codeexamples.commands.WelcomeBack;
import lubdan.codeexamples.events.JoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class CodeExamples extends JavaPlugin {

   public String lastplayer; // our variable for who joined last


    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this); // registers our JoinEvent listener, while passing the main class's instance with it
        getCommand("WelcomeBack").setExecutor(new WelcomeBack(this)); //  registers the command class, while once again passing an instance of the main class.
        getConfig().options().copyDefaults(); // standard code to generate the config (next line as well)
        saveDefaultConfig();
    }
}
