/*
 * Copyright (c) 2010-2011 Graham Edgecombe.
 *
 * This file is part of Lightstone.
 *
 * Lightstone is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Lightstone is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Lightstone.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.lightstone.net.codec;

import java.io.IOException;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import net.lightstone.msg.DiggingMessage;

public final class DiggingCodec extends MessageCodec<DiggingMessage> {

	public DiggingCodec() {
		super(DiggingMessage.class, 0x0E);
	}

	@Override
	public DiggingMessage decode(ChannelBuffer buffer) throws IOException {
		int state = buffer.readUnsignedByte();
		int x = buffer.readInt();
		int y = buffer.readUnsignedByte();
		int z = buffer.readInt();
		int face = buffer.readUnsignedByte();
		return new DiggingMessage(state, x, y, z, face);
	}

	@Override
	public ChannelBuffer encode(DiggingMessage message) throws IOException {
		ChannelBuffer buffer = ChannelBuffers.buffer(11);
		buffer.writeByte(message.getState());
		buffer.writeInt(message.getX());
		buffer.writeByte(message.getY());
		buffer.writeInt(message.getZ());
		buffer.writeInt(message.getFace());
		return buffer;
	}

}
