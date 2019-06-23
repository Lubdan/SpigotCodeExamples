package lubdan.codeexamples.events;

import lubdan.codeexamples.CodeExamples;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    private CodeExamples CE; // variable to hold our main class instance we passed over
    public JoinEvent(CodeExamples instance){this.CE = instance;}  // the landing spot (constructor) for generating a new instance of this class, the variable sent along was the "this", then sets the variable to our class's variable.
    @EventHandler
    public void joinEvent(PlayerJoinEvent event){CE.lastplayer = event.getPlayer().getName();} // sets the variable lastplayer inside of our main class to the name of the joined player.





}
