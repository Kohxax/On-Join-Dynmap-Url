package koha.onJoinDynmapUrl;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.ChatColor;

public class JoinListener implements Listener{

    private String mapURL;

    //mapURLのコンストラクタ
    public JoinListener(String mapURL) {
        this.mapURL = mapURL;
    }

    //URL送信メソッド
    public void sendMapURL(Player player) {
        player.sendMessage(ChatColor.GREEN + "DynmapURL : " + ChatColor.WHITE + mapURL);
    }

    //プレイヤーの接続を検知
    @EventHandler
    public void onPlayerJoinEvents(PlayerJoinEvent event) {
        sendMapURL(event.getPlayer());
    }
}
