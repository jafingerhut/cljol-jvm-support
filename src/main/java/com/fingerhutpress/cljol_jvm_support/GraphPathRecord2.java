/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * Copyright (c) 2019 Andy Fingerhut
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.fingerhutpress.cljol_jvm_support;

import org.openjdk.jol.util.ObjectUtils;
import org.openjdk.jol.vm.VM;

/**
 * Object path in object graph.
 *
 * @author Aleksey Shipilev
 * @author Andy Fingerhut
 */
public class GraphPathRecord2 {
    private final int depth;
    private final Object obj;
    private final long size;
    /* TBD: Does making field 'address' volatile be better for
     * thread-safety of this class? */
    private volatile long address;

    GraphPathRecord2(int depth, Object obj) {
        this.obj = obj;
        this.depth = depth;
        this.size = VM.current().sizeOf(obj);
    }

    public Object obj() {
        return obj;
    }

    public Class<?> klass() {
        return obj.getClass();
    }

    public long size() {
        return size;
    }

    public long address() {
        return address;
    }

    public long recordAddress() {
        this.address = VM.current().addressOf(obj);
        return address;
    }

    public int depth() {
        return depth;
    }
}