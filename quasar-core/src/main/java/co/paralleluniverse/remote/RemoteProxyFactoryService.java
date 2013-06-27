/*
 * Quasar: lightweight threads and actors for the JVM.
 * Copyright (C) 2013, Parallel Universe Software Co. All rights reserved.
 * 
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 *  
 *   or (per the licensee's choosing)
 *  
 * under the terms of the GNU Lesser General Public License version 3.0
 * as published by the Free Software Foundation.
 */
package co.paralleluniverse.remote;

import co.paralleluniverse.actors.LocalActor;
import co.paralleluniverse.actors.RemoteActor;
import co.paralleluniverse.strands.channels.Channel;
import co.paralleluniverse.strands.channels.SendChannel;

/**
 *
 * @author pron
 */
public final class RemoteProxyFactoryService {
    private static final RemoteProxyFactory factory = ServiceUtil.loadSingletonService(RemoteProxyFactory.class);
    
    public static <Message> RemoteActor<Message> create(LocalActor<Message, ?> actor, Object globalId) {
        return factory.create(actor, globalId);
    }
    
    public static <Message> SendChannel<Message> create(Channel channel, Object globalId) {
        return factory.create(channel, globalId);
    }
    
    private RemoteProxyFactoryService() {
    }
}
