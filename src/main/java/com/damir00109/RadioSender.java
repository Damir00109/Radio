package com.damir00109;

import de.maxhenkel.voicechat.api.ServerLevel;
import de.maxhenkel.voicechat.api.audiosender.AudioSender;
import de.maxhenkel.voicechat.api.VoicechatServerApi;

public class RadioSender implements AudioSender {
	private final int num;
	private final RadioChannel channel;
	private boolean active = true;

	public RadioSender(int index, RadioChannel channel, VoicechatServerApi api, ServerLevel level, int x, int y, int z) {
		VanillaDamir00109.LOGGER.info("Created Sender for index {}", index);
		num = index;
		this.channel = channel;
	}

	public RadioChannel getChannel() { return channel; }

	@Override
	public AudioSender whispering(boolean b) { return this; }
	@Override
	public boolean isWhispering() { return false; }
	@Override
	public AudioSender sequenceNumber(long l) { return this; }
	@Override
	public boolean canSend() { return true; }
	@Override
	public boolean reset() { return false; }

	public void setActive(boolean bool) { active = bool; }
	public boolean isActive() { return active; }

	public int getIndex() { return num; }

	@Override
	public boolean send(byte[] audio) {
		if (!isActive()) return false;
		channel.broadcast(audio);
		return true;
	}
}
