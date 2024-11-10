package koha.onJoinDynmapUrl;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class OnJoinDynmapUrl extends JavaPlugin {

    private String mapURL;
    //URL送信オンオフ設定格納(未実装）
    private boolean sendURL = true;
    private JoinListener joinListener;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("OnJoinDynmapUrl is now enabled!");
        saveDefaultConfig();
        mapURL = getConfig().getString("URL");

        joinListener = new JoinListener(mapURL);
        //イベントリスナー登録
        getServer().getPluginManager().registerEvents(joinListener, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("OnJoinDynmapUrl is now disabled!");
    }

    //sendMapURLメソッド呼び出し
    public void sendMapURLToPlayer(Player player) {
        joinListener.sendMapURL(player);
    }
}
