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

import net.lightstone.msg.EntityStatusMessage;

public final class EntityStatusCodec extends MessageCodec<EntityStatusMessage> {

	public EntityStatusCodec() {
		super(EntityStatusMessage.class, 0x26);
	}

	@Override
	public EntityStatusMessage decode(ChannelBuffer buffer) throws IOException {
		int id = buffer.readInt();
		int status = buffer.readUnsignedByte();
		return new EntityStatusMessage(id, status);
	}

	@Override
	public ChannelBuffer encode(EntityStatusMessage message) throws IOException {
		ChannelBuffer buffer = ChannelBuffers.buffer(5);
		buffer.writeInt(message.getId());
		buffer.writeByte(message.getStatus());
		return buffer;
	}

}
