package net.nospacehuman.mbc.util;

import com.google.gson.JsonObject;
import com.mojang.bridge.game.PackType;
import com.mojang.logging.LogUtils;
import net.minecraft.GameVersion;
import net.minecraft.SaveVersion;
import net.minecraft.SharedConstants;
import net.minecraft.util.JsonHelper;
import org.slf4j.Logger;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

public class PublicMinecraftVersion
        implements GameVersion {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final GameVersion CURRENT = new net.nospacehuman.mbc.util.PublicMinecraftVersion();
    private String id;
    private String name;
    private boolean stable;
    private SaveVersion saveVersion;
    private int protocolVersion;
    private int resourcePackVersion;
    private int dataPackVersion;
    private Date buildTime;
    private String releaseTarget;

    private void PublicMinecraftVersion() {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
        this.name = "1.18.2";
        this.stable = true;
        this.saveVersion = new SaveVersion(2975, "main");
        this.protocolVersion = SharedConstants.getProtocolVersion();
        this.resourcePackVersion = 8;
        this.dataPackVersion = 9;
        this.buildTime = new Date();
        this.releaseTarget = "1.18.2";
    }

    private void PublicMinecraftVersion(JsonObject json) {
        this.id = JsonHelper.getString(json, "id");
        this.name = JsonHelper.getString(json, "name");
        this.releaseTarget = JsonHelper.getString(json, "release_target");
        this.stable = JsonHelper.getBoolean(json, "stable");
        this.saveVersion = new SaveVersion(JsonHelper.getInt(json, "world_version"), JsonHelper.getString(json, "series_id", SaveVersion.MAIN_SERIES));
        this.protocolVersion = JsonHelper.getInt(json, "protocol_version");
        JsonObject jsonObject = JsonHelper.getObject(json, "pack_version");
        this.resourcePackVersion = JsonHelper.getInt(jsonObject, "resource");
        this.dataPackVersion = JsonHelper.getInt(jsonObject, "data");
        this.buildTime = Date.from(ZonedDateTime.parse(JsonHelper.getString(json, "build_time")).toInstant());
    }

    /*
     * Enabled aggressive exception aggregation
     */

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getReleaseTarget() {
        return this.releaseTarget;
    }

    @Override
    public SaveVersion getSaveVersion() {
        return this.saveVersion;
    }

    @Override
    public int getProtocolVersion() {
        return this.protocolVersion;
    }

    @Override
    public int getPackVersion(PackType packType) {
        return packType == PackType.DATA ? this.dataPackVersion : this.resourcePackVersion;
    }

    @Override
    public Date getBuildTime() {
        return this.buildTime;
    }

    @Override
    public boolean isStable() {
        return this.stable;
    }
}

